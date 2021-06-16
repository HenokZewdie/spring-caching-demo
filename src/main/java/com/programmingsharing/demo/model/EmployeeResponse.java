package com.programmingsharing.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeResponse {
    public String status;
    public List<EmployeeInfo> data;
}
