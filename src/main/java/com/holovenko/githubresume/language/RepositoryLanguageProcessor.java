package com.holovenko.githubresume.language;

import com.holovenko.githubresume.language.domain.RepositoryLanguageStatistics;

import java.util.Map;

public interface RepositoryLanguageProcessor {

    /**
     * Calculates language statistic for given repository
     *
     * @param languagesInfo - map of language info from one repository where key -> language name and value -> language bytes amount
     * @return Statistic for repository
     */
    RepositoryLanguageStatistics calculateLanguagesStatistic(Map<String, Integer> languagesInfo);
}
