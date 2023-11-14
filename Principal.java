import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Vuelos vuelos = new Vuelos();
        vuelos.leerUsuario();
        vuelos.leerReserva();
        Scanner scanner = new Scanner(System.in);
        Usuario usuarioActual = null;
        Random random = new Random();
        boolean ciclo = true;

        while (ciclo) {
            if (usuarioActual == null) {
                System.out.println("\n--------------- Bienvenido a Kayak ---------------");
                System.out.println("1. Modo registro");
                System.out.println("2. Iniciar Sesión");
                System.out.println("3. Salir");
            } else if (usuarioActual.getTipoCuenta().equals("Gratis")) {
                System.out.println("\n--------------- Kayak: Menu Principal ---------------");
                System.out.println("1. Modo reservas");
                System.out.println("2. Modo confirmación");
                System.out.println("3. Itinerario");
                System.out.println("4. Modo perfil");
                System.out.println("5. Cambiar a plan premium");
                System.out.println("6. Cerrar Sesión");
            } else { // Usuario premium
                System.out.println("\n--------------- Kayak: Menu Principal ---------------");
                System.out.println("1. Modo reservas");
                System.out.println("2. Modo confirmación");
                System.out.println("3. Itinerario");
                System.out.println("4. Modo perfil");
                System.out.println("5. Cerrar Sesión");
            }
            System.out.println("[Sistema]: Por favor, selecciona una opción:");

            String opcionStr = scanner.nextLine();
            if (!esCadenaNumeroValida(opcionStr)) {
                System.out.println("\n[Sistema]: Por favor, ingrese una entrada válida.");
                continue;
            }
            int opcion = Integer.parseInt(opcionStr);

            if (usuarioActual == null) {
                switch (opcion) {
                    case 1:
                        System.out.println("\n[Sistema]: Introduce el nombre de usuario:");
                        String username = scanner.nextLine();
                        System.out.println("[Sistema]: Introduce la contraseña:");
                        String password = scanner.nextLine();
                        System.out.println("[Sistema]: Selecciona el plan:\n1. Gratis\n2. VIP");

                        String tipoStr = scanner.nextLine();
                        if (!esCadenaNumeroValida(tipoStr)) {
                            System.out.println("\n[Sistema]: Por favor, ingrese una entrada válida.");
                            break;
                        }
                        int tipo = Integer.parseInt(tipoStr);

                        switch (tipo) {
                            case 1: {
                                vuelos.registroUsuario(username, password, "Gratis");
                                break;
                            }
                            case 2: {
                                vuelos.registroUsuario(username, password, "VIP");
                                break;
                            }
                            default: {
                                System.out.println("\n[Sistema]: Lo sineto, registro inválido." + tipo
                                        + " no es una opción del menú.");
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("\n[Sistema]: Introduce el nombre de usuario:");
                        username = scanner.nextLine();
                        System.out.println("[Sistema]: Introduce la contraseña:");
                        password = scanner.nextLine();
                        usuarioActual = vuelos.login(username, password);
                        if (usuarioActual == null) {
                            System.out.println("\n[Sistema]: Nombre de usuario o contraseña incorrectos.");
                        } else {
                            System.out.println("\n[Sistema]: Has iniciado sesión correctamente.");
                        }
                        break;
                    case 3:
                        System.out.println("\n[Sistema]:Gracias por usar nuestros servicios. ¡Vuelve pronto!");
                        vuelos.guardarReserva();
                        vuelos.guardarUsuario();
                        ciclo = false;
                        break;
                    default:
                        System.out.println("\n[Sistema]: Opción no válida. Por favor, intenta de nuevo.");
                        break;

                }
            } else if (usuarioActual.getTipoCuenta().equals("Gratis")) {
                switch (opcion) {
                    case 1:
                        System.out.println("\n[Sistema]: Introduce la fecha del vuelo:");
                        String fechaVuelo = scanner.nextLine();
                        System.out.println("[Sistema]: Introduce la cantidad de boletos:");
                        int cantidadBoletos = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("[Sistema]: Introduce el nombre de la aerolínea:");
                        String aerolinea = scanner.nextLine();
                        System.out.println("[Sistema]: ¿Es un vuelo de ida y vuelta?\n1. Si\n2. No");

                        String tipoVueloStr = scanner.nextLine();
                        if (!esCadenaNumeroValida(tipoVueloStr)) {
                            System.out.println("\n[Sistema]: Por favor, ingrese una entrada válida.");
                            break;
                        }
                        int tipoVuelo = Integer.parseInt(tipoVueloStr);

                        if (tipoVuelo > 2 || tipoVuelo < 1) {
                            System.out.println(
                                    "\n[Sistema]: Lo sentimos. Resrva inválida. Debes seleccionar una opción de las dadas.");
                            break;
                        }

                        switch (tipoVuelo) {
                            case 1: {
                                vuelos.reservacion(fechaVuelo, true, cantidadBoletos, aerolinea,
                                        usuarioActual.getUsername());
                                break;
                            }
                            case 2: {
                                vuelos.reservacion(fechaVuelo, false, cantidadBoletos, aerolinea,
                                        usuarioActual.getUsername());
                                break;
                            }
                        }
                        System.out.println("\n[Sistema]: Has reservado tu vuelo correctamente.");
                        System.out.println(
                                "[Sistema]: Recuerda confirmar esta reservación o la perderás al crear una nueva o cerrar sesión.");
                        break;
                    case 2:
                        System.out.println("\n[Sistema]: Introduce el número de tarjeta:");
                        String numeroTarjeta = scanner.nextLine();
                        System.out.println("[Sistema]: Introduce la cantidad de cuotas (hasta 24 cuotas):");

                        String cuotasStr = scanner.nextLine();
                        if (!esCadenaNumeroValida(cuotasStr)) {
                            System.out.println("\n[Sistema]: Por favor, ingrese una entrada válida.");
                            break;
                        }
                        int cuotas = Integer.parseInt(cuotasStr);

                        if (cuotas > 24 || cuotas < 1) {
                            System.out.println(
                                    "\n[Sistema]: Lo sentimos. Resrva inválida. Debes ingresar una cantidad de cuotas válida.");
                            break;
                        }
                        String claseVuelo = "";
                        System.out.println("[Sistema]: Introduce la clase del vuelo:\n1. Coach\n2. Primera Clase");

                        String optVueloStr = scanner.nextLine();
                        if (!esCadenaNumeroValida(optVueloStr)) {
                            System.out.println("\n[Sistema]: Por favor, ingrese una entrada válida.");
                            break;
                        }
                        int optVuelo = Integer.parseInt(optVueloStr);

                        if (optVuelo < 1 || optVuelo > 2) {
                            System.out.println(
                                    "\n[Sistema]: Lo sentimos. Resrva inválida. Debes ingresar una clase de vuelo válida.");
                            break;
                        } else if (optVuelo == 1) {
                            claseVuelo = "Coach";
                        } else if (optVuelo == 2) {
                            claseVuelo = "Primera Clase";
                        }
                        int numeroAleatorio = random.nextInt(200) + 1;
                        String numeroAsiento = "" + numeroAleatorio;
                        vuelos.confirmacion(numeroTarjeta, cuotas, claseVuelo, numeroAsiento, 1);
                        System.out.println("\n[Sistema]: Has confirmnado tu vuelo correctamente.");
                        break;
                    case 3:
                        System.out.println(vuelos.itinerario());
                        break;
                    case 4:
                        System.out.println("\n--------------- Ajustes de Perfil ---------------");
                        System.out.println("1. Cambiar contraseña");
                        System.out.println("2. Cambiar tipo de cuenta a premium");
                        System.out.println("3. Ingresar cupon de descuento");
                        System.out.println("4. Salir");
                        System.out.println("[Sistema]: Por favor, selecciona una opción:");

                        String opcionPerfilStr = scanner.nextLine();
                        if (!esCadenaNumeroValida(opcionPerfilStr)) {
                            System.out.println("\n[Sistema]: Por favor, ingrese una entrada válida.");
                            continue;
                        }
                        int opcionPerfil = Integer.parseInt(opcionPerfilStr);

                        switch (opcionPerfil) {
                            case 1:
                                System.out.println("\n[Sistema]:Introduce la nueva contraseña:");
                                String nuevaPassword = scanner.nextLine();
                                vuelos.cambiarPassword(nuevaPassword);
                                System.out.println("\n[Sistema]: Has cambiado tu contraseña correctamente.");
                                break;
                            case 2:
                                vuelos.cambiarTipoUsuario();
                                System.out.println("\n[Sistema]: Has cambiado tu plan correctamente.");
                                break;
                            case 3:
                                System.out.println("\n[Sistema]: Ingresa tu cupon de descuento:");
                                scanner.nextLine();
                                System.out.println("\n[Sistema]: Cupón del 10% de descuento aplicado.");
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("\n[Sistema]:Opción no válida. Por favor, intenta de nuevo.");
                                break;
                        }
                        break;
                    case 5:
                        vuelos.cambiarTipoUsuario();
                        System.out.println("\n[Sistema]: Has cambiado tu plan correctamente.");
                        break;
                    case 6:
                        usuarioActual = null;
                        System.out.println("\n[Sistema]: Has cerrado sesión correctamente.");
                        break;
                    default:
                        System.out.println("\n[Sistema]: Opción no válida. Por favor, intenta de nuevo.");
                        break;
                }
            } else { // Usuario premium
                switch (opcion) {
                    case 1:
                        System.out.println("\n[Sistema]: Introduce la fecha del vuelo:");
                        String fechaVuelo = scanner.nextLine();
                        System.out.println("[Sistema]: Introduce la cantidad de boletos:");

                        String cantidadBoletosStr = scanner.nextLine();
                        if (!esCadenaNumeroValida(cantidadBoletosStr)) {
                            System.out.println("\n[Sistema]: Por favor, ingrese una entrada válida.");
                            break;
                        }
                        int cantidadBoletos = Integer.parseInt(cantidadBoletosStr);

                        System.out.println("[Sistema]: Introduce el nombre de la aerolínea:");
                        String aerolinea = scanner.nextLine();
                        System.out.println("[Sistema]: ¿Es un vuelo de ida y vuelta?\n1. Si\n2. No");

                        String tipoVueloStr = scanner.nextLine();
                        if (!esCadenaNumeroValida(tipoVueloStr)) {
                            System.out.println("\n[Sistema]: Por favor, ingrese una entrada válida.");
                            break;
                        }
                        int tipoVuelo = Integer.parseInt(tipoVueloStr);

                        if (tipoVuelo > 2 || tipoVuelo < 1) {
                            System.out.println(
                                    "\n[Sistema]: Lo sentimos. Resrva inválida. Debes seleccionar una opción de las dadas.");
                            break;
                        }

                        switch (tipoVuelo) {
                            case 1: {
                                vuelos.reservacion(fechaVuelo, true, cantidadBoletos, aerolinea,
                                        usuarioActual.getUsername());
                                break;
                            }
                            case 2: {
                                vuelos.reservacion(fechaVuelo, false, cantidadBoletos, aerolinea,
                                        usuarioActual.getUsername());
                                break;
                            }
                        }
                        System.out.println("\n[Sistema]: Has reservado tu vuelo correctamente.");
                        System.out.println(
                                "[Sistema]: Recuerda confirmar esta reservación o la perderás al crear una nueva o cerrar sesión.");
                        break;
                    case 2:
                        System.out.println("\n[Sistema]: Introduce el número de tarjeta:");
                        String numeroTarjeta = scanner.nextLine();
                        System.out.println("[Sistema]: Introduce el número de asiento que desea:");
                        String numeroAsiento = scanner.nextLine();
                        System.out.println("[Sistema]: Introduce la cantidad de maletas que llevara:");

                        String cantidadMaletasStr = scanner.nextLine();
                        if (!esCadenaNumeroValida(cantidadMaletasStr)) {
                            System.out.println("\n[Sistema]: Por favor, ingrese una entrada válida.");
                            break;
                        }
                        int cantidadMaletas = Integer.parseInt(cantidadMaletasStr);

                        vuelos.confirmacion(numeroTarjeta, 1, "Primera Clase", numeroAsiento, cantidadMaletas);
                        System.out.println("\n[Sistema]: Has confirmnado tu vuelo correctamente.");
                        break;
                    case 3:
                        System.out.println(vuelos.itinerario());
                        break;
                    case 4:
                        System.out.println("\n--------------- Ajustes de Perfil ---------------");
                        System.out.println("1. Cambiar contraseña");
                        System.out.println("2. Salir");
                        System.out.println("[Sistema]: Por favor, selecciona una opción:");

                        String opcionPerfilStr = scanner.nextLine();
                        if (!esCadenaNumeroValida(opcionPerfilStr)) {
                            System.out.println("\n[Sistema]: Por favor, ingrese una entrada válida.");
                            continue;
                        }
                        int opcionPerfil = Integer.parseInt(opcionPerfilStr);

                        switch (opcionPerfil) {
                            case 1:
                                System.out.println("Introduce la nueva contraseña:");
                                String nuevaPassword = scanner.nextLine();
                                vuelos.cambiarPassword(nuevaPassword);
                                System.out.println("\n[Sistema]: Has cambiado tu contraseña correctamente.");
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("\n[Sistema]: Opción no válida. Por favor, intenta de nuevo.");
                                break;
                        }
                        break;
                    case 5:
                        usuarioActual = null;
                        System.out.println("\n[Sistema]: Has cerrado sesión correctamente.");
                        break;
                    default:
                        System.out.println("\n[Sistema]: Opción no válida. Por favor, intenta de nuevo.");
                        break;
                }
            }
        }
        scanner.close();
    }

    private static boolean esCadenaNumeroValida(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}