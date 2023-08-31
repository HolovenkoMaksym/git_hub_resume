package com.holovenko.githubresume.account_info.mapper;

import com.holovenko.githubresume.account_info.domain.Repository;
import com.holovenko.githubresume.provider.github.GitHubRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepositoryMapper {
    RepositoryMapper INSTANCE = Mappers.getMapper(RepositoryMapper.class);

    @Mapping(target = "link", source = "htmlUrl")
    Repository mapToRepository(GitHubRepository gitHubRepository);
}
