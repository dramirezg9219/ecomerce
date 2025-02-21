package com.example.ecomerce;

import com.example.ecomerce.common.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(Constants.NAMESPACES)
@EnableJpaRepositories(Constants.NAMESPACES)
public class EcomerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomerceApplication.class, args);
    }

}
