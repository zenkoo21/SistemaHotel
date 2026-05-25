package Hotel.persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {
    
     private String nombreArchivo = "usuarios.txt";

    public boolean validarCredenciales(String usuario, String contrasena) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String usuarioArchivo = datos[0];
                    String contrasenaArchivo = datos[1];

                    if (usuarioArchivo.equals(usuario) && contrasenaArchivo.equals(contrasena)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer usuarios: " + e.getMessage());
        }
        return false;
    }
    
}
