package com.holovenko.githubresume.language;

import com.holovenko.githubresume.language.domain.AccountLanguageStatistic;
import com.holovenko.githubresume.language.domain.LanguageStatistic;
import com.holovenko.githubresume.language.domain.RepositoryLanguageStatistics;
import com.holovenko.githubresume.utils.MathUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AccountLanguageAggregatorImpl implements AccountLanguageAggregator {

    @Override
    public List<AccountLanguageStatistic> aggregateAccountLanguages(final List<RepositoryLanguageStatistics> repositoriesStatistics) {
        final Long accountBytesAmount = repositoriesStatistics.stream()
                                                        .mapToLong(RepositoryLanguageStatistics::size)
                                                        .sum();
        final Map<String, List<LanguageStatistic>> languageToStatisticsMap =
                repositoriesStatistics.stream()
                                      .flatMap(repositoryLanguageStatistics -> repositoryLanguageStatistics.languageStatistics().stream())
                                      .collect(Collectors.groupingBy(LanguageStatistic::name));
        return languageToStatisticsMap.entrySet()
                                      .stream()
                                      .map(entry -> getAccountLanguageStatistics(accountBytesAmount, entry.getKey(), entry.getValue()))
                                      .toList();
    }

    private AccountLanguageStatistic getAccountLanguageStatistics(final Long accountBytesAmount, final String languageName, final List<LanguageStatistic> languageStatistics) {
        final Long languageTotalBytes = languageStatistics.stream()
                .reduce(0L, (subtotal, element) -> subtotal + element.bytesAmount(), Long::sum);
        final Double languagePercentage = MathUtils.calculatePercentage(accountBytesAmount, languageTotalBytes);
        return new AccountLanguageStatistic(languageName, languagePercentage);
    }
}
