package com.saurabh.ecomerce.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saurabh.ecomerce.auth.service.TestService;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }
    @GetMapping("/products")
    public List<Map<String, Object>> getProducts() {
        return testService.fetchProducts();
    }
}


