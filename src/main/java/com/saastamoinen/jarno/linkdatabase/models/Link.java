package com.saastamoinen.jarno.linkdatabase.models;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Link extends AbstractPersistable<Long>{
    private String title;
    private String description;
    private String keyword;
    private String url;

    
}

