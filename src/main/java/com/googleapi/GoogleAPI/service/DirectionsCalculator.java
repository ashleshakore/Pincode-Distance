package com.googleapi.GoogleAPI.service;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApi.Response;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.TravelMode;

import okhttp3.HttpUrl;
import okhttp3.Request;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import java.io.IOException;
import java.io.IOException;
import java.util.List;
import okhttp3.OkHttpClient;
public class DirectionsCalculator {

	    private static final String API_KEY = "your_api_key_here";

	    	OkHttpClient client = new OkHttpClient();
	    	//why this error ?
	    	public void calculate(String cityNameFromPincode, String cityNameFromPincode2) {
	        String origin = origin;
	        String destination = destination;
	        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + origin + "&destination=" + destination + "&key=" + API_KEY;

	        Request request = new Request.Builder()
	                .url(url)
	                .build();

	        okhttp3.Response response = client.newCall(request).execute();
	        String responseBody = response.body().string();

	        GeoApiContext context = new GeoApiContext.Builder()
	                .apiKey(API_KEY)
	                .build();

	        DirectionsApiRequest directionsRequest = DirectionsApi.getDirections(context, origin, destination)
	                .mode(TravelMode.DRIVING);

	        DirectionsResult directionsResult = directionsRequest.await();
	        Datavalue.Response directionApiResponse = new Datavalue.Response(directionsResult);
            //Ask doubt 
	       System.out.println(directionsResult);
	    


		
			// TODO Auto-generated method stub
			
		}

//    public void calculate(String origin, String destination) throws ApiException, InterruptedException, IOException {
//        DirectionsApiRequest request = DirectionsApi.newRequest(context)
//                .origin(origin)
//                .destination(destination)
//                .mode(TravelMode.DRIVING)
//                .alternatives(true);
//        DirectionsResult result = request.await();
//        DirectionsRoute[] routes = result.routes;
//        for (DirectionsRoute route : routes) {
//            DirectionsLeg leg = route.legs[0];
//            System.out.println("Distance: " + leg.distance);
//            System.out.println("Time: " + leg.duration);
//        }
//    }
}
