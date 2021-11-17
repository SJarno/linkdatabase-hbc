package com.saastamoinen.jarno.linkdatabase.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
   name = "User_Accounts",
   uniqueConstraints = 
   @UniqueConstraint(columnNames = {"username", "password"})
)
@Data
public class UserAccount extends AbstractPersistable<Long>{
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

}
