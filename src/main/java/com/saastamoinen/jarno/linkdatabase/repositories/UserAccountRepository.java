package com.saastamoinen.jarno.linkdatabase.repositories;

import java.util.Optional;

import com.saastamoinen.jarno.linkdatabase.models.UserAccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{

    Optional<UserAccount> findByUsername(String username);
    
}
