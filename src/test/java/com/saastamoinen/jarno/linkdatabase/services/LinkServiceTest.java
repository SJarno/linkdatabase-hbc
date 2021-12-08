package com.saastamoinen.jarno.linkdatabase.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.saastamoinen.jarno.linkdatabase.models.Link;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class LinkServiceTest {

    @Autowired
    private LinkService linkService;


    @MockBean
    private PasswordEncoder passwordEncoder;

    private Link link;
    private Link otherLink;
    private List<Link> links;

    @BeforeEach
    void setUp() {
        link = new Link("title", "description", "keyword", "url");
        otherLink = new Link();
        Link secondLink = new Link("title", "description", "Keyword", "url");
        Link thirdLink = new Link("title", "description", "KEYWORD", "url");
        links = new ArrayList<>(Arrays.asList(secondLink, thirdLink));
    }

    @Test
    void testCreateLinkAddsToDatabase() {
        assertEquals(0, linkService.getAllLinks().size());
        linkService.createLink(link);
        assertEquals(1, linkService.getAllLinks().size());
        assertEquals(link, linkService.getAllLinks().get(0));
        links.forEach(link -> linkService.createLink(link));
        assertEquals(3, linkService.getAllLinks().size());
    }
    @Test
    void testGetLinkById() {
        linkService.createLink(link);
        assertEquals(link, linkService.getLinkById(1L).get());
        assertNotEquals(otherLink, linkService.getLinkById(1L));
    }

    @Test
    void testFindLinksByTag() {

    }

    @Test
    void testGetAllLinks() {

    }

    @Test
    void testDeleteLink() {
        linkService.createLink(link);
        Link linkToRemove = linkService.getLinkById(1L).get();
        assertEquals(link, linkToRemove);
        linkService.deleteLink(1L);
        assertEquals(0, linkService.getAllLinks().size());
        links.forEach(link -> linkService.createLink(link));
        linkService.deleteLink(2L);
        assertEquals(1, linkService.getAllLinks().size());
        linkService.deleteLink(3L);
        assertEquals(0, linkService.getAllLinks().size());
    }


    @Test
    void testUpdateLink() {

    }
}
