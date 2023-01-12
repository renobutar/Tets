package com.example.demo.Services;
import java.util.List;
import com.example.demo.models.Division;


public interface DivisionService {
    public List<Division> getALL();
    public Division getById(Integer id);
    public Boolean save(Division division);
    public Boolean delete(Integer id);
}
