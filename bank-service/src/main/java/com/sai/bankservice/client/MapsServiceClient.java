package com.sai.bankservice.client;

import com.google.maps.model.LatLng;
import com.sai.bankservice.common.Bank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "maps-service", url = "${maps.service.url}")
public interface MapsServiceClient {

    @GetMapping("/maps/geocode")
    LatLng geocode(@RequestParam String zipcode);

    @GetMapping("/maps/nearby")
    List<Bank> findNearbyBanks(@RequestParam double lat,
                               @RequestParam double lng);
}

