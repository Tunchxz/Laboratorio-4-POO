/**
 * Clase Reserva que representa una reserva en el sistema.
 */
public class Reserva {
    private String fechaVuelo;
    private boolean tipoVuelo;
    private int cantidadBoletos;
    private String aerolinea;
    private String numeroTarjeta;
    private int cuotas;
    private String claseVuelo;
    private int numeroAsiento;
    private int cantidadMaletas;
    private String esConfirmada;

    /**
     * Construye una nueva reserva con los parámetros proporcionados.
     *
     * @param fechaVuelo      La fecha del vuelo.
     * @param tipoVuelo       El tipo de vuelo (true si es internacional, false si
     *                        es nacional).
     * @param cantidadBoletos La cantidad de boletos reservados.
     * @param aerolinea       La aerolínea de la reserva.
     * @param numeroTarjeta   El número de tarjeta de crédito utilizado para la
     *                        reserva.
     * @param cuotas          El número de cuotas para el pago.
     * @param claseVuelo      La clase del vuelo (ej. Primera Clase, Económica).
     * @param numeroAsiento   El número de asiento reservado.
     * @param cantidadMaletas La cantidad de maletas incluidas en la reserva.
     * @param esConfirmada    Indica si la reserva está confirmada o no.
     */
    public Reserva(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String numeroTarjeta,
            int cuotas,
            String claseVuelo, int numeroAsiento, int cantidadMaletas, String esConfirmada) {
        this.fechaVuelo = fechaVuelo;
        this.tipoVuelo = tipoVuelo;
        this.cantidadBoletos = cantidadBoletos;
        this.aerolinea = aerolinea;
        this.numeroTarjeta = numeroTarjeta;
        this.cuotas = cuotas;
        this.claseVuelo = claseVuelo;
        this.numeroAsiento = numeroAsiento;
        this.cantidadMaletas = cantidadMaletas;
        this.esConfirmada = esConfirmada;
    }

    /**
     * Obtiene la fecha del vuelo.
     *
     * @return La fecha del vuelo.
     */
    public String getFechaVuelo() {
        return fechaVuelo;
    }

    /**
     * Establece la fecha del vuelo.
     *
     * @param fechaVuelo La nueva fecha del vuelo.
     */
    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    /**
     * Obtiene el tipo de vuelo.
     *
     * @return El tipo de vuelo.
     */
    public boolean getTipoVuelo() {
        return tipoVuelo;
    }

    /**
     * Establece el tipo de vuelo.
     *
     * @param tipoVuelo El nuevo tipo de vuelo.
     */
    public void setTipoVuelo(boolean tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    /**
     * Obtiene la cantidad de boletos para el vuelo.
     *
     * @return La cantidad de boletos para el vuelo.
     */
    public int getcantidadBoletos() {
        return cantidadBoletos;
    }

    /**
     * Establece la cantidad de boletos para el vuelo.
     *
     * @param cantidadBoletos La nueva cantidad de boletos para el vuelo.
     */
    public void setcantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    /**
     * Obtiene la aerolínea del vuelo.
     *
     * @return La aerolínea del vuelo.
     */
    public String getAerolinea() {
        return aerolinea;
    }

    /**
     * Establece la aerolínea del vuelo.
     *
     * @param aerolinea La nueva aerolínea del vuelo.
     */
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    /**
     * Obtiene el número de tarjeta del cliente.
     *
     * @return El número de tarjeta del cliente.
     */
    public String getnumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Establece el número de tarjeta del cliente.
     *
     * @param numeroTarjeta El nuevo número de tarjeta del cliente.
     */
    public void setnumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Obtiene el número de cuotas para el pago del vuelo.
     *
     * @return El número de cuotas para el pago del vuelo.
     */
    public int getCuotas() {
        return cuotas;
    }

    /**
     * Establece el número de cuotas para el pago del vuelo.
     *
     * @param cuotas El nuevo número de cuotas para el pago del vuelo.
     */
    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    /**
     * Obtiene la clase del vuelo.
     *
     * @return La clase del vuelo.
     */
    public String getClaseVuelo() {
        return claseVuelo;
    }

    /**
     * Establece la clase del vuelo.
     *
     * @param claseVuelo La nueva clase del vuelo.
     */
    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    /**
     * Obtiene el número de asiento del cliente.
     *
     * @return El número de asiento del cliente.
     */
    public int getnumeroAsiento() {
        return numeroAsiento;
    }

    /**
     * Establece el número de asiento del cliente.
     *
     * @param numeroAsiento El nuevo número de asiento del cliente.
     */
    public void setnumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    /**
     * Obtiene la cantidad de maletas del cliente.
     *
     * @return La cantidad de maletas del cliente.
     */
    public int getcantidadMaletas() {
        return cantidadMaletas;
    }

    /**
     * Establece la cantidad de maletas del cliente.
     *
     * @param cantidadMaletas La nueva cantidad de maletas del cliente.
     */
    public void setcantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

    /**
     * Obtiene el estado de confirmación del vuelo.
     *
     * @return El estado de confirmación del vuelo.
     */
    public String esConfirmada() {
        return esConfirmada;
    }

    /**
     * Establece el estado de confirmación del vuelo.
     *
     * @param esConfirmada El nuevo estado de confirmación del vuelo.
     */
    public void setEsConfirmada(String esConfirmada) {
        this.esConfirmada = esConfirmada;
    }

    /**
     * Devuelve una representación en formato CSV de la reserva.
     *
     * @return Una cadena en formato CSV que representa la reserva.
     */
    public String toCSV() {
        return fechaVuelo + "," + tipoVuelo + "," + cantidadBoletos + "," + aerolinea + "," + numeroTarjeta + ","
                + cuotas + "," + claseVuelo + "," + numeroAsiento + "," + cantidadMaletas + "," + esConfirmada;
    }

    /**
     * Devuelve una representación en formato de cadena de la reserva.
     *
     * @return Una cadena que representa la reserva.
     */
    public String toString() {
        return "Fecha de Vuelo: " + fechaVuelo + " | Tipo de Vuelo: " + tipoVuelo + " | Boletos: " + cantidadBoletos
                + " | Aerolinea: " + aerolinea + " | Tarjeta: " + numeroTarjeta + " | Cuotas: "
                + cuotas + " | Clase: " + claseVuelo + " | Asiento: " + numeroAsiento + " | Maletas: "
                + cantidadMaletas;
    }
}