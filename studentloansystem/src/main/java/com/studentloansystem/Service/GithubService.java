package com.studentloansystem.Service;

import com.studentloansystem.DTO.GithubProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubService {
    @Autowired
    RestTemplate restTemplate;

    public GithubProfile getProfile(String userName) {
        String url = "https://api.github.com/users/" + userName;
        return restTemplate.getForObject(url, GithubProfile.class);
    }
}
