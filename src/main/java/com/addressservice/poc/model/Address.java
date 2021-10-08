package com.addressservice.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class Address {

    @Id
    int id;
    String profileId;
    String line1;
    String line2;
    String city;
    String state;
    int pincode;

}
