package com.ygy.ad.adsponsor.service.impl;

import com.ygy.ad.adsponsor.dao.CreativeRepository;
import com.ygy.ad.adsponsor.entity.Creative;
import com.ygy.ad.adsponsor.service.ICreativeService;
import com.ygy.ad.adsponsor.vo.CreativeRequest;
import com.ygy.ad.adsponsor.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreativeServiceImpl implements ICreativeService {

    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {

        Creative creative=creativeRepository.save(request.convertToEntity());

        return new CreativeResponse(creative.getId(),creative.getName());
    }
}
