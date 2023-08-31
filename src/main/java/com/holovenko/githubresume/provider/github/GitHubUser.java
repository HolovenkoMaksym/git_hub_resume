package com.holovenko.githubresume.provider.github;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GitHubUser(@JsonProperty("login") String login,
                         @JsonProperty("blog") String blog,
                         @JsonProperty("repos_url") String reposUrl,
                         @JsonProperty("public_repos") Integer publicRepos) {
}
