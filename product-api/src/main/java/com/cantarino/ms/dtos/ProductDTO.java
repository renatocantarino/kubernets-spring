package com.cantarino.ms.dtos;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDTO {

    @NotBlank(message = "{productIdentifier.not.blank}")
    private String productIdentifier;

    @NotBlank(message = "{name.not.blank}")
    private String nome;

    @NotBlank(message = "{preco.not.blank}")
    private Float preco;

    @NotBlank(message = "{category.not.blank}")
    private CategoryDTO category;


    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
