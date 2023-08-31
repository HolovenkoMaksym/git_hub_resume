package com.holovenko.githubresume.account_info.facade;

import com.holovenko.githubresume.account_info.domain.AccountInfo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public interface AccountInfoFacade {

    /**
     * Returns account info response in given media type format
     *
     * Throws: UnsupportedMediaTypeException if handler for given mediaType is not present
     *
     * @param accountName - name of account
     * @param mediaType - media type of response
     * @return response entity of AccountInfo
     */
    ResponseEntity<AccountInfo> getAccountInfoResponse(String accountName, MediaType mediaType);
}
