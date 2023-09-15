package utilidades.enums.enumsRutasJson;

public enum EnumsRutasJson {
    RUTA_ID_TOKEN("body.IdToken"),
    RUTA_CODIGO_401("error.code"),
    RUTA_MSG_ESTADO("success");

    private final String endPoints;

    EnumsRutasJson(String endPoints) {
        this.endPoints = endPoints;
    }

    @Override
    public String toString() { return endPoints; }
}
