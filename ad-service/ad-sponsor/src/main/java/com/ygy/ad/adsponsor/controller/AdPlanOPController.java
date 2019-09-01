package com.ygy.ad.adsponsor.controller;

import com.alibaba.fastjson.JSON;
import com.ygy.ad.adcommon.exception.AdException;
import com.ygy.ad.adsponsor.entity.AdPlan;
import com.ygy.ad.adsponsor.service.IAdPlanService;
import com.ygy.ad.adsponsor.vo.AdPlanGetRequest;
import com.ygy.ad.adsponsor.vo.AdPlanRequest;
import com.ygy.ad.adsponsor.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class AdPlanOPController {

    @Autowired
    private IAdPlanService adPlanService;

    private Logger logger= LoggerFactory.getLogger(AdPlanOPController.class);

    @PostMapping("/create/adPlan")
    public AdPlanResponse createAdPlan(@RequestBody AdPlanRequest request) throws AdException{

        logger.info("ad-sponsor: createAdPlan -> {}", JSON.toJSONString(request));
        return adPlanService.createAdPlan(request);
    }

    @PostMapping("/get/adPlan")
    public List<AdPlan> getAdPlanByIds(@RequestBody AdPlanGetRequest request) throws AdException{

        logger.info("ad-sponsor: getAdPlanByIds -> {}", JSON.toJSONString(request));
        return adPlanService.getAdPlanByIds(request);
    }

    @PutMapping("/update/adPlan")
    public AdPlanResponse updateAdPlan(@RequestBody AdPlanRequest request) throws AdException{

        logger.info("ad-sponsor: updateAdPlan -> {}", JSON.toJSONString(request));
        return adPlanService.updateAdPlan(request);
    }

    @DeleteMapping("/delete/adPlan")
    public void deleteAdPlan(@RequestBody AdPlanRequest request) throws AdException{

        logger.info("ad-sponsor: deleteAdPlan -> {}", JSON.toJSONString(request));
        adPlanService.deleteAdPlan(request);
    }
}
