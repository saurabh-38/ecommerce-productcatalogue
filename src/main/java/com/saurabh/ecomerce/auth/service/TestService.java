package com.saurabh.ecomerce.auth.service;

import com.saurabh.ecomerce.auth.product.product;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
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

    public Mono<product> createProduct(product product) {
        return webClient.post()
                .uri("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(product))
                .retrieve()
                .bodyToMono(product.class);
    }



//    public void createProduct() {
//        String jsonPayload = "{"
//                + "\"title\": \"New Product\","
//                + "\"price\": 29.99,"
//                + "\"description\": \"A description of the new product\","
//                + "\"image\": \"https://example.com/image.jpg\","
//                + "\"category\": \"electronics\""
//                + "}";
//
//        Mono<String> response = webClient.post()
//                .uri("/products")
//                .header("Content-Type", "application/json")
//                .bodyValue(jsonPayload)
//                .retrieve()
//                .bodyToMono(String.class);
//
//        response.doOnNext(result -> System.out.println("Product created successfully: " + result))
//                .doOnError(error -> System.out.println("Failed to create product: " + error.getMessage()))
//                .block();
//    }


}
