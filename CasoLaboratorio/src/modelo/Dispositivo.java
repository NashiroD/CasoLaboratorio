package modelo;
/**
 * @author Nashiro
 */
public class Dispositivo {

    private String Sede;
    private int NSerie;
    private String Equipo;
    private String Marca;
    private int Año;

    public String getSede() {
        return Sede;
    }

    public void setSede(String Sede) {
        this.Sede = Sede;
    }

    public int getNSerie() {
        return NSerie;
    }

    public void setNSerie(int NSerie) {
        this.NSerie = NSerie;
    }

    public String getEquipo() {
        return Equipo;
    }

    public void setEquipo(String Equipo) {
        this.Equipo = Equipo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

}