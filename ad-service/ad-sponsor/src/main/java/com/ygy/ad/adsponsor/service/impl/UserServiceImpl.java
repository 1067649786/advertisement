package com.ygy.ad.adsponsor.service.impl;

import com.ygy.ad.adcommon.exception.AdException;
import com.ygy.ad.adsponsor.constant.Constants;
import com.ygy.ad.adsponsor.dao.AdUserRepository;
import com.ygy.ad.adsponsor.entity.AdUser;
import com.ygy.ad.adsponsor.service.IUserService;
import com.ygy.ad.adsponsor.utils.CommonUtils;
import com.ygy.ad.adsponsor.vo.CreateUserRequest;
import com.ygy.ad.adsponsor.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {

        if(!request.validate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        AdUser oldUser=userRepository.findByUsername(request.getUsername());

        if(oldUser!=null){
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }

        AdUser newUser=userRepository.save(new AdUser(request.getUsername(), CommonUtils.md5(request.getUsername())));

        return new CreateUserResponse(newUser.getId(),newUser.getUsername(),newUser.getToken(),newUser.getCreateTime(),newUser.getUpdateTime());
    }
}
