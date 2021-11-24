package com.saastamoinen.jarno.linkdatabase.security;

import com.saastamoinen.jarno.linkdatabase.services.TestingUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Profile("testing")
@Configuration
@EnableWebSecurity
public class TestingSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private TestingUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();

        http.authorizeRequests().antMatchers("/h2-console","/h2-console/**").permitAll();

        http.authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers(HttpMethod.GET, "/index").permitAll()
                .antMatchers("/admin", "/links").authenticated()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                    .loginPage("/index")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/admin", true)
                    .permitAll()                  
                .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .clearAuthentication(true)
                    .logoutUrl("/logout").permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
