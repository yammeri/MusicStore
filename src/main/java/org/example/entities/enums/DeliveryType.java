package org.example.entities.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum DeliveryType {
    PICKUP("Pickup"), // самовывоз
    POINT_OF_ISSUE("Delivery to the point of issue"),
    BY_THE_ADDRESS("Delivery to address");

    private static final Logger logger = LogManager.getLogger(DeliveryStatus.class);
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
        Exception e = new IllegalAccessException("No such value");
        logger.error("Ошибка получения типа доставки из строки:\n" + e.getMessage());
        return null;
    }

    public String getValue() {
        return value;
    }
}