package utilidades;

public enum EnumDescripcion {
  ID_TOKEN_GUARDADO("Id Token Almacenado"),
  TARJETA_CREDITO("Tarjeta de crédito"),
  PROPIO("propio");

  private String token;

  EnumDescripcion(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }
}
