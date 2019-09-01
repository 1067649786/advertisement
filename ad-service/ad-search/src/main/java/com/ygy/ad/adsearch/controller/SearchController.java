package com.ygy.ad.adsearch.controller;

import com.alibaba.fastjson.JSON;
import com.ygy.ad.adcommon.annotation.IgnoreResponse;
import com.ygy.ad.adcommon.vo.CommonResponse;
import com.ygy.ad.adsearch.client.SponsorClient;
import com.ygy.ad.adsearch.client.vo.AdPlan;
import com.ygy.ad.adsearch.client.vo.AdPlanGetRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class SearchController {

    private final RestTemplate restTemplate;

    private final SponsorClient sponsorClient;

    private Logger logger= LoggerFactory.getLogger(SearchController.class);

    @Autowired
    public SearchController(RestTemplate restTemplate, SponsorClient sponsorClient) {
        this.restTemplate = restTemplate;
        this.sponsorClient = sponsorClient;
    }

    @IgnoreResponse
    @PostMapping("/getAdPlans")
    public CommonResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request){
        logger.info("ad-search: getAdPlans -> {}",JSON.toJSONString(request));
        return sponsorClient.getAdPlans(request);
    }

    @IgnoreResponse
    @PostMapping("/getAdPlansByRibbon")
    public CommonResponse<List<AdPlan>> getAdPlansByRebbon(@RequestBody AdPlanGetRequest request){

        logger.info("ad-search: getAdPlansByRibbon -> {}", JSON.toJSONString(request));

        return restTemplate.postForEntity("http://eureka-client-ad-sponsor/ad-sponsor/get/adPlan",
                request,
                CommonResponse.class).getBody();
    }

}
