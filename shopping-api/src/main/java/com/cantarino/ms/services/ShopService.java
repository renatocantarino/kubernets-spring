package com.cantarino.ms.services;

import com.cantarino.ms.converters.ClassConverter;
import com.cantarino.ms.dtos.ShopDTO;
import com.cantarino.ms.dtos.filters.ShopReportDTO;
import com.cantarino.ms.models.Shop;
import com.cantarino.ms.repositories.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private final ShopRepository shopRepository;
    private final ProductService productService;
    private final UserService userService;

    public ShopService(ShopRepository shopRepository,
                       ProductService productService , UserService userService) {
        this.shopRepository = shopRepository;
        this.productService = productService;
        this.userService = userService;
    }

    public List<ShopDTO> All() {
        List<Shop> vendas = shopRepository.findAll();
        return vendas
                .stream()
                .map(ClassConverter::ConvertToDTO)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> GetByUser(String Useridentifier) {
        List<Shop> vendas = shopRepository.findAllByUserIdentifier(Useridentifier);
        return vendas
                .stream()
                .map(ClassConverter::ConvertToDTO)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> GetByDate(ShopDTO shopDTO) {
        List<Shop> vendas = shopRepository.findAllByDateGreaterThan(shopDTO.getDate());
        return vendas
                .stream()
                .map(ClassConverter::ConvertToDTO)
                .collect(Collectors.toList());
    }


    public ShopDTO Add(ShopDTO shopDTO) {
        shopDTO.setTotal(shopDTO.Sum());
        shopRepository.save(ClassConverter.ConvertToEntity(shopDTO));
        return shopDTO;
    }

    public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo) {
        List<Shop> report = shopRepository.getReportByFilter(dataInicio, dataFim, valorMinimo);
        return report
                .stream()
                .map(ClassConverter::ConvertToDTO)
                .collect(Collectors.toList());
    }

    public ShopReportDTO getShopsByDate(Date dataInicio, Date dataFim) {
        return shopRepository.getReportByDate(dataInicio, dataFim);
    }

    public ShopDTO Save(ShopDTO shop)
    {
        userService.get(shop.getUserIdentifier());
        productService.get(shop.getItems());

    }



}

