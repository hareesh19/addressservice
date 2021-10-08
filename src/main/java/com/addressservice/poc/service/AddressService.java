package com.addressservice.poc.service;

import com.addressservice.poc.model.Address;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface AddressService {

    public Mono<Address> createAddress(Address address);

    public Flux<Address> getAddress(String addressId, String profileId);

    Mono<Address> findById(int id);

    Mono<Void> deleteAddress(Integer id);

    public Mono<Address> updateAddress(Address address);

}
