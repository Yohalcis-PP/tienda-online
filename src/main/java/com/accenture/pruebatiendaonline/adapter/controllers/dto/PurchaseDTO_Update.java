package com.accenture.pruebatiendaonline.adapter.controllers.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseDTO_Update {
    private int purchaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private List<PurchaseItemDTO_Save> items;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<PurchaseItemDTO_Save> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItemDTO_Save> items) {
        this.items = items;
    }
}
