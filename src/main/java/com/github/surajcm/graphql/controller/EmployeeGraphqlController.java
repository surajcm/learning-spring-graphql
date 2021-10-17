package com.github.surajcm.graphql.controller;

import com.github.surajcm.graphql.model.Department;
import com.github.surajcm.graphql.model.Employee;
import com.github.surajcm.graphql.repo.EmployeeRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Controller
public class EmployeeGraphqlController {
    private final EmployeeRepo repo;

    EmployeeGraphqlController(EmployeeRepo repo) {
        this.repo = repo;
    }

    @QueryMapping
    Flux<Employee> employees() {
        return this.repo.findAll();
    }

    @QueryMapping
    Flux<Employee> employeesByName(@Argument String name) {
        return this.repo.findByName(name);
    }

    @SchemaMapping(typeName = "Employee")
    Flux<Department> department(Employee employee) {
        var departments = new ArrayList<Department>();
        for (var departmentId = 1; departmentId <=(Math.random() * 100); departmentId++) {
            departments.add(new Department(departmentId,employee.name()));
        }
        return Flux.fromIterable(departments);
    }

    @MutationMapping
    Mono<Employee> addEmployee(@Argument String name) {
        return this.repo.save(new Employee(null, name, "STAFF", "LIAN LU"));
    }

}
