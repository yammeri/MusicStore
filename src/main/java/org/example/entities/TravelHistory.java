package org.example.entities;

import org.example.entities.enums.DeliveryStatus;

import java.util.Date;

public class TravelHistory {
    private Long id;
    private Long orderId;
    private String curAddress;
    private Date curTravelDate;
    private DeliveryStatus curStatus;

    public TravelHistory(Long id, Long orderId, String curAddress, Date curTravelDate, DeliveryStatus curStatus) {
        this.id = id;
        this.orderId = orderId;
        this.curAddress = curAddress;
        this.curTravelDate = curTravelDate;
        this.curStatus = curStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCurAddress() {
        return curAddress;
    }

    public void setCurAddress(String curAddress) {
        this.curAddress = curAddress;
    }

    public Date getCurTravelDate() {
        return curTravelDate;
    }

    public void setCurTravelDate(Date curTravelDate) {
        this.curTravelDate = curTravelDate;
    }

    public DeliveryStatus getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(DeliveryStatus curStatus) {
        this.curStatus = curStatus;
    }
}
