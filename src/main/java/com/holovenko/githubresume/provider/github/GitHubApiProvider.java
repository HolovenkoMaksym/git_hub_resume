package com.holovenko.githubresume.provider.github;

import com.holovenko.githubresume.http.HttpApiClient;
import com.holovenko.githubresume.provider.ApiProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class GitHubApiProvider implements ApiProvider {

    private final HttpApiClient httpApiClient;
    private final GitHubProperties gitHubProperties;

    @Override
    public GitHubUser getUser(final String accountName) {
        return httpApiClient.doGet(gitHubProperties.getBaseUrl() + gitHubProperties.getUserEndpoint().formatted(accountName), Map.of(), GitHubUser.class);
    }

    @Override
    public List<GitHubRepository> getRepositories(final String repositoriesUrl) {
        GitHubRepository[] gitHubRepositories = httpApiClient.doGet(repositoriesUrl, Map.of(), GitHubRepository[].class);
        return Arrays.asList(gitHubRepositories);
    }

    @Override
    public Map<String, Integer> getLanguages(String languagesUrl) {
        return httpApiClient.doGet(languagesUrl, Map.of(), Map.class);
    }
}
