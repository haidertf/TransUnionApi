package utilidades;

public enum EnumsMessage {
    REMEMBER_STATUS("Recodando el status");

    private final String key;

    EnumsMessage(String key) {
        this.key = key;
    }

    @Override
    public String toString() { return key; }
}
