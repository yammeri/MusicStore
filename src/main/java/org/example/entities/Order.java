package org.example.entities;

import org.example.entities.enums.DeliveryType;

import java.util.Date;

public class Order {
    private Long id;
    private Long customerId;
    private Date createDate;
    private String deliveryAddress;
    private DeliveryType deliveryType;

    public Order(Long id, Long customerId, Date createDate, String deliveryAddress, DeliveryType deliveryType) {
        this.id = id;
        this.customerId = customerId;
        this.createDate = createDate;
        this.deliveryAddress = deliveryAddress;
        this.deliveryType = deliveryType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}
