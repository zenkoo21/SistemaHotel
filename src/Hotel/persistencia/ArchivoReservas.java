package Hotel.persistencia;

import Hotel.modelo.Cliente;
import Hotel.modelo.Habitacion;
import Hotel.modelo.Reserva;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoReservas {
    
    private String nombreArchivo = "reservas.txt";

    public void guardarReserva(Reserva reserva) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(reserva.getCodigo() + "," +
                     reserva.getCliente().getNombre() + "," +
                     reserva.getCliente().getApellido() + "," +
                     reserva.getHabitacion().getNumero() + "," +
                     reserva.getFechaIngreso() + "," +
                     reserva.getFechaSalida() + "," +
                     reserva.getEstado());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar reserva: " + e.getMessage());
        }
    }

    public ArrayList<Reserva> leerReservas() {
        ArrayList<Reserva> listaReservas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    Cliente cliente = new Cliente();
                    cliente.setNombre(datos[1]);
                    cliente.setApellido(datos[2]);

                    Habitacion habitacion = new Habitacion();
                    habitacion.setNumero(Integer.parseInt(datos[3]));

                    Reserva reserva = new Reserva(
                            datos[0],
                            cliente,
                            habitacion,
                            datos[4],
                            datos[5],
                            datos[6]
                    );
                    listaReservas.add(reserva);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer reservas: " + e.getMessage());
        }

        return listaReservas;
    }
    
}
