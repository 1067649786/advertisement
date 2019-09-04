package com.ygy.ad.adsponsor.service;

import com.ygy.ad.adcommon.exception.AdException;
import com.ygy.ad.adsponsor.AdSponsorApplicationTests;
import com.ygy.ad.adsponsor.vo.AdPlanGetRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AdSponsorApplicationTests.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AdPlanServiceTest {

    @Autowired
    private IAdPlanService planService;

    @Test
    public void testGetAdPlan() throws AdException{
        System.out.println(planService.getAdPlanByIds(
                new AdPlanGetRequest(15L, Collections.singletonList(10L))
        ));
    }
}
