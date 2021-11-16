package com.saastamoinen.jarno.linkdatabase.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Link extends AbstractPersistable<Long> {

    @NotBlank(message = "Title cannot be empty")
    @Size(min = 4, message = "Title must be at least 4 characters long")
    private String title;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotBlank(message = "Keyword cannot be empty")
    private String keyword;

    @NotBlank(message = "Url cannot be empty")
    private String url;

}
