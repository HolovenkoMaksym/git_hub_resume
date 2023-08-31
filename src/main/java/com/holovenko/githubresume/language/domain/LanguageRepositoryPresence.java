package com.holovenko.githubresume.language.domain;

public record LanguageRepositoryPresence(String repositoryName,
                                         Long repositoryBytesAmount,
                                         Double repositoryPercentage) {
}
