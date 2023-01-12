package com.example.demo.Services;
import java.util.List;
import com.example.demo.models.Employee;

public interface EmployeeService {
    public List<Employee> getALL();
    public Employee getById(Integer id);
    public Boolean save(Employee employee);
    public Boolean delete(Integer id);
}
