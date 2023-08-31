package com.holovenko.githubresume.account_info.service;

import com.holovenko.githubresume.account_info.domain.AccountInfo;

public interface AccountInfoService {

    /**
     * Retrieves Git account info by account name
     *
     * @param accountName - Git account name
     * @return account info of given account
     */
    AccountInfo retrieveAccountInfo(String accountName);
}
