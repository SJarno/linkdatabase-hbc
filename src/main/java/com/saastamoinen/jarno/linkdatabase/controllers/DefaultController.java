package com.saastamoinen.jarno.linkdatabase.controllers;

import javax.annotation.PostConstruct;

import com.saastamoinen.jarno.linkdatabase.services.LinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private LinkService linkService;

    @GetMapping("/index")
    public String showIndexPage() {

        return "index";
    }


    @GetMapping("/link-page")
    public String showLinkPage(Model model) {
        model.addAttribute("links", linkService.getAllLinks());
        return "link-page";
    }

    /* Default user for testing */
    /* @PostConstruct
    public void init() {
        userAccountRepository.deleteAll();
        UserAccount userAccount = new UserAccount(
                "admin", passwordEncoder.encode("123"),
                new ArrayList<>(Arrays.asList("ROLE_ADMIN")));
        userAccountRepository.save(userAccount);
    } */

}
