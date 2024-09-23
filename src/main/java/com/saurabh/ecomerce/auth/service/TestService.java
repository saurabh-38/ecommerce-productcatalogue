package com.saurabh.ecomerce.auth.service;

import com.saurabh.ecomerce.auth.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.saurabh.ecomerce.auth.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final WebClient webClient ;
    private final ProductRepository productRepository;


    public List fetchProducts() {
        return this.webClient.get()
                .uri("/products?limit=5")
                .retrieve()
                .bodyToMono(List.class)
                .block(); // Blocks for a response. Remove for asynchronous handling.
    }
    public Product getProductByID(long id) {
        System.out.println("ProductService.getProductById");
        System.out.println("id = " + id);
       Product product = this.productRepository.getProductById(id);
        
        if(product != null){
            return product;
        }
        
        Product productFromApi = webClient
                .get()
                .uri("/products/" +id)
                .retrieve()
                .bodyToMono(Product.class)
                .block(); // Blocks for a response. Remove for asynchronous handling.
        this.saveProduct(productFromApi);
        return productFromApi;
    }

    public Mono<Product> createProduct(Product product) {
        return webClient.post()
                .uri("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(product))
                .retrieve()
                .bodyToMono(Product.class);
    }


    public Mono<ResponseEntity<String>> updateProduct(long id, Product product) {


        String apiUrl = "https://fakestoreapi.com/products/" + id;  // Update URL with product ID

        return webClient
                .put()
                .uri(apiUrl)
                .body(Mono.just(product), Product.class)
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> ResponseEntity.ok(response))
                .onErrorResume(e -> Mono.just(ResponseEntity.status(500).body("Error occurred: " + e.getMessage())));


    }

    public Mono<ResponseEntity<String>> deleteProduct(long id, Product product) {

        String apiUrl = "https://fakestoreapi.com/products/" + id;  // Update URL with product ID

        return webClient
                .delete()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> ResponseEntity.ok(response))
                .onErrorResume(e -> Mono.just(ResponseEntity.status(500).body("Error occurred: " + e.getMessage())));

    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }


}
