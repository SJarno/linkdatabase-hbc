package com.saastamoinen.jarno.linkdatabase.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.saastamoinen.jarno.linkdatabase.models.Link;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
public class LinkRepositoryTest {

    @Autowired
    private LinkRepository linkRepository;

    private List<Link> links;

    @BeforeEach
    void setUp() {
        Link linkOne = new Link("title", "description", "keyword", "url");
        Link linkTwo = new Link("title", "description", "Keyword", "url");
        Link linkThree = new Link("title", "description", "keyWord", "url");
        Link linkFour = new Link("title", "description", "keyworD", "url");
        Link linkFive = new Link("title", "description", "KEYWORD", "url");
        links = new ArrayList<>(Arrays.asList(
                linkOne, linkTwo, linkThree, linkFour, linkFive));

        linkRepository.saveAll(links);
    }

    @Test
    @DisplayName("Test that correct amount of links found and ignores case")
    void testCustomFindByKeyWordIgnoringCase() {
        assertEquals(5, linkRepository.customFindByKeyWordIgnoringCase("%keyword%").size());

    }

}
