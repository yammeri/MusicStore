package org.example.entities.enums;

public enum DeliveryType {
    PICKUP("Pickup"), // самовывоз
    POINT_OF_ISSUE("Delivery to the point of issue"),
    BY_THE_ADDRESS("Delivery to address");

    private String value;

    private DeliveryType(String value) {
        this.value = value;
    }

    public static DeliveryType fromString(String value) throws IllegalAccessException {
        if (value != null) {
            for (DeliveryType dt : DeliveryType.values()) {
                if (value.equalsIgnoreCase(dt.value)) {
                    return dt;
                }
            }
        }
        throw new IllegalAccessException("No such value");
    }

    public String getValue() {
        return value;
    }
}