package com.holovenko.githubresume.account_info.controller;

import com.holovenko.githubresume.account_info.domain.AccountInfo;
import com.holovenko.githubresume.account_info.facade.AccountInfoFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/accounts/{accountName}")
public class AccountInfoController {

    private final AccountInfoFacade accountInfoFacade;

    @GetMapping
    public ResponseEntity<AccountInfo> getAccountInfoResponse(@PathVariable final String accountName,
                                                              @RequestParam(required = false, defaultValue = MediaType.APPLICATION_JSON_VALUE) final String mediaType) {
        return accountInfoFacade.getAccountInfoResponse(accountName, MediaType.valueOf(mediaType));
    }
}
