package com.ygy.ad.adsearch.search.vo.media;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Device {

    //设备编码
    private String deviceCode;

    private String mac;

    private String ip;

    //机型编码
    private String model;

    //分辨率尺寸
    private String displaySize;

    //屏幕尺寸
    private String screenSize;

    //设备序列号
    private String serialName;

    public Device(String deviceCode, String mac, String ip, String model, String displaySize, String screenSize, String serialName) {
        this.deviceCode = deviceCode;
        this.mac = mac;
        this.ip = ip;
        this.model = model;
        this.displaySize = displaySize;
        this.screenSize = screenSize;
        this.serialName = serialName;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }
}
