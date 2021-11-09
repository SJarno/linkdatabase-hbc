package com.saastamoinen.jarno.linkdatabase.services;

import java.util.List;

import com.saastamoinen.jarno.linkdatabase.models.Link;
import com.saastamoinen.jarno.linkdatabase.repositories.LinkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public void createLink(Link link) {
        linkRepository.save(link);
    }
    public List<Link> getAllLinks() {
        return (List<Link>) linkRepository.findAll();
    }
    
}
