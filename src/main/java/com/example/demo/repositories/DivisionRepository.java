package com.example.demo.repositories;

import com.example.demo.models.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer>{
    
}
