package com.saastamoinen.jarno.linkdatabase.repositories;

import com.saastamoinen.jarno.linkdatabase.models.UserAccount;

import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{
    
}
