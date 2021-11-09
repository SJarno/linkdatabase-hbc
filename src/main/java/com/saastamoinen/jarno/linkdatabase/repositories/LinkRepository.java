package com.saastamoinen.jarno.linkdatabase.repositories;

import com.saastamoinen.jarno.linkdatabase.models.Link;

import org.springframework.data.jpa.repository.JpaRepository;


public interface LinkRepository extends JpaRepository<Link, Long>{
    
}
