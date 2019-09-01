package com.ygy.ad.adsponsor.controller;

import com.alibaba.fastjson.JSON;
import com.ygy.ad.adcommon.exception.AdException;
import com.ygy.ad.adsponsor.service.IUserService;
import com.ygy.ad.adsponsor.vo.CreateUserRequest;
import com.ygy.ad.adsponsor.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserOPController {

    @Autowired
    private IUserService userService;

    @PostMapping("/create/user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws AdException {

        Logger logger= LoggerFactory.getLogger(UserOPController.class);
        logger.info("ad-sponsor: createUser -> {}", JSON.toJSONString(request));

        return userService.createUser(request);
    }
}
