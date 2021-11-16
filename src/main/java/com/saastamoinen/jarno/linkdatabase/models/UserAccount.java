package com.saastamoinen.jarno.linkdatabase.models;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAccount extends AbstractPersistable<Long>{
    private String username;
    private String password;
    /* private List<String> roles; */

}
