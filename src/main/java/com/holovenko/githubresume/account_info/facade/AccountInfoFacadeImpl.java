package com.holovenko.githubresume.account_info.facade;

import com.holovenko.githubresume.account_info.domain.AccountInfo;
import com.holovenko.githubresume.account_info.exception.UnsupportedMediaTypeException;
import com.holovenko.githubresume.account_info.service.AccountInfoService;
import com.holovenko.githubresume.mediatype.MediaTypeResolverStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountInfoFacadeImpl implements AccountInfoFacade {

    private static final String UNSUPPORTED_MEDIA_TYPE_MESSAGE = "Media type %s is unsupported. Possible types: %s";

    private final AccountInfoService accountInfoService;
    private final List<MediaTypeResolverStrategy> mediaTypeResolvers;

    @Override
    public ResponseEntity<AccountInfo> getAccountInfoResponse(final String accountName, final MediaType mediaType) {
        final AccountInfo accountInfo = accountInfoService.retrieveAccountInfo(accountName);
        MediaTypeResolverStrategy mediaTypeResolverStrategy = mediaTypeResolvers.stream()
                .filter(mediaTypeResolver -> mediaTypeResolver.mediaType().equals(mediaType))
                .findFirst()
                .orElseThrow(() -> getUnsupportedMediaTypeException(mediaType));
        return mediaTypeResolverStrategy.getMediaTypeBasedResponse(accountInfo);
    }

    private UnsupportedMediaTypeException getUnsupportedMediaTypeException(final MediaType mediaType) {
        final List<String> supportedTypes = mediaTypeResolvers.stream()
                .map(mediaTypeResolver -> mediaTypeResolver.mediaType().getType())
                .toList();
        return new UnsupportedMediaTypeException(UNSUPPORTED_MEDIA_TYPE_MESSAGE.formatted(mediaType, supportedTypes));
    }
}
