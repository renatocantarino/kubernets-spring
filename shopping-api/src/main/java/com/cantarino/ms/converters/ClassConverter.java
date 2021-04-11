package com.cantarino.ms.converters;

import com.cantarino.ms.dtos.ShopDTO;
import com.cantarino.ms.models.Shop;
import org.modelmapper.ModelMapper;

public final class ClassConverter {

    public static ShopDTO ConvertToDTO(Shop shop) {
        ModelMapper _mapper = new ModelMapper();
        return _mapper.map(shop, ShopDTO.class);
    }

    public static Shop ConvertToEntity(ShopDTO shop) {
        ModelMapper _mapper = new ModelMapper();
        return _mapper.map(shop, Shop.class);
    }
}
