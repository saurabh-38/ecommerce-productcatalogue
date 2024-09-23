package com.saurabh.ecomerce.auth.controller;

import com.saurabh.ecomerce.auth.models.Product;
import com.saurabh.ecomerce.auth.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/products")
    public List getProducts() {
        return testService.fetchProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product>  getProductByID(@PathVariable long id) {
        System.out.println("ProductController.getProductById");
        System.out.println("id " + id);
        return new ResponseEntity<>(this.testService.getProductByID(id), HttpStatus.OK);
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
    public Mono<ResponseEntity<String>>  updateProduct(@PathVariable long id, @RequestBody Product product) {
        System.out.println(product.toString());
        return testService.updateProduct(id,product);
    }

    @DeleteMapping("/product/{id}")
    public Mono<ResponseEntity<String>> deleteProduct(@PathVariable long id, @RequestBody Product product) {
        return testService.deleteProduct(id,product);
    }


}


