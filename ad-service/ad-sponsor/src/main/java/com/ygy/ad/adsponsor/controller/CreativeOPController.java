package com.ygy.ad.adsponsor.controller;

import com.alibaba.fastjson.JSON;
import com.ygy.ad.adsponsor.service.ICreativeService;
import com.ygy.ad.adsponsor.vo.CreativeRequest;
import com.ygy.ad.adsponsor.vo.CreativeResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CreativeOPController {

    @Autowired
    private ICreativeService creativeService;

    private Logger logger= LoggerFactory.getLogger(CreativeOPController.class);

    @PostMapping("/create/creative")
    public CreativeResponse createCreative(@RequestBody CreativeRequest request){

        logger.info("ad-sponsor: createCreative -> {}", JSON.toJSONString(request));
        return creativeService.createCreative(request);
    }
}
