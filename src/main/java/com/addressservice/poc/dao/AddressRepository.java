package com.addressservice.poc.dao;

import com.addressservice.poc.model.Address;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ReactiveMongoRepository<Address, Integer> {


}
