package com.github.surajcm.graphql.repo;

import com.github.surajcm.graphql.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends ReactiveCrudRepository<Employee, Integer> {

}
