package com.cantarino.ms.controllers;


import com.cantarino.ms.dtos.ShopDTO;
import com.cantarino.ms.services.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopController {

    private final ShopService shopService;
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/shopping")
    public ResponseEntity<List<ShopDTO>> getShop()
    {
        return ResponseEntity.ok(shopService.All());
    }

    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    public ResponseEntity<List<ShopDTO>> getShops(@PathVariable String userIdentifier) {
        return ResponseEntity.ok(shopService.GetByUser(userIdentifier));
    }

    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    public ResponseEntity<List<ShopDTO>> getShops(@RequestBody @Valid ShopDTO shopDTO) {
        return ResponseEntity.ok(shopService.GetByDate(shopDTO));
    }


    @PostMapping("/shopping")
    public  ResponseEntity<ShopDTO> create(@Valid @RequestBody ShopDTO shopDTO) {
        return new ResponseEntity<>(shopService.Add(shopDTO), HttpStatus.CREATED);
    }

}
