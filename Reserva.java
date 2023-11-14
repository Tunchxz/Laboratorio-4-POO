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

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public boolean getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(boolean tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public int getcantidadBoletos() {
        return cantidadBoletos;
    }

    public void setcantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getnumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setnumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }

    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    public int getnumeroAsiento() {
        return numeroAsiento;
    }

    public void setnumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public int getcantidadMaletas() {
        return cantidadMaletas;
    }

    public void setcantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

    public String esConfirmada() {
        return esConfirmada;
    }

    public void setEsConfirmada(String esConfirmada) {
        this.esConfirmada = esConfirmada;
    }

    public String toCSV() {
        return fechaVuelo + "," + tipoVuelo + "," + cantidadBoletos + "," + aerolinea + "," + numeroTarjeta + ","
                + cuotas + "," + claseVuelo + "," + numeroAsiento + "," + cantidadMaletas + "," + esConfirmada;
    }

    public String toString() {
        return "Fecha de Vuelo: " + fechaVuelo + " | Tipo de Vuelo: " + tipoVuelo + " | Boletos: " + cantidadBoletos
                + " | Aerolinea: " + aerolinea + " | Tarjeta: " + numeroTarjeta + " | Cuotas: "
                + cuotas + " | Clase: " + claseVuelo + " | Asiento: " + numeroAsiento + " | Maletas: "
                + cantidadMaletas;
    }
}
