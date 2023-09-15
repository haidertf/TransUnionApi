package utilidades.enums;

public enum EnumsEndPoints {
    PLACE_AN_ORDER("/store/order"),
    FIND_PURCHASE_ORDER_BY_ID("/store/order/%s"),
    FIND_BY_STATUS("/pet/findByStatus?status=%s")

    ;
    private final String endPoints;

    EnumsEndPoints(String endPoints) {
        this.endPoints = endPoints;
    }

    @Override
    public String toString() { return endPoints; }
}
