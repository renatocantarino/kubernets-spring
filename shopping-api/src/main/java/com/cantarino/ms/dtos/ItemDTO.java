package com.cantarino.ms.dtos;

import javax.validation.constraints.NotBlank;


public class ItemDTO
{
    @NotBlank
    private String productIdentifier;

    @NotBlank
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
