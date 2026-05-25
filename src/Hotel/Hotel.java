package Hotel;

import Hotel.modelo.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Hotel {

    public static void main(String[] args) {
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            String menu = "--- MENÚ GESTIÓN HOTELERA ---\n" +
                          "1. Registrar Cliente\n" +
                          "2. Ver Clientes Registrados\n" +
                          "3. Salir\n" +
                          "Seleccione una opción:";
            
            String opcion = JOptionPane.showInputDialog(menu);

            if (opcion == null || opcion.equals("3")) {
                continuar = false;
            } else {
                switch (opcion) {
                    case "1":
                        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
                        String dni = JOptionPane.showInputDialog("DNI:");
                        String hab = JOptionPane.showInputDialog("Tipo de habitación (Simple/Doble/Suite):");
                        
                        Cliente nuevo = new Cliente(nombre, dni, hab);
                        listaClientes.add(nuevo);
                        JOptionPane.showMessageDialog(null, "¡Cliente registrado con éxito!");
                        break;
                    case "2":
                        String lista = "CLIENTES REGISTRADOS:\n";
                        for (Cliente c : listaClientes) {
                            lista += c.toString() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, lista);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                }
            }
        }
    }
        
    }
    
}
