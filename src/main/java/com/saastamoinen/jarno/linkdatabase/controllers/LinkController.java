package com.saastamoinen.jarno.linkdatabase.controllers;

import java.util.List;

import javax.validation.Valid;

import com.saastamoinen.jarno.linkdatabase.models.Link;
import com.saastamoinen.jarno.linkdatabase.services.LinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LinkController {

    @Autowired
    private LinkService linkService;

    @ModelAttribute
    private Link getLink() {
        return new Link();
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
    /* get all links */
    @ResponseBody
    @RequestMapping(
        value = "links",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public List<Link> getAllLinks() {
        return linkService.getAllLinks();
    }
    /* get link by id */
    @ResponseBody
    @RequestMapping(
        value = "links/{id}",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public Link getLinkById(@PathVariable Long id) {
        return linkService.getLinkById(id);
    }

    /* Update */
    @PostMapping("/update-link/{id}")
    public void updateLink(@PathVariable Long id) {
        /* linkService.updateLink(id, link); */
        System.out.println();
        System.out.println("Tultiin oikeaan paikkaan!");
        System.out.println();
    }

    /* Delete */
    @DeleteMapping("/link/{id}")
    public void deleteLink(@PathVariable Long id) {
        linkService.deleteLink(id);
    } 
    
}
