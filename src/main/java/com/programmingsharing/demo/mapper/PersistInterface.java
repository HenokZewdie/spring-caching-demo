package com.programmingsharing.demo.mapper;

import com.programmingsharing.demo.model.EmployeeInfo;

public interface PersistInterface {
    EmployeeInfo getById(String id) throws InterruptedException;
}
