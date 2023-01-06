package com.backend.challenge.controller;

import com.backend.challenge.entity.Employee;
import com.backend.challenge.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployeList();
    }

    @PostMapping("/addEmployee")
    public List<Employee> addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("deleteEmployee/{id}")
    public List<Employee> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
        String response = employeeService.updateEmployee(employee);
        return response;
    }
}
