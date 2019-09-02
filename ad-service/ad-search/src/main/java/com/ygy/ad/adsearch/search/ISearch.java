package com.ygy.ad.adsearch.search;

import com.ygy.ad.adsearch.search.vo.SearchReponse;
import com.ygy.ad.adsearch.search.vo.SearchRequest;

public interface ISearch {

    SearchReponse fetchAds(SearchRequest request);
}
