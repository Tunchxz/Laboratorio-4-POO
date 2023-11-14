import java.util.ArrayList;

public class Usuario {
    private String username;
    private String password;
    private String tipoCuenta;
    private ArrayList<Reserva> reservas;

    public Usuario(String username, String password, String tipoCuenta) {
        this.username = username;
        this.password = password;
        this.tipoCuenta = tipoCuenta;
        reservas = new ArrayList<Reserva>();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public String toCSV() {
        return username + "," + password + "," + tipoCuenta;
    }
}