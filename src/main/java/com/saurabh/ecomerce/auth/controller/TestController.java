package com.saurabh.ecomerce.auth.controller;

import com.saurabh.ecomerce.auth.product.product;
import com.saurabh.ecomerce.auth.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class TestController {
    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/products")
    public List getProducts() {
        return testService.fetchProducts();
    }

//    @PostMapping("/postrequest")
//    public void postProducts(@RequestBody product req) {
//        System.out.println("saurabh" + req);
//        String response = testService.PostRequest(req);
//        System.out.println("sbh.gupta" + response);
//    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody product product) {
        System.out.println(product);
         testService.createProduct(product);
    }
}


