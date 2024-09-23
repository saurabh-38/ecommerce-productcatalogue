package com.saurabh.ecomerce.auth.repository;

import com.saurabh.ecomerce.auth.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface ProductRepository extends JpaRepository<Product, Long>  {

    Product getProductById(Long id);
}
