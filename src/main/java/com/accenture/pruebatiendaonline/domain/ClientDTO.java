package com.accenture.pruebatiendaonline.domain;

import com.accenture.pruebatiendaonline.adapter.persistence.entity.Purchase;

import javax.persistence.Column;
import java.util.List;

public class ClientDTO {

    private String clientId;
    private String fullname;
    private String address;
    private List<PurchaseDTO> purchasesDTO;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PurchaseDTO> getPurchasesDTO() {
        return purchasesDTO;
    }

    public void setPurchasesDTO(List<PurchaseDTO> purchasesDTO) {
        this.purchasesDTO = purchasesDTO;
    }
}
