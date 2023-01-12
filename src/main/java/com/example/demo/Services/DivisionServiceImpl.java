package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Division;
import com.example.demo.repositories.DivisionRepository;

@Service
public class DivisionServiceImpl implements DivisionService{
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> getALL() {
        return divisionRepository.findAll();
    }

    @Override
    public Division getById(Integer id) {
        return divisionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Division Tidak Ditemukan"));
    }

    @Override
    public Boolean save(Division division) {
        divisionRepository.save(division);
        return divisionRepository.findById(division.getId()).isPresent();
    }

    @Override
    public Boolean delete(Integer id) {
        divisionRepository.deleteById(id);
        return !divisionRepository.findById(id).isPresent();
    }

    
}
