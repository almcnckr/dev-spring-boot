package com.springboot.thymeleafcruddemo.dao;

import com.springboot.thymeleafcruddemo.entity.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByOrderByLastNameAsc();
}
