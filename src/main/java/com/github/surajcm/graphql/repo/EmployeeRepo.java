package com.github.surajcm.graphql.repo;

import com.github.surajcm.graphql.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepo extends ReactiveCrudRepository<Employee, Integer> {
    Flux<Employee> findByName(String name);
}
