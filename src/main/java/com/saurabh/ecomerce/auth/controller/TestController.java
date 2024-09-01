package com.saurabh.ecomerce.auth.controller;

import com.saurabh.ecomerce.auth.product.Product;
import com.saurabh.ecomerce.auth.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product) {
        System.out.println(product.toString());
         testService.createProduct(product);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable long id, @RequestBody Product product) {
        System.out.println(product.toString());
        return testService.updateProduct(id,product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id, @RequestBody Product product) {
        return testService.deleteProduct(id,product);
    }


}


