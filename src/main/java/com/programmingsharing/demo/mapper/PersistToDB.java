package com.programmingsharing.demo.mapper;

import com.programmingsharing.demo.model.EmployeeInfo;
import com.programmingsharing.demo.model.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersistToDB {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Value("${demo.wait.duration:3000}")
    private long waitDuration;

    public void persistToDB(EmployeeResponse employeeResponse){
        for (EmployeeInfo employeeInfo: employeeResponse.getData()) {
            mongoTemplate.save(employeeInfo);
        }
    }

    //@Cacheable(cacheNames = "getEmployeeWithCache", key = "#id10")
    @Cacheable(value="getEmployeeWithCache", key = "#id")
    public EmployeeInfo getById(String id) throws InterruptedException {
        Thread.sleep(waitDuration);
        return mongoTemplate.findById(id, EmployeeInfo.class);
    }
}
