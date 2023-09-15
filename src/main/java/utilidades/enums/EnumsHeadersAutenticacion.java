package utilidades.enums;

public enum EnumsHeadersAutenticacion {
  ID("id", "P/PgwF1x2tg="),
  PET_ID("petId", "P/PgwF1x2tg="),
  QUANTITY("quantity", "P/PgwF1x2tg="),
  SHIP_DATE("shipDate", "2023-09-15T09:27:20.156Z"),
  STATUS("status", "placed"),
  COMPLETE("complete", ""),
  ACCEPT("accept", "application/json, text/plain, */*");
  private final String llave;
  private final String valor;

  EnumsHeadersAutenticacion(String llave, String valor) {
    this.llave = llave;
    this.valor = valor;
  }

  public String getLlave() {
    return llave;
  }

  public String getValor() {
    return valor;
  }

}
