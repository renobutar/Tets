package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Services.DivisionService;
import com.example.demo.Services.RegionService;
//import com.example.demo.daos.DivisionDao;
//import com.example.demo.daos.RegionDao;
import com.example.demo.models.Division;
//import com.example.demo.tools.DBConnection;

@Controller
@RequestMapping("division")
public class DivisionController {
    //private DivisionDao Ddao = new DivisionDao(DBConnection.getConnection());
    //private RegionDao rdao = new RegionDao(DBConnection.getConnection());
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private RegionService regionService;
    @GetMapping
    public String index(Model model) {
        model.addAttribute("divisions", divisionService.getALL());
        return "division/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String create(@PathVariable (required = false) Integer id, Model model){
        if(id != null){
            model.addAttribute("division", divisionService.getById(id));
            model.addAttribute("regions", regionService.getALL());
        } else {
            model.addAttribute("division", new Division());
            model.addAttribute("regions", regionService.getALL());
        }
        return "division/form";
    }

    @PostMapping("save")
    public String save(@Nullable Division division){
        Boolean result;
        if(division.getId() != null){
            result = divisionService.save(division);
        } else {
            result = divisionService.save(division);
        }
        if(result){
            return "redirect:/division";
        } else {
            return "division/form";
        }
    }

    //DELETE
    @PostMapping(value = {"delete/{id}"})
    public  String delete(@PathVariable Integer id){
        Boolean result = divisionService.delete(id);
        if(result){
            return "redirect:/division";
        } else {
            return "Failed Delete";
        }
    }
  
}
