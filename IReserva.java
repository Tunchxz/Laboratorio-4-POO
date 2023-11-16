public interface IReserva {
        /**
         * Inicia sesión en el sistema.
         *
         * @param username El nombre de usuario.
         * @param password La contraseña del usuario.
         * @return El usuario que inició sesión.
         */
        public Usuario login(String username, String password);

        /**
         * Registra un nuevo usuario en el sistema.
         *
         * @param username El nombre de usuario.
         * @param password La contraseña del usuario.
         * @param tipo     El tipo de cuenta del usuario.
         */
        public void registroUsuario(String username, String password, String tipo);

        /**
         * Cambia la contraseña del usuario.
         *
         * @param nuevaPassword La nueva contraseña del usuario.
         */
        public void cambiarPassword(String nuevaPassword);

        /**
         * Cambia el tipo de cuenta del usuario.
         */
        public void cambiarTipoUsuario();

        /**
         * Realiza una reserva para el usuario.
         *
         * @param fechaVuelo      La fecha del vuelo.
         * @param tipoVuelo       El tipo de vuelo.
         * @param cantidadBoletos La cantidad de boletos para el vuelo.
         * @param aerolinea       La aerolínea del vuelo.
         * @param username        El nombre de usuario.
         */
        public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea,
                        String username);

        /**
         * Confirma la reserva del usuario.
         *
         * @param numeroTarjeta   El número de tarjeta del cliente.
         * @param cuotas          El número de cuotas para el pago del vuelo.
         * @param claseVuelo      La clase del vuelo.
         * @param numeroAsiento   El número de asiento del cliente.
         * @param cantidadMaletas La cantidad de maletas del cliente.
         */
        public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento,
                        int cantidadMaletas);

        /**
         * Imprime el itinerario del usuario.
         *
         * @return El itinerario del usuario.
         */
        public String itinerario();

        /**
         * Guarda los usuarios en en CSV.
         */
        public void guardarUsuario();

        /**
         * Guarda las reservas de los usuarios en un CSV.
         */
        public void guardarReserva();

        /**
         * Lee los usuarios guardados en el CSV.
         */
        public void leerUsuario();

        /**
         * Lee las reservas realizadas por los usuarios.
         */
        public void leerReserva();
}