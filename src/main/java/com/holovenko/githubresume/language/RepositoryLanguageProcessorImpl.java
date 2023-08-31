package com.holovenko.githubresume.language;

import com.holovenko.githubresume.language.domain.LanguageStatistic;
import com.holovenko.githubresume.language.domain.RepositoryLanguageStatistics;
import com.holovenko.githubresume.utils.MathUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RepositoryLanguageProcessorImpl implements RepositoryLanguageProcessor {

    @Override
    public RepositoryLanguageStatistics calculateLanguagesStatistic(final Map<String, Integer> languagesInfo) {
        final Long repositoryBytesAmount = languagesInfo.values()
                                                        .stream()
                                                        .mapToLong(value -> value)
                                                        .sum();
        final List<LanguageStatistic> languageStatistics = languagesInfo.entrySet()
                                                                        .stream()
                                                                        .map(entry -> getLanguageStatistics(repositoryBytesAmount, entry.getKey(), entry.getValue()))
                                                                        .toList();
        return new RepositoryLanguageStatistics(repositoryBytesAmount, languageStatistics);
    }

    private LanguageStatistic getLanguageStatistics(final Long repositoryBytesAmount,
                                                    final String languageName,
                                                    final Integer languageBytesAmount) {
        final Double languagePercentage = MathUtils.calculatePercentage(repositoryBytesAmount, languageBytesAmount);
        return new LanguageStatistic(languageName, languagePercentage, languageBytesAmount);
    }
}
