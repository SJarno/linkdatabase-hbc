package com.saastamoinen.jarno.linkdatabase.repositories;

import java.util.List;

import com.saastamoinen.jarno.linkdatabase.models.Link;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface LinkRepository extends JpaRepository<Link, Long>{
    /* method for finding by key */
    public List<Link> findByKeyword(String keyword);

    /* Custom query for finging tags */
    @Query(
        value = "SELECT * FROM link WHERE LOWER(keyword) LIKE LOWER(:keyword)", 
        nativeQuery = true)
    List<Link> customFindByKeyWordIgnoringCase(@Param("keyword") String keyword);
    /* Another option here: */
    /* @Query(value = "SELECT * FROM link WHERE keyword ILIKE :keyword"+"%", nativeQuery = true) */

    
}
