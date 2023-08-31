package com.holovenko.githubresume.language.domain;

import java.util.List;

public record RepositoryLanguageStatistics(Long size, List<LanguageStatistic> languageStatistics) {
}
