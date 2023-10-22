package com.sourabh.microservice.product.Repository;

import com.sourabh.microservice.product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

