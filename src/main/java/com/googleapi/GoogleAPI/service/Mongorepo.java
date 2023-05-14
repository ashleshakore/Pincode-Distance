package com.googleapi.GoogleAPI.service;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface Mongorepo extends MongoRepository<Datavalue,String>{

	
	@Query("{ 'pincode1' : ?0, 'pincode2' : ?1 }")
    Datavalue findroute(String pincode1, String pincode2);

	void saveAll(Object calculate);
}
