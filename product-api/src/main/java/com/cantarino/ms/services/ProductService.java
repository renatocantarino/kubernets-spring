package com.cantarino.ms.services;

import com.cantarino.ms.dtos.ProductDTO;
import com.cantarino.ms.models.Product;
import com.cantarino.ms.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> All() {

        return productRepository.findAll()
                                .stream()
                                .map(this::ConvertToDTO)
                                .collect(Collectors.toList());
    }

    private ProductDTO ConvertToDTO(Product user) {
        return new ModelMapper().map(user , ProductDTO.class);
    }

    public List<ProductDTO> getByCategory(Long categoryId) {

        return productRepository.findByCategory_Id(categoryId)
                .stream()
                .map(this::ConvertToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO Add(ProductDTO productDTO) {
        Product product =  new ModelMapper().map(productDTO , Product.class);
        productRepository.save(product);

        return productDTO;
    }
}
