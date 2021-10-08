package com.addressservice.poc.dao;

import com.addressservice.poc.model.Address;
import reactor.core.publisher.Flux;

public interface AddressCustomRepository {

    Flux<Address> searchAddress(final String addressId, String profileId);

}
