package com.ygy.ad.adsponsor.service;

import com.alibaba.fastjson.JSON;
import com.ygy.ad.adcommon.dump.table.AdCreativeTable;
import com.ygy.ad.adcommon.dump.table.AdPlanTable;
import com.ygy.ad.adcommon.dump.table.AdUnitTable;
import com.ygy.ad.adsponsor.AdSponsorApplicationTests;
import com.ygy.ad.adsponsor.constant.CommonStatus;
import com.ygy.ad.adsponsor.dao.AdPlanRepository;
import com.ygy.ad.adsponsor.dao.AdUnitRepository;
import com.ygy.ad.adsponsor.dao.CreativeRepository;
import com.ygy.ad.adsponsor.dao.unit_condition.AdUnitDistrictRepository;
import com.ygy.ad.adsponsor.dao.unit_condition.AdUnitItRepository;
import com.ygy.ad.adsponsor.dao.unit_condition.AdUnitKeywordRepository;
import com.ygy.ad.adsponsor.dao.unit_condition.CreativeUnitRepository;
import com.ygy.ad.adsponsor.entity.AdPlan;
import com.ygy.ad.adsponsor.entity.AdUnit;
import com.ygy.ad.adsponsor.entity.Creative;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AdSponsorApplicationTests.class},
webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DumpDataService {

    @Autowired
    private AdPlanRepository planRepository;
    @Autowired
    private AdUnitRepository unitRepository;
    @Autowired
    private CreativeRepository creativeRepository;
    @Autowired
    private CreativeUnitRepository creativeUnitRepository;
    @Autowired
    private AdUnitDistrictRepository adUnitDistrictRepository;
    @Autowired
    private AdUnitItRepository adUnitItRepository;
    @Autowired
    private AdUnitKeywordRepository keywordRepository;

    private Logger logger= LoggerFactory.getLogger(DumpDataService.class);

    private void dumpAdPlanTable(String fileName){

        List<AdPlan> adPlans=planRepository.findAllByPlanStatus(CommonStatus.VALID.getStatus());
        if(CollectionUtils.isEmpty(adPlans)){
            return;
        }

        List<AdPlanTable> planTables=new ArrayList<>();
        adPlans.forEach(p -> planTables.add(new AdPlanTable(
                p.getId(),
                p.getUserId(),
                p.getPlanStatus(),
                p.getStartDate(),
                p.getEndDate()
        )));
        Path path= Paths.get(fileName);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for (AdPlanTable planTable:planTables){
                writer.write(JSON.toJSONString(planTable));
                writer.newLine();
            }
            writer.close();
        }catch (IOException ex){
            logger.error("dumpAdPlanTable error");
        }
    }

    private void dumpAdUnitTable(String fileName){

        List<AdUnit> adUnits = unitRepository.findAllByUnitStatus(CommonStatus.VALID.getStatus());
        if(CollectionUtils.isEmpty(adUnits)){
            return;
        }

        List<AdUnitTable> unitTables=new ArrayList<>();
        adUnits.forEach(u -> unitTables.add(new AdUnitTable(
                u.getId(),
                u.getUnitStatus(),
                u.getPositonType(),
                u.getPlanId()
        )));

        Path path= Paths.get(fileName);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for (AdUnitTable unitTable:unitTables){
                writer.write(JSON.toJSONString(unitTable));
                writer.newLine();
            }
            writer.close();
        }catch (IOException ex){
            logger.error("dumpAdPlanTable error");
        }
    }

    private void dumpAdCreativeTable(String fileName){

        List<Creative> creatives=creativeRepository.findAll();
        if (CollectionUtils.isEmpty(creatives)){
            return;
        }

        List<AdCreativeTable> creativeTables=new ArrayList<>();
        creatives.forEach(c -> creativeTables.add(new AdCreativeTable(
                c.getId(),
                c.getName(),
                c.getType(),
                c.getMaterialType(),
                c.getHeight(),
                c.getWidth(),
                c.getAuditStatus(),
                c.getUrl()
        )));
    }
}
