package com.programmingsharing.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employeeData")
public class EmployeeInfo {
    @Id
    public String id;
    public String employee_name;
    public String employee_salary;
    public String employee_age;
    public String profile_image;
}
