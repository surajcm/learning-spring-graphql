package com.github.surajcm.graphql.controller;

import com.github.surajcm.graphql.Employee;
import com.github.surajcm.graphql.repo.EmployeeRepo;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

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

}
