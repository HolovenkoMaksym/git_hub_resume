package com.holovenko.githubresume.account_info.service;

import com.holovenko.githubresume.account_info.domain.AccountInfo;
import com.holovenko.githubresume.account_info.domain.Repository;
import com.holovenko.githubresume.account_info.mapper.AccountInfoMapper;
import com.holovenko.githubresume.account_info.mapper.RepositoryMapper;
import com.holovenko.githubresume.language.AccountLanguageAggregator;
import com.holovenko.githubresume.language.domain.AccountLanguageStatistic;
import com.holovenko.githubresume.language.RepositoryLanguageProcessor;
import com.holovenko.githubresume.language.domain.RepositoryLanguageStatistics;
import com.holovenko.githubresume.provider.ApiProvider;
import com.holovenko.githubresume.provider.github.GitHubRepository;
import com.holovenko.githubresume.provider.github.GitHubUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountInfoServiceImpl implements AccountInfoService {

    private final ApiProvider apiProvider;
    private final RepositoryLanguageProcessor repositoryLanguageProcessor;
    private final AccountLanguageAggregator accountLanguageAggregator;

    @Override
    public AccountInfo retrieveAccountInfo(final String accountName) {
        final GitHubUser user = apiProvider.getUser(accountName);
        final List<GitHubRepository> apiProviderRepositories = apiProvider.getRepositories(user.reposUrl());
        List<RepositoryLanguageStatistics> repositoryLanguageStatistics = apiProviderRepositories.stream()
                .map(repository -> fetchStatistics(repository.languagesUrl()))
                .toList();
        List<AccountLanguageStatistic> accountLanguageStatistics = accountLanguageAggregator.aggregateAccountLanguages(repositoryLanguageStatistics);
        List<Repository> repositories = apiProviderRepositories.stream()
                                                               .map(RepositoryMapper.INSTANCE::mapToRepository)
                                                               .toList();
        return AccountInfoMapper.INSTANCE.mapToAccountInfo(user, repositories, accountLanguageStatistics);
    }

    private RepositoryLanguageStatistics fetchStatistics(final String languageUrl) {
        final Map<String, Integer> languagesInfo = apiProvider.getLanguages(languageUrl);
        return repositoryLanguageProcessor.calculateLanguagesStatistic(languagesInfo);
    }
}
