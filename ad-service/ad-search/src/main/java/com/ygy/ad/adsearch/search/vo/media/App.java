package com.ygy.ad.adsearch.search.vo.media;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class App {

    //应用编码
    private String appCode;

    //应用名称
    private String appName;

    //应用包名
    private String packageName;

    //activity 名称
    private String activityName;

    public App(String appCode, String appName, String packageName, String activityName) {
        this.appCode = appCode;
        this.appName = appName;
        this.packageName = packageName;
        this.activityName = activityName;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
