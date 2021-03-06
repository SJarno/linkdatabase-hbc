package com.saastamoinen.jarno.linkdatabase.repositories;

import java.util.List;

import com.saastamoinen.jarno.linkdatabase.models.Link;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LinkRepository extends JpaRepository<Link, Long> {

    /* Custom query for finging tags/keyword */
    @Query(value = "SELECT * FROM links WHERE LOWER(keyword) LIKE LOWER(:keyword)", nativeQuery = true)
    List<Link> customFindByKeyWordIgnoringCase(@Param("keyword") String keyword);

}
