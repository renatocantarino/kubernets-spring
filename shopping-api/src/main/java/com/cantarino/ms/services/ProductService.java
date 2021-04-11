package com.cantarino.ms.services;

import com.cantarino.ms.dtos.ItemDTO;
import dtos.ProductoDTO;
import dtos.UsersDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductoDTO getByIdentifier(String identifier) {
        String url = "http://localhost:8081/product/" + identifier;

        RestTemplate _restTemplate = new RestTemplate();
        ResponseEntity<ProductoDTO> responseEntity = _restTemplate.getForEntity(url, ProductoDTO.class);
        return responseEntity.getBody();
    }


    public List<ProductoDTO> get(List<ItemDTO> items) {
        List<ProductoDTO> lista = new ArrayList<>();
        items
                .stream()
                .map(item -> getByIdentifier(item.getProductIdentifier())).forEach(produto -> {
            if (produto == null)
                throw new RuntimeException("Produto não encontrado!");
            lista.add(produto);
        });

        return lista;
    }
}
