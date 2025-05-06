package com.example.electricity_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.electricity_management_system.repository")


public class ElectricityManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElectricityManagementSystemApplication.class, args);
    }

}
