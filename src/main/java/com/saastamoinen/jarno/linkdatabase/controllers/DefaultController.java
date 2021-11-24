package com.saastamoinen.jarno.linkdatabase.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.saastamoinen.jarno.linkdatabase.models.UserAccount;
import com.saastamoinen.jarno.linkdatabase.repositories.UserAccountRepository;
import com.saastamoinen.jarno.linkdatabase.services.LinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private LinkService linkService;

    @GetMapping("/index")
    public String showIndexPage(Model model) {
        model.addAttribute("links", linkService.getAllLinks());
        return "index";
    }
    

    /* Default user for testing */
    @Profile("testing")
    @PostConstruct
    public void init() {
        userAccountRepository.deleteAll();
        UserAccount userAccount = new UserAccount(
                "admin", passwordEncoder.encode("123"),
                new ArrayList<>(Arrays.asList("ROLE_ADMIN")));
        userAccountRepository.save(userAccount);
    }

}
