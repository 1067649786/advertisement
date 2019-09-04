package com.ygy.ad.adsearch.search;

import com.alibaba.fastjson.JSON;
import com.ygy.ad.adsearch.AdSearchApplicationTests;
import com.ygy.ad.adsearch.search.vo.SearchRequest;
import com.ygy.ad.adsearch.search.vo.feature.DistrictFeature;
import com.ygy.ad.adsearch.search.vo.feature.FeatureRelation;
import com.ygy.ad.adsearch.search.vo.feature.ItFeature;
import com.ygy.ad.adsearch.search.vo.feature.KeywordFeature;
import com.ygy.ad.adsearch.search.vo.media.AdSlot;
import com.ygy.ad.adsearch.search.vo.media.App;
import com.ygy.ad.adsearch.search.vo.media.Device;
import com.ygy.ad.adsearch.search.vo.media.Geo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AdSearchApplicationTests.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SearchTest {

    @Autowired
    private ISearch search;

    @Test
    public void testFetchAds(){

        SearchRequest request=new SearchRequest();
        request.setMediaId("imooc-ad");

        //第一个测试条件
        request.setRequestInfo(new SearchRequest.RequestInfo(
                "aaa", Collections.singletonList(new AdSlot(
                        "ad-x",1,1080,720, Arrays.asList(1,2),1000
        )),
                buildExampleApp(),
                buildExampleGeo(),
                buildExampleDevice()
        ));
        request.setFeatureInfo(buildExampleFeatureInfo(
                Arrays.asList("宝马","大众"),
                Collections.singletonList(new DistrictFeature.ProvinceAndCity("安徽省","合肥市")),
                Arrays.asList("台球","游泳"),
                FeatureRelation.OR
        ));
        System.out.println(JSON.toJSONString(request));
        System.out.println(JSON.toJSONString(search.fetchAds(request)));


        //第二个测试条件
        request.setRequestInfo(new SearchRequest.RequestInfo(
                "aaa", Collections.singletonList(new AdSlot(
                "ad-y",1,1080,720, Arrays.asList(1,2),1000
        )),
                buildExampleApp(),
                buildExampleGeo(),
                buildExampleDevice()
        ));
        request.setFeatureInfo(buildExampleFeatureInfo(
                Arrays.asList("宝马","大众","标致"),
                Collections.singletonList(new DistrictFeature.ProvinceAndCity("安徽省","合肥市")),
                Arrays.asList("台球","游泳"),
                FeatureRelation.AND
        ));
        System.out.println(JSON.toJSONString(request));
        System.out.println(JSON.toJSONString(search.fetchAds(request)));
    }

    private App buildExampleApp(){
        return new App("imooc","imooc","com.imooc","video");
    }

    private Geo buildExampleGeo(){
        return new Geo((float) 100.28,(float) 88.61,"北京市","北京市");
    }

    private Device buildExampleDevice(){
        return new Device("iphone",
                "0xxxxx",
                "127.0.0.1",
                "x",
                "1080 720",
                "1080 720",
                "123456789");
    }

    private SearchRequest.FeatureInfo buildExampleFeatureInfo(
            List<String> keywords,
            List<DistrictFeature.ProvinceAndCity> provinceAndCities,
            List<String> its,
            FeatureRelation relation
    ){
        return new SearchRequest.FeatureInfo(
                new KeywordFeature(keywords),
                new DistrictFeature(provinceAndCities),
                new ItFeature(its),
                relation
        );
    }
}
