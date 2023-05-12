package com.googleapi.GoogleAPI.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.errors.ApiException;

@RestController
public class DirectionsController {
	String apiKey = "234567";
	DirectionsCalculator calculator = new DirectionsCalculator();
	
	@Autowired
    private PincodeService pincodeService;
	
	@Autowired
	private Mongorepo mongorepo;
	
	@PostMapping("/pincode/")
    public ResponseEntity<Datavalue> createUser(@RequestBody Datavalue data) {
        Datavalue saveddata = mongorepo.save(data);
        return ResponseEntity.ok(saveddata);
    }
	
	@GetMapping("/pincode/{pincode1}-{pincode2}/")
	public void route(@PathVariable String pincode1,@PathVariable String pincode2) throws InterruptedException, ApiException, IOException {
		Datavalue data = mongorepo.findroute(pincode1, pincode2);
		if (data != null) {
		    // routes exists
			//fetch data
		} else {
			//generate and save the routes and return the data(methods might differ)
			calculator.calculate(pincodeService.getCityNameFromPincode(pincode1), pincodeService.getCityNameFromPincode(pincode2));
		}
    
	}
}
