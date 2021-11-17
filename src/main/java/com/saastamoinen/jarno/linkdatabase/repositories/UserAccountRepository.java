package com.saastamoinen.jarno.linkdatabase.repositories;

import java.util.Optional;

import com.saastamoinen.jarno.linkdatabase.models.UserAccount;

import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{

    Optional<UserAccount> findByUsername(String username);
    
}
