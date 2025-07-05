package com.example;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Employee> emps = employeeService.getAllPermanentEmployees();
        emps.forEach(e -> {
            System.out.println("Employee: " + e.getName() + " Dept: " + (e.getDepartment() != null ? e.getDepartment().getName() : "null"));
            System.out.println("Skills: " + e.getSkillList());
        });

        double avg = employeeService.getAverageSalary(1);
        System.out.println("Average Salary in Dept 1: " + avg);

        List<Employee> allNative = employeeService.getAllEmployeesNative();
        allNative.forEach(e -> System.out.println("Native Employee: " + e.getName()));
    }
}