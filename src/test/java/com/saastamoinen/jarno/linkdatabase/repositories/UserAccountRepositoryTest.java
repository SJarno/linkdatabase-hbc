package com.saastamoinen.jarno.linkdatabase.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.saastamoinen.jarno.linkdatabase.models.UserAccount;

import org.junit.jupiter.api.BeforeAll;
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
        //assertThat(userAccountRepository.findAll().size()).isZero();
        assertEquals(1, userAccountRepository.findAll().size());
        
    }
    
}
