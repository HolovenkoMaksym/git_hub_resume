package com.holovenko.githubresume.language;

import com.holovenko.githubresume.language.domain.AccountLanguageStatistic;
import com.holovenko.githubresume.language.domain.RepositoryLanguageStatistics;

import java.util.List;

public interface AccountLanguageAggregator {

    /**
     * Aggregates language info for 1 account by the list of statistics from each account repository
     *
     * @param repositoriesStatistics - list of repository language statistics
     * @return list of languages with their percentage for account
     */
    List<AccountLanguageStatistic> aggregateAccountLanguages(List<RepositoryLanguageStatistics> repositoriesStatistics);
}
