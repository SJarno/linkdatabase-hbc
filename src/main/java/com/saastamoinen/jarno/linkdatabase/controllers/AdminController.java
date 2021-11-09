package com.saastamoinen.jarno.linkdatabase.controllers;

import com.saastamoinen.jarno.linkdatabase.models.Link;
import com.saastamoinen.jarno.linkdatabase.services.LinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/admin")
    public String adminPage() {
        return "admin-page";
    }
    @PostMapping("/admin")
    public String addLink(@ModelAttribute Link link) {
        linkService.createLink(link);
        return "redirect:/admin";
    }
    
}
