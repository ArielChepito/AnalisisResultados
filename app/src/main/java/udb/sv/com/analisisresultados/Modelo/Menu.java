package udb.sv.com.analisisresultados.Modelo;

/**
 * Created by Ariel on 9/9/2017.
 */

public class Menu {
    private String Titulo;
    private String Descripcion;
    private String Clase;

    public Menu() {
    }

    public Menu(String titulo, String descripcion, String clase) {
        Titulo = titulo;
        Descripcion = descripcion;
        Clase = clase;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getClase() {
        return Clase;
    }

    public void setClase(String clase) {
        Clase = clase;
    }

    @Override
    public String toString() {
        return Titulo;
    }
}
