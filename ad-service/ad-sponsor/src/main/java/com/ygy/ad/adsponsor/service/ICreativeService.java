package com.ygy.ad.adsponsor.service;

import com.ygy.ad.adsponsor.vo.CreativeRequest;
import com.ygy.ad.adsponsor.vo.CreativeResponse;

public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request);
}
