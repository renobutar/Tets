package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getALL() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getById(Integer id) {
		return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee Tidak Ditemukan"));
	}

	@Override
	public Boolean save(Employee employee) {
		employeeRepository.save(employee);
		return employeeRepository.findById(employee.getId()).isPresent();
	}

	@Override
	public Boolean delete(Integer id) {
		employeeRepository.deleteById(id);
		return !employeeRepository.findById(id).isPresent();
	}
}
