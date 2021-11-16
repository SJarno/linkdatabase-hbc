package com.saastamoinen.jarno.linkdatabase.repositories;

import java.util.List;

import com.saastamoinen.jarno.linkdatabase.models.Link;

import org.springframework.data.jpa.repository.JpaRepository;



public interface LinkRepository extends JpaRepository<Link, Long>{
    /* method for finding by key */
    public List<Link> findByKeyword(String keyword);
}
