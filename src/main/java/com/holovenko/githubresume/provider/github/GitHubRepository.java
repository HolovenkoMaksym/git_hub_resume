package com.holovenko.githubresume.provider.github;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GitHubRepository(@JsonProperty("name") String name,
                               @JsonProperty("html_url") String htmlUrl,
                               @JsonProperty("description") String description,
                               @JsonProperty("languages_url") String languagesUrl) {
}
