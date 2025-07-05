package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllPermanentEmployees() {
        return repo.getAllPermanentEmployees();
    }

    public double getAverageSalary(int id) {
        return repo.getAverageSalary(id);
    }

    public List<Employee> getAllEmployeesNative() {
        return repo.getAllEmployeesNative();
    }
}