public record RespuestaAPI(String result,
                           String base_code,
                           String time_last_update_utc,
                           TiposDeCambio conversion_rates) {
}
