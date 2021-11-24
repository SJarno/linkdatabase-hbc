package com.saastamoinen.jarno.linkdatabase.services;

import java.util.Optional;

import com.saastamoinen.jarno.linkdatabase.models.UserAccount;
import com.saastamoinen.jarno.linkdatabase.repositories.UserAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public void updatePassword(String oldPassword, String newPassword) {
        if (getAuthentication().isAuthenticated()) {
            Optional<UserAccount> accountToUpdate = userAccountRepository.findByUsername(getAuthentication().getName());
            if (passwordEncoder.matches(oldPassword, accountToUpdate.get().getPassword())) {
                accountToUpdate.get().setPassword(passwordEncoder.encode(newPassword));
            }
        }

    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
