package com.ygy.ad.addashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
public class AdDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdDashboardApplication.class, args);
    }

}
