package utilidades.enums;
public enum Timer {
    START_TIME("Tiempo Inicial");
    private final String time;

    Timer(String time) {
        this.time = time;
    }

    @Override
    public String toString() { return time; }
}
