package com.programmingsharing.demo.controllers;

import com.programmingsharing.demo.model.EmployeeInfo;
import com.programmingsharing.demo.model.EmployeeResponse;
import com.programmingsharing.demo.services.EmployeeService;
import com.programmingsharing.demo.mapper.PersistToDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class EmployeeController {

    @Autowired
    private PersistToDB persistToDB;
    EmployeeService employeeService = new EmployeeService();

    @RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
    public EmployeeResponse allEmployeesMethod() {
        EmployeeResponse employeeResponse = employeeService.employeeResponse();
        persistToDB.persistToDB(employeeResponse);
        return employeeResponse;
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public EmployeeInfo getEmployee(@PathVariable (required = true, value = "id") String id) throws InterruptedException {
        return persistToDB.getById(id);
    }
}
