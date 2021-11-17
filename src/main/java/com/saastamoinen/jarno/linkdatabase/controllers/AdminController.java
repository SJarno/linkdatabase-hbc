package com.saastamoinen.jarno.linkdatabase.controllers;

import java.util.List;

import javax.validation.Valid;

import com.saastamoinen.jarno.linkdatabase.models.Link;
import com.saastamoinen.jarno.linkdatabase.services.LinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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
    /* Create */
    @PostMapping("/add-link")
    public String addLink(@Valid @ModelAttribute Link link, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin-page";
        }
        linkService.createLink(link);
        return "redirect:/admin";
    }
    /* Read */
    @ResponseBody
    @RequestMapping(
        value = "links",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public List<Link> getAllLinks() {
        return linkService.getAllLinks();
    }

    /* Update */
    @PutMapping("/update-link/{id}")
    public void updateLink(Long id, @ModelAttribute Link link) {
        linkService.updateLink(id, link);
    }

    /* Delete */
    @DeleteMapping("/link/{id}")
    public void deleteLink(@PathVariable Long id) {
        linkService.deleteLink(id);
    } 
    
}
