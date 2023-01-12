package com.example.demo.Services;

import java.util.List;

import com.example.demo.models.User;

public interface UserService {
    public List<User> getALL();
    public User getById(Integer id);
    public Boolean save(User user);
    public Boolean delete(Integer id);
}
