package com.ygy.ad.adsponsor.service;

import com.ygy.ad.adcommon.exception.AdException;
import com.ygy.ad.adsponsor.entity.AdPlan;
import com.ygy.ad.adsponsor.vo.AdPlanGetRequest;
import com.ygy.ad.adsponsor.vo.AdPlanRequest;
import com.ygy.ad.adsponsor.vo.AdPlanResponse;

import java.util.List;

public interface IAdPlanService {

    /**
     * 创建推广计划
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 获取推广计划
     * @param request
     * @return
     * @throws AdException
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * 更新推广计划
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 删除推广计划
     * @param request
     * @throws AdException
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
