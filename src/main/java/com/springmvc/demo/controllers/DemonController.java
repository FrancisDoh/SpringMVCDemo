package com.springmvc.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.springmvc.demo.models.Demon;
import com.springmvc.demo.services.DemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Specifies to send HTML page as response. Instead of API @RestController
@Controller
@RequestMapping("/demons") // home addr
public class DemonController {
    //
    @Autowired
    private DemonService _demonService;

    // Cstor is Optional
    @Autowired
    public DemonController(DemonService _demonService){
        this._demonService = _demonService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello"; // Returns the page based on the name from template
    }

    // Read All data
    // List or send or the demons to {listOfDemons.html}
    @GetMapping("/")
    public String displayAllDemons(Model model){
        List<Demon> demons = _demonService.getAllDemons();
        model.addAttribute("demons", demons);
        return "listOfDemons"; // Bcz every methods in MVC should return a String. Therefore, we need tomreturn this line of code.
    }

    // Add => Overloading method
    // This endpoint retrieve the submited  from {addDemon.html}
    @GetMapping("/add")
    public String addDemopn(Model model){
        model.addAttribute("demon", new Demon()); // Set it as new object
        return "addDemon";
    }

    // Send the form object to the backend/service {DemonServiceImpl.java}
    @PostMapping("/add")
    public String addDemon(@ModelAttribute("demon") @Valid Demon demon, Errors errors){
        if(errors.hasErrors()){
            return "addDemon";
        }
        _demonService.saveDemon(demon);
        return "redirect:/demons/";
    }

// Updating => overloading method
    @GetMapping("/edit/{id}")
    public String updateThisDemon(@PathVariable Long id, Model model){
        Demon demon = _demonService.getDemonById(id); // Retrieve the demon id from the backend
        model.addAttribute("demon", demon);

        return "editDemon";
    }

    //
    @PostMapping("/edit/{id}")
    public String updateThisDemon(@PathVariable Long id, @ModelAttribute("demon") @Valid Demon demon, Errors errors){
        if(errors.hasErrors()){
            return "editDemon";
        }
        _demonService.updateDemon(id, demon);
        return "redirect:/demons/";
    }

    // Deletion
    @GetMapping("/delete/{id}")
    public String deleteThisDemon(@PathVariable Long id){
        _demonService.deleteDemonById(id);
        return "redirect:/demons/";
    }
//    public String deleteThisDemon(@PathVariable Long id, @ModelAttribute("demon") @Valid Demon demon, Errors errors)
}
