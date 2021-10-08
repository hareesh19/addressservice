package com.addressservice.poc.service;

import com.addressservice.poc.dao.AddressCustomRepository;
import com.addressservice.poc.dao.AddressRepository;
import com.addressservice.poc.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressCustomRepository addressCustomRepository
            ;


    public Mono<Address> createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Flux<Address> getAddress(String addressId, String profileId) {
        Mono<Address> add = addressRepository.findById(Integer.parseInt(addressId));

        return addressCustomRepository.searchAddress(addressId, profileId);
    }

    @Override
    public Mono<Address> findById(int id) {
        return null;
    }

    @Override
    public Mono<Void> deleteAddress(Integer id) {
        return null;
    }

    @Override
    public Mono<Address> updateAddress(Address address) {
        return null;
    }
}
