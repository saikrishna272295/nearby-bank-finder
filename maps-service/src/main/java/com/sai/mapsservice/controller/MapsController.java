package com.sai.mapsservice.controller;

import com.google.maps.model.LatLng;
import com.sai.mapsservice.common.Bank;
import com.sai.mapsservice.service.GoogleMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maps")
public class MapsController {

    @Autowired
    private GoogleMapsService mapsService;

    @GetMapping("/geocode")
    public LatLng geocode(@RequestParam String zipcode) {
        return mapsService.geocodeZipcode(zipcode);
    }

    @GetMapping("/nearby")
    public List<Bank> findNearbyBanks(@RequestParam double lat,
                                      @RequestParam double lng) {
        LatLng location = new LatLng(lat, lng);
        return mapsService.findNearbyBanks(location);
    }
}

