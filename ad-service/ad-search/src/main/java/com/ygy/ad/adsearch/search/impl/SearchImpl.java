package com.ygy.ad.adsearch.search.impl;

import com.ygy.ad.adsearch.index.DataTable;
import com.ygy.ad.adsearch.index.adunit.AdUnitIndex;
import com.ygy.ad.adsearch.search.ISearch;
import com.ygy.ad.adsearch.search.vo.SearchReponse;
import com.ygy.ad.adsearch.search.vo.SearchRequest;
import com.ygy.ad.adsearch.search.vo.feature.DistrictFeature;
import com.ygy.ad.adsearch.search.vo.feature.FeatureRelation;
import com.ygy.ad.adsearch.search.vo.feature.ItFeature;
import com.ygy.ad.adsearch.search.vo.feature.KeywordFeature;
import com.ygy.ad.adsearch.search.vo.media.AdSlot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class SearchImpl implements ISearch {

    @Override
    public SearchReponse fetchAds(SearchRequest request) {

        //请求的广告位信息
        List<AdSlot> adSlots=request.getRequestInfo().getAdSlots();

        KeywordFeature keywordFeature=request.getFeatureInfo().getKeywordFeature();
        DistrictFeature districtFeature=request.getFeatureInfo().getDistrictFeature();
        ItFeature itFeature=request.getFeatureInfo().getItFeature();

        FeatureRelation relation=request.getFeatureInfo().getRelation();

        //构造响应对象
        SearchReponse reponse=new SearchReponse();
        Map<String,List<SearchReponse.Creative>> adSlot2Ads=reponse.getAdSlot2Ads();

        for (AdSlot adSlot:adSlots){

            Set<Long> targetUnitIdSet;

            //根据流量类型获取初始AdUnit
            Set<Long> adUnitIdSet= DataTable.of(AdUnitIndex.class).match(adSlot.getPositionType());
        }

        return null;
    }
}
