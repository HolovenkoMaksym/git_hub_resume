package com.holovenko.githubresume.provider;

import com.holovenko.githubresume.provider.github.GitHubRepository;
import com.holovenko.githubresume.provider.github.GitHubUser;

import java.util.List;
import java.util.Map;

public interface ApiProvider {

    /**
     * Retrieves User by account name
     *
     * @param accountName - name of account
     * @return user entity with basic info and endpoint for the next calls
     */
    GitHubUser getUser(String accountName);

    /**
     * Retrieves Repositories by url provided
     *
     * @param repositoriesUrl - repositories url from user endpoint
     * @return repositories list where each of items contains repo info and language endpoint for the next call
     */
    List<GitHubRepository> getRepositories(String repositoriesUrl);

    /**
     * Retrieves languages map by url provided
     *
     * @param languagesUrl - languages url from repositories endpoint
     * @return map where key -> name of language, value -> language bytes amount per repository
     */
    Map<String, Integer> getLanguages(String languagesUrl);
}
