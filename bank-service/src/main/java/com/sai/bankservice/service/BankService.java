package com.sai.bankservice.service;

import com.google.maps.model.LatLng;
import com.sai.bankservice.common.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sai.bankservice.client.MapsServiceClient;

import java.util.List;

@Service
public class BankService {

    private final MapsServiceClient mapsClient;

    @Autowired
    public BankService(MapsServiceClient mapsClient) {
        this.mapsClient = mapsClient;
    }

    public List<Bank> findNearbyBanks(String zipcode) {
        LatLng location = mapsClient.geocode(zipcode);
        return mapsClient.findNearbyBanks(location.lat, location.lng);
    }
}

