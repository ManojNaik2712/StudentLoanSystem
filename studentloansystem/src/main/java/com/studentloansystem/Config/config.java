package com.studentloansystem.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class config {
    @Bean
    PasswordEncoder getPe(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
