package Hotel.modelo;

public class Habitacion {
    
    private int numero;
    private String tipo;
    private String estado;
    private double precio;

    public Habitacion() {
    }

    public Habitacion(int numero, String tipo, String estado, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
        this.precio = precio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Habitación " + numero + " - " + tipo + " - " + estado + " - S/ " + precio;
    }
    
    
    
}
