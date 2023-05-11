package entities;

public enum DeliveryStatus {
    IN_STOCK("Goods in stock"),
    BEING_DELIVERED("Goods is being delivered"),
    ARRIVED("Arrived at the destination");

    private String value;

    private DeliveryStatus(String value) {
        this.value = value;
    }

    public static DeliveryStatus fromString(String value) throws IllegalAccessException {
        if (value != null) {
            for (DeliveryStatus ds : DeliveryStatus.values()) {
                if (value.equalsIgnoreCase(ds.value)) {
                    return ds;
                }
            }
        }
        throw new IllegalAccessException("No such value");
    }

    public String getValue() {
        return value;
    }
}