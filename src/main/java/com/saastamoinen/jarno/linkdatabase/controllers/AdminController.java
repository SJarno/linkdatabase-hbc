package com.saastamoinen.jarno.linkdatabase.controllers;

import javax.validation.Valid;

import com.saastamoinen.jarno.linkdatabase.models.Link;
import com.saastamoinen.jarno.linkdatabase.services.LinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {

    @Autowired
    private LinkService linkService;

    @ModelAttribute
    private Link getLink() {
        return new Link();
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin-page";
    }
    @PostMapping("/add-link")
    public String addLink(@Valid @ModelAttribute Link link, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin-page";
        }
        linkService.createLink(link);
        return "redirect:/admin";
    }
    
}
