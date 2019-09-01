package com.ygy.ad.adsponsor.service;

import com.ygy.ad.adcommon.exception.AdException;
import com.ygy.ad.adsponsor.vo.CreateUserRequest;
import com.ygy.ad.adsponsor.vo.CreateUserResponse;

public interface IUserService {

    /**
     * 创建用户
     * @param request
     * @return
     * @throws AdException
     */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
