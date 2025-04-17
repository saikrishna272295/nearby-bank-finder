package com.sai.mapsservice.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlacesApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.sai.mapsservice.common.Bank;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoogleMapsService {

    private final GeoApiContext context;

    public GoogleMapsService(GeoApiContext context) {
        this.context = context;
    }

    public LatLng geocodeZipcode(String zipcode) {
        try {
            GeocodingResult[] results = GeocodingApi.geocode(context, zipcode).await();
            return results[0].geometry.location;
        } catch (Exception e) {
            throw new RuntimeException("Geocoding failed", e);
        }
    }

    public List<Bank> findNearbyBanks(LatLng location) {
        try {
            PlacesSearchResponse response = PlacesApi.nearbySearchQuery(context, location)
                    .radius(16093) // 10 miles in meters
                    .type(PlaceType.BANK)
                    .await();

            return Arrays.stream(response.results)
                    .map(place -> new Bank(place.name, place.vicinity))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Places search failed", e);
        }
    }
}

