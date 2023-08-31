package com.holovenko.githubresume.account_info.mapper;

import com.holovenko.githubresume.account_info.domain.AccountInfo;
import com.holovenko.githubresume.account_info.domain.Repository;
import com.holovenko.githubresume.language.domain.AccountLanguageStatistic;
import com.holovenko.githubresume.provider.github.GitHubUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountInfoMapper {
    AccountInfoMapper INSTANCE = Mappers.getMapper(AccountInfoMapper.class);

    @Mapping(target = "userName", source = "user.login")
    @Mapping(target = "website", source = "user.blog")
    @Mapping(target = "repositoriesQuantity", source = "user.publicRepos")
    AccountInfo mapToAccountInfo(GitHubUser user,
                                 List<Repository> repositories,
                                 List<AccountLanguageStatistic> languageStatistics);
}
