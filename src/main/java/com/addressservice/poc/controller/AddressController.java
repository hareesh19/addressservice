package com.addressservice.poc.controller;

import com.addressservice.poc.model.Address;
import com.addressservice.poc.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;

@RestController
public class AddressController {
    

        @Autowired
        AddressService addressService;

        /**
         * The constant LOGGER.
         */
        private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

        @PostMapping("/addaddress")
        public Mono<Address> createAddress(@RequestBody Address address) {
        logger.info("create address request: {}", address);

        return addressService.createAddress(address);
    }

        @GetMapping("/getaddress")
        public Flux<Address> getAddress(@RequestParam(value = "addressId", required = false) String addressId,
                                        @RequestParam(value = "profileId", required = false) String profileId) {
        return addressService.getAddress(addressId, profileId);
    }
//
//        @PutMapping("/updateaddress")
//        public Mono<Address> update(@RequestBody Address Address) {
//        logger.info("update Address request: {}", Address);
//        return AddressService.updateAddress(Address);
//    }
//
//        @DeleteMapping("/Address/{id}")
//        public Mono<ResponseEntity<Void>> delete(@PathVariable(value = "id") Integer id) {
//        logger.info("delete Address request id :: {}", id);
//        return AddressService.findById(id)
//                .flatMap(existingAddress -> AddressService.deleteAddress(existingAddress.getId())
//                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT))))
//                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//        @GetMapping("/checkpermanentaccountnumber")
//        public Flux<Address> getAddress(
//            @RequestParam(value = "permanentAccountNumber", required = false) String permanentAccountNumber) {
//        return AddressService.checkPanNumber(permanentAccountNumber);
//
//    }

}
