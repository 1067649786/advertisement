package com.ygy.ad.adsearch.client;

import com.ygy.ad.adcommon.vo.CommonResponse;
import com.ygy.ad.adsearch.client.vo.AdPlan;
import com.ygy.ad.adsearch.client.vo.AdPlanGetRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SponsorClientHystrix implements SponsorClient {

    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1,"eureka-client-ad-sponsor error");
    }
}
