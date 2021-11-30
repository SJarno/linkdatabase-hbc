package com.saastamoinen.jarno.linkdatabase.controllers;

import com.saastamoinen.jarno.linkdatabase.models.Link;
import com.saastamoinen.jarno.linkdatabase.services.AdminService;
import com.saastamoinen.jarno.linkdatabase.services.LinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private LinkService linkService;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        /* System.out.println();
        System.out.println("Adminissa");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getDetails());
        System.out.println(auth.getPrincipal());
        System.out.println(); */
        //model.addAttribute("links", linkService.getAllLinks());
        return "admin-page";
    }

    /* Update password */
    @PostMapping("/update-admin")
    public String updatePassword(
        @RequestParam String oldPassword, 
        @RequestParam String newPassword
        ) {
        adminService.updatePassword(oldPassword, newPassword);
        return "redirect:/admin";
    }

}
