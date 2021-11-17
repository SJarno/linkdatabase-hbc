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
    public List<Link> findLinksByTag(String keyword) {
        return linkRepository.findByKeyword(keyword);
    }
    /* Update */
    public void updateLink(Long id, Link link) {
        Optional<Link> linkToUpdate = linkRepository.findById(id);
        linkToUpdate.get().setTitle(link.getTitle());
        linkToUpdate.get().setDescription(link.getDescription());
        linkToUpdate.get().setKeyword(link.getKeyword());
        linkToUpdate.get().setUrl(link.getUrl());
        if (linkToUpdate.isPresent()) {
            linkRepository.save(linkToUpdate.get());
        }
    }
    /* Delete */
    public void deleteLink(Long id) {
        Optional<Link> linkToRemove = linkRepository.findById(id);
        if (linkToRemove.isPresent()) {
            linkRepository.delete(linkToRemove.get());
        }
    }
    
}
