package com.holovenko.githubresume.account_info.domain;

import com.holovenko.githubresume.language.domain.AccountLanguageStatistic;

import java.util.List;

public record AccountInfo(String userName,
                          String website,
                          Integer repositoriesQuantity,
                          List<Repository> repositories,
                          List<AccountLanguageStatistic> languageStatistics) {
}
