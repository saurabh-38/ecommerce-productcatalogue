package com.saurabh.ecomerce.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableAutoConfiguration(exclude={Product.class})
public class AuthApplication {

    public static void main(String[] args) {
        //System.out.printf("saurabh");
        System.out.println("Hello, Gradle Spring Project!");
        SpringApplication.run(AuthApplication.class, args);

    }

}
