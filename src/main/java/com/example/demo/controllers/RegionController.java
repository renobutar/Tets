package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Services.RegionService;

import com.example.demo.models.Region;


@Controller
@RequestMapping("region")
public class RegionController {
   
    @Autowired
    private RegionService  regionService;

    // CREATE
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("regions", regionService.getALL());
        return "region/index";
    }

    // CREATE
    // GET
    @GetMapping(value = {"form", "form/{id}"})
    public String create(@PathVariable(required = false) Integer id, Model model){
        if(id != null){
            model.addAttribute("region", regionService.getById(id));
        } else {
            model.addAttribute("region", new Region());
        }
        return "region/form";
    }

    // POST
    @PostMapping("save")
    public String save(@Nullable Region region){
        Boolean result;
        if(region.getId() != null){
            result = regionService.save (region);
        } else {
            result = regionService.save(region);
        }
        if(result){
            return "redirect:/region";
        } else {
            return "region/form";
        }
    }

    //DELETE
    @PostMapping(value = {"delete/{id}"})
    public  String delete(@PathVariable Integer id){
        Boolean result = regionService.delete(id);
        if(result){
            return "redirect:/region";
        } else {
            return "Failed Delete";
        }
    }
}
