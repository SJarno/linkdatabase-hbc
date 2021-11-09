package com.saastamoinen.jarno.linkdatabase.controllers;

import com.saastamoinen.jarno.linkdatabase.services.LinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("links", linkService.getAllLinks());
        return "index";
    }
    
}
