package com.saastamoinen.jarno.linkdatabase.services;

import java.util.List;
import java.util.Optional;

import com.saastamoinen.jarno.linkdatabase.models.Link;
import com.saastamoinen.jarno.linkdatabase.repositories.LinkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    /* Create */
    public void createLink(Link link) {
        linkRepository.save(link);
    }
    /* Read */
    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }
    public Optional<Link> getLinkById(Long id) {
        return linkRepository.findById(id);
    }
    
    public List<Link> findLinksByTag(String keyword) {
        return linkRepository.customFindByKeyWordIgnoringCase("%"+keyword+"%");
    }
    /* Update link*/
    public void updateLink(Link oldLink, Link newLink) {
        if (!newLink.getTitle().isBlank()) {
            oldLink.setTitle(newLink.getTitle());
        }
        if (!newLink.getDescription().isBlank()) {
            oldLink.setDescription(newLink.getDescription());
        }
        if (!newLink.getKeyword().isBlank()) {
            oldLink.setKeyword(newLink.getKeyword());
        }
        if (!newLink.getUrl().isBlank()) {
            oldLink.setUrl(newLink.getUrl());
        }
        linkRepository.save(oldLink);
    }
    /* Delete */
    public void deleteLink(Long id) {
        Optional<Link> linkToRemove = linkRepository.findById(id);
        if (linkToRemove.isPresent()) {
            linkRepository.delete(linkToRemove.get());
        }
    }
    
    
}
