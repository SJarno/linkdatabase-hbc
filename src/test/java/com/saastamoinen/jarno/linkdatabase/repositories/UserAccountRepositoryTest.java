package com.saastamoinen.jarno.linkdatabase.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.saastamoinen.jarno.linkdatabase.models.UserAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
public class UserAccountRepositoryTest {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @BeforeEach
    void setUp() {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("Mikko");
        userAccount.setPassword("salasana");
        userAccountRepository.save(userAccount);
    }

    @Test
    void testFindByUsername() {
        assertEquals(1, userAccountRepository.findAll().size());
        assertEquals("Mikko", userAccountRepository.findByUsername("Mikko").get().getUsername());
        assertNotEquals("Miko", userAccountRepository.findByUsername("Mikko").get().getUsername());
        
    }
    
}
