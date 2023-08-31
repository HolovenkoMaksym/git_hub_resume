package com.holovenko.githubresume.provider.github;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GitHubApiConstants {
    public static final String BASE_URL = "https://api.github.com";
    public static final String USER_ENDPOINT = BASE_URL + "/users/%s";
}
