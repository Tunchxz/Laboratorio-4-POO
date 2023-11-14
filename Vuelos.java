import java.util.ArrayList;
import java.io.*;

public class Vuelos implements IReserva {
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioActual;
    private Reserva reservaActual;

    public Vuelos() {
        usuarios = new ArrayList<>();
    }

    @Override
    public Usuario login(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                usuarioActual = usuario;
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void registroUsuario(String username, String password, String tipo) {
        Usuario nuevoUsuario = new Usuario(username, password, tipo);
        usuarios.add(nuevoUsuario);
    }

    @Override
    public void cambiarPassword(String nuevaPassword) {
        usuarioActual.setPassword(nuevaPassword);
    }

    @Override
    public void cambiarTipoUsuario() {
        usuarioActual.setTipoCuenta("VIP");
    }

    @Override
    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea,
            String username) {
        Reserva nuevaReserva = new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, "x", 0, "x", 0, 0,
                "No Confirmada");
        usuarioActual.getReservas().add(nuevaReserva);
        reservaActual = nuevaReserva;
    }

    @Override
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento,
            int cantidadMaletas) {
        if (reservaActual.esConfirmada() != "Confirmada") {
            reservaActual.setnumeroTarjeta(numeroTarjeta);
            reservaActual.setCuotas(cuotas);
            reservaActual.setClaseVuelo(claseVuelo);
            reservaActual.setnumeroAsiento(Integer.parseInt(numeroAsiento));
            reservaActual.setcantidadMaletas(cantidadMaletas);
            reservaActual.setEsConfirmada("Confirmada");
        }
    }

    @Override
    public String itinerario() {
        if (usuarioActual.getReservas().isEmpty()) {
            return "\n[Sistema]: No tienes reservas confirmadas aún.";
        }
        String itinerario = "\n--------------- Reservas (confirmadas) de " + usuarioActual.getUsername()
                + " ---------------";
        for (Reserva reserva : usuarioActual.getReservas()) {
            if (reserva.esConfirmada().equals("Confirmada")) {
                itinerario += "\n" + reserva.toString();
            }
        }
        return itinerario;
    }

    @Override
    public void guardarUsuario() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("usuarios.csv"))) {
            for (Usuario usuario : usuarios) {
                writer.println(usuario.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardarReserva() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("confirmaciones.csv"))) {
            for (Usuario usuario : usuarios) {
                for (Reserva reserva : usuario.getReservas()) {
                    writer.println(usuario.getUsername() + "," + reserva.toCSV());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leerUsuario() {
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.csv"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(",");
                String username = campos[0];
                String password = campos[1];
                String tipoCuenta = campos[2];
                Usuario usuario = new Usuario(username, password, tipoCuenta);
                usuarios.add(usuario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leerReserva() {
        try (BufferedReader reader = new BufferedReader(new FileReader("confirmaciones.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] campos = line.split(",");
                String username = campos[0];
                String fechaVuelo = campos[1];
                boolean tipoVuelo = Boolean.parseBoolean(campos[2]);
                int cantidadBoletos = Integer.parseInt(campos[3]);
                String aerolinea = campos[4];
                String numeroTarjeta = campos[5];
                int cuotas = Integer.parseInt(campos[6]);
                String claseVuelo = campos[7];
                int numeroAsiento = Integer.parseInt(campos[8]);
                int cantidadMaletas = Integer.parseInt(campos[9]);
                String esConfirmada = campos[10];

                Reserva nuevaReserva = new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, numeroTarjeta,
                        cuotas, claseVuelo, numeroAsiento, cantidadMaletas, esConfirmada);

                for (Usuario usuario : usuarios) {
                    if (usuario.getUsername().equals(username)) {
                        usuario.getReservas().add(nuevaReserva);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}