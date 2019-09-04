package com.ygy.ad.adsearch.mysql;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "adconf.mysql")
@Data
@NoArgsConstructor
public class BinlogConfig {

    private String host;
    private Integer port;
    private String username;
    private String password;

    private String binlogName;
    private Long position;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBinlogName() {
        return binlogName;
    }

    public void setBinlogName(String binlogName) {
        this.binlogName = binlogName;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }
}
