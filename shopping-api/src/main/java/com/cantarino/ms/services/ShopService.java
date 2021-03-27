package com.cantarino.ms.services;

import com.cantarino.ms.dtos.ShopDTO;
import com.cantarino.ms.models.Shop;
import com.cantarino.ms.repositories.ShopRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private final ShopRepository shopRepository;
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopDTO> All()
    {
        List<Shop> vendas = shopRepository.findAll();
        return vendas
                .stream()
                .map(this::ConvertToDTO)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> GetByUser(String Useridentifier)
    {
        List<Shop> vendas = shopRepository.findAllByUserIdentifier(Useridentifier);
        return vendas
                .stream()
                .map(this::ConvertToDTO)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> GetByDate(ShopDTO shopDTO)
    {
        List<Shop> vendas = shopRepository.findAllByDateGreaterThan(shopDTO.getDate());
        return vendas
                .stream()
                .map(this::ConvertToDTO)
                .collect(Collectors.toList());
    }


    public ShopDTO Add(ShopDTO shopDTO)
    {
        shopDTO.setTotal(shopDTO.Sum());
        shopRepository.save(ConvertToEntity(shopDTO));
        return shopDTO;
    }

    private ShopDTO ConvertToDTO(Shop shop) {
        ModelMapper _mapper = new ModelMapper();
        return _mapper.map(shop, ShopDTO.class);
    }

    private Shop ConvertToEntity(ShopDTO shop) {
        ModelMapper _mapper = new ModelMapper();
        return _mapper.map(shop, Shop.class);
    }
}
