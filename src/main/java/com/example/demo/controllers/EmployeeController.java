package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Services.EmployeeService;
import com.example.demo.Services.UserService;
import com.example.demo.models.Employee;
import com.example.demo.models.User;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.getALL());   
        return "employee/index";
    }
    @GetMapping(value = {"form"})
    public String create(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("employee", new Employee());
        return "employee/form";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Employee employee, @ModelAttribute User user){
        Boolean result,result1;
        result = employeeService.save(employee);
        user.setId(employee.getId());
        result1 = userService.save(user);
        if(result && result1){
            return "redirect:/employee";
        } else {
            return "employee/form";
        }
    }
}
