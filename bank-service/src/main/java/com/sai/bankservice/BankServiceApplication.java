package com.sai.bankservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.sai.bankservice.client")
public class BankServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankServiceApplication.class, args);
    }
}