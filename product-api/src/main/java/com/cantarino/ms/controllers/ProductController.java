package com.cantarino.ms.controllers;

import com.cantarino.ms.dtos.ProductDTO;
import com.cantarino.ms.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProductDTO>> getUsuarios()
    {
        return ResponseEntity.ok(productService.All());
    }
}
