package com.addressservice.poc.dao;

import com.addressservice.poc.model.Address;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class AddressRepositoryImpl implements AddressCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public AddressRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Flux<Address> searchAddress(String addressId, String profileId) {

            try {

                List<Criteria> criterias = new ArrayList<>();
                Criteria dynamicCriteria = null;

                if (!StringUtil.isNullOrEmpty(addressId)) {
                    dynamicCriteria = Criteria.where("_id").is(Integer.parseInt(addressId));
                }
                if (!StringUtil.isNullOrEmpty(profileId)) {
                    dynamicCriteria = Criteria.where("line1").is(profileId);
                }
                criterias.add(dynamicCriteria);

                Criteria criteria = new Criteria().is(criterias.toArray(new Criteria[criterias.size()]));
                Query searchQuery = new Query();
                searchQuery.addCriteria(criteria);


                Criteria criteria1 = new Criteria();
                criteria1.orOperator(Criteria.where("_id").is(addressId),Criteria.where("profileId").is(profileId));
                Query query = new Query(criteria);

                Address ss = (Address) mongoTemplate.find(query, Address.class, "Address");


                List<Address> profileList = mongoTemplate.find(searchQuery, Address.class);
                return (Flux<Address>) profileList;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
}
