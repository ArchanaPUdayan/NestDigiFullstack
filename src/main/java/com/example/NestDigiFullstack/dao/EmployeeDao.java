package com.example.NestDigiFullstack.dao;

import com.example.NestDigiFullstack.Model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
