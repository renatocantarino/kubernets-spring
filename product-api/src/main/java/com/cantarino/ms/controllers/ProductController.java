package com.cantarino.ms.controllers;

import com.cantarino.ms.dtos.ProductDTO;
import com.cantarino.ms.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProductDTO>> getProdutos()
    {
        return ResponseEntity.ok(productService.All());
    }

    @PostMapping("/produtos")
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO productDTO)
    {
        return new ResponseEntity<>(productService.Add(productDTO), HttpStatus.CREATED);
    }

    @GetMapping("/produtos/categoria/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Long categoryId)
    {
        return ResponseEntity.ok(productService.getByCategory(categoryId));
    }
}
