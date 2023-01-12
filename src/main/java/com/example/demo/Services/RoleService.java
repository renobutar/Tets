package com.example.demo.Services;

import java.util.List;

import com.example.demo.models.Role;


public interface RoleService{
    public List<Role> getALL();
    public Role getById(Integer id);
    public Boolean save(Role role);
    public Boolean delete(Integer id);  
}
