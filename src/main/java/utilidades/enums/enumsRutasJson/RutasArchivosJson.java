package utilidades.enums.enumsRutasJson;

public enum RutasArchivosJson {
    JSON_FILES_DIR("src/test/resources/schema/");

    private final String text;

    RutasArchivosJson(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
