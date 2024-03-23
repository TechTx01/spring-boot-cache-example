package com.techtx.springbootcacheexample.controller;

import com.techtx.springbootcacheexample.model.Employee;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiController {


    @Cacheable(value="employees", key="#id")
    @RequestMapping("/employees/{id}")
    public List<Employee> getEmployee(@PathVariable String id)
    {
            Employee emp = new Employee(1,"techtx",22,"Dev");
            Employee emp1 = new Employee(2,"techtx1",24,"Test");

        System.out.println("In Controller");
        return List.of(emp,emp1).stream().filter(e->e.id() == Long.valueOf(id )).collect(Collectors.toList());

    }
}
