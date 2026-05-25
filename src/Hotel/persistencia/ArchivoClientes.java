package Hotel.persistencia;

import Hotel.modelo.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoClientes {
    
    private String nombreArchivo = "clientes.txt";

    public void guardarCliente(Cliente cliente) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(cliente.getNombre() + "," +
                     cliente.getApellido() + "," +
                     cliente.getTipoDocumento() + "," +
                     cliente.getNumeroDocumento() + "," +
                     cliente.getTelefono() + "," +
                     cliente.getCorreo() + "," +
                     cliente.getNacionalidad());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
        }
    }

    public ArrayList<Cliente> leerClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 7) {
                    Cliente cliente = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
                    listaClientes.add(cliente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer clientes: " + e.getMessage());
        }

        return listaClientes;
    }
    
}
