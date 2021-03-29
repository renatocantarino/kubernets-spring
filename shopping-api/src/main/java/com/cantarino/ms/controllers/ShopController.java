package com.cantarino.ms.controllers;


import com.cantarino.ms.dtos.ShopDTO;
import com.cantarino.ms.dtos.filters.ShopReportDTO;
import com.cantarino.ms.services.ShopService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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

    @GetMapping("/shopping/search")
    public ResponseEntity<List<ShopDTO>> getShopsByFilter(@RequestParam(name = "start")
                                                          @DateTimeFormat(pattern = "dd/MM/yyyy")Date inicio,
                                                          @RequestParam(name = "end" , required = false)
                                                          @DateTimeFormat(pattern = "dd/MM/yyyy")Date fim ,
                                                          @RequestParam(name = "valorMinimo" , required = false) Float valor) {
        return ResponseEntity.ok(shopService.getShopsByFilter(inicio , fim , valor ));
    }

    @GetMapping("/shopping/report")
    public ResponseEntity<ShopReportDTO> getReportByDate(@RequestParam(name = "dataInicio")
                                                         @DateTimeFormat(pattern = "dd/MM/yyyy") Date inicio,
                                                         @RequestParam(name = "dataFim")
                                                         @DateTimeFormat(pattern = "dd/MM/yyyy") Date fim) {
        return ResponseEntity.ok(shopService.getShopsByDate(inicio , fim));
    }


    @PostMapping("/shopping")
    public  ResponseEntity<ShopDTO> create(@Valid @RequestBody ShopDTO shopDTO) {
        return new ResponseEntity<>(shopService.Add(shopDTO), HttpStatus.CREATED);
    }

}
