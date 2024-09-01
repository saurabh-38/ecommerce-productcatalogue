package com.saurabh.ecomerce.auth.service;

import com.saurabh.ecomerce.auth.product.Product;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TestService {

    private WebClient webClient = null;


    public TestService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://fakestoreapi.com").build();
    }


    public List fetchProducts() {
        return webClient.get()
                .uri("/products?limit=5")
                .retrieve()
                .bodyToMono(List.class)
                .block(); // Blocks for a response. Remove for asynchronous handling.
    }

//    public String PostRequest(@RequestBody product req) {
//        String baseUrl = "https://fakestoreapi.com";
//        String response = WebClient.create(baseUrl).post()
//                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
//                .body( Mono.just(req), product.class)
//                .retrieve()
//                .bodyToMono(String.class).block();
//
//        return response;
//    }

    public Mono<Product> createProduct(Product product) {
        return webClient.post()
                .uri("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(product))
                .retrieve()
                .bodyToMono(Product.class);
    }


    public ResponseEntity<String> updateProduct(long id, Product product) {

        String apiUrl = "https://fakestoreapi.com/products/" + id;  // Update URL with product ID

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Product> request = new HttpEntity<>(product, headers);

        // Sending PUT request to fake store API
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.PUT, request, String.class);
        System.out.println("Response" + response);
        return response;


    }

    public ResponseEntity<String> deleteProduct(long id, Product product) {

        String apiUrl = "https://fakestoreapi.com/products/" + id;  // Update URL with product ID
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.DELETE, HttpEntity.EMPTY, String.class);
        System.out.println("response" + response);
        return ResponseEntity.ok(response.getBody());

    }
}
