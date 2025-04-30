package com.studentloansystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubProfile {
    private String login;
    private int public_repos;
    private int followers;
    private String created_at;
}
