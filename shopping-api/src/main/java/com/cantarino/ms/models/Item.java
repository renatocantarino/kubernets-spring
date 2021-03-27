package com.cantarino.ms.models;

import javax.persistence.Embeddable;

//uma classe embeddable depedende de uma
//classe Entity para sobreviver
// item compõe shop
// Usada apenas em Classes
@Embeddable
public class Item {

    private String productIdentifier;
    private Float price;

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
