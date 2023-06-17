package org.example.entities.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum DeliveryStatus {
    IN_STOCK("Goods in stock"),
    BEING_DELIVERED("Goods is being delivered"),
    ARRIVED("Arrived at the destination");

    private static final Logger logger = LogManager.getLogger(DeliveryStatus.class);
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
        Exception e = new IllegalAccessException("No such value");
        logger.error("Ошибка получения статуса доставки из строки:\n" + e.getMessage());
        return null;
    }

    public String getValue() {
        return value;
    }
}