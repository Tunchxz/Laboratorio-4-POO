import java.util.ArrayList;

/**
 * Clase Usuario que representa a un usuario en el sistema.
 */
public class Usuario {
    private String username;
    private String password;
    private String tipoCuenta;
    private ArrayList<Reserva> reservas;

    /**
     * Constructor de la clase Usuario.
     *
     * @param username   El nombre de usuario.
     * @param password   La contraseña del usuario.
     * @param tipoCuenta El tipo de cuenta del usuario.
     */
    public Usuario(String username, String password, String tipoCuenta) {
        this.username = username;
        this.password = password;
        this.tipoCuenta = tipoCuenta;
        reservas = new ArrayList<Reserva>();
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param username El nuevo nombre de usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password La nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Establece el tipo de cuenta del usuario.
     *
     * @param tipoCuenta El nuevo tipo de cuenta del usuario.
     */
    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Obtiene el tipo de cuenta del usuario.
     *
     * @return El tipo de cuenta del usuario.
     */
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * Obtiene las reservas del usuario.
     *
     * @return Las reservas del usuario.
     */
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Convierte los datos del usuario a formato CSV.
     *
     * @return Una cadena en formato CSV con los datos del usuario.
     */
    public String toCSV() {
        return username + "," + password + "," + tipoCuenta;
    }
}