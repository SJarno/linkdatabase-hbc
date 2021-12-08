package com.saastamoinen.jarno.linkdatabase.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.saastamoinen.jarno.linkdatabase.models.Link;
import com.saastamoinen.jarno.linkdatabase.services.LinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @PostMapping("/link/add")
    public String addLink(
        @Valid @ModelAttribute Link newLink, 
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin-page";
        }
        linkService.createLink(newLink);
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
    /* Get link by tag names */
    @ResponseBody
    @RequestMapping(
        value = "links/search/{tag}",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public List<Link> getLinksByTag(@PathVariable String tag) {
        return linkService.findLinksByTag(tag);
    }

    /* get link by id */
    @ResponseBody
    @RequestMapping(
        value = "links/{id}",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public Link getLinkById(@PathVariable Long id) {
        return linkService.getLinkById(id).get();
    }

    /* Update */
    @PostMapping("/update-link/{id}")
    public String updateLink(@PathVariable Long id,
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String description,
        @RequestParam(required = false) String keyword,
        @RequestParam(required = false) String url) {
        
        Optional<Link> oldLink = linkService.getLinkById(id);
        if (oldLink.isPresent()) {
            Link newLink = new Link(title, description, keyword, url);
            linkService.updateLink(oldLink.get(), newLink);
            return "redirect:/admin";
        }
        return "admin-page";
        
        
    }

    /* Delete */
    @PostMapping("/delete-link/{id}")
    public String deleteLink(@PathVariable Long id) {
        linkService.deleteLink(id);
        return "redirect:/admin";
    } 
    
}
