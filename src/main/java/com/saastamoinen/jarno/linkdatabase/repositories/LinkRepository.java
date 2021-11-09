package com.saastamoinen.jarno.linkdatabase.repositories;

import com.saastamoinen.jarno.linkdatabase.models.Link;

import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<Link, Long>{
    
}
