package com.holovenko.githubresume.provider.github;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "github.api")
public class GitHubProperties {
    private String baseUrl;
    private String userEndpoint;
}
