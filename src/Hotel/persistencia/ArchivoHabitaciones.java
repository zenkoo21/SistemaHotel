package Hotel.persistencia;

import Hotel.modelo.Habitacion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoHabitaciones {
    
    private String nombreArchivo = "habitaciones.txt";

    public void guardarHabitacion(Habitacion habitacion) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(habitacion.getNumero() + "," +
                     habitacion.getTipo() + "," +
                     habitacion.getEstado() + "," +
                     habitacion.getPrecio());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar habitación: " + e.getMessage());
        }
    }

    public ArrayList<Habitacion> leerHabitaciones() {
        ArrayList<Habitacion> listaHabitaciones = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    Habitacion habitacion = new Habitacion(
                            Integer.parseInt(datos[0]),
                            datos[1],
                            datos[2],
                            Double.parseDouble(datos[3])
                    );
                    listaHabitaciones.add(habitacion);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer habitaciones: " + e.getMessage());
        }

        return listaHabitaciones;
    }
    
}
