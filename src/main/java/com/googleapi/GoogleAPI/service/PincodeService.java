package com.googleapi.GoogleAPI.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.AddressComponentType;
//import com.google.maps.model.AddressType;
import com.google.maps.model.AddressType;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PincodeService {

    private final GeoApiContext context;

    public PincodeService() {
        // Create a new instance of the GeoApiContext with your API key
        context = new GeoApiContext.Builder()
                .apiKey("234567")
                .build();
    }

    public String getCityNameFromPincode(String pincode) throws ApiException, InterruptedException, IOException {
        // Create a GeocodingApi request to get the LatLng of the given pincode
        GeocodingResult[] results = GeocodingApi.geocode(context, pincode).await();
        LatLng location = results[0].geometry.location;

        // Create a reverse GeocodingApi request to get the city name from the LatLng
        results = GeocodingApi.reverseGeocode(context, location).await();
        for (GeocodingResult result : results) {
            for (AddressType type : result.types) {
                if (type == AddressType.LOCALITY) {
                    // Return the city name
                    return result.addressComponents[0].shortName;
                }
            }
        }

        // If no city name is found, return null
        return null;
    }
}
