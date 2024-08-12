package com.saurabh.ecomerce.auth.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class TestService {

    private final WebClient webClient;

    public TestService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://fakestoreapi.com").build();
    }


    public List<Map<String, Object>> fetchProducts() {
        return webClient.get()
                .uri("/products?limit=5")
                .retrieve()
                .bodyToMono(List.class)
                 .block(); // Blocks for a response. Remove for asynchronous handling.
    }

}
