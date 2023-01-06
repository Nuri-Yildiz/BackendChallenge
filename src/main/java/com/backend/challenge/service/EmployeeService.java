package com.backend.challenge.service;

import com.backend.challenge.entity.Employee;
import com.backend.challenge.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> addEmployee(Employee employee){
        Employee employeeEntity = new Employee();
        employeeEntity.setCompany(employee.getCompany());
        employeeEntity.setName(employee.getName());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setPhoneNumber(employee.getPhoneNumber());
        employeeRepository.save(employeeEntity);
        return employeeRepository.findAll();
    };

    public List<Employee> getEmployeList(){
        return employeeRepository.findAll();
    }

    public List<Employee> deleteEmployee(Long employeeId){
        employeeRepository.delete(employeeRepository.findById(employeeId).get());
        return employeeRepository.findAll();
    }

    public String updateEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.findById(employee.getId()).get();
        newEmployee.setPhoneNumber(employee.getPhoneNumber());
        newEmployee.setName(employee.getName());
        newEmployee.setCompany(employee.getCompany());
        newEmployee.setEmail(employee.getEmail());
        employeeRepository.save(newEmployee);
        return "Çalışan Güncellendi.";
    }
}
