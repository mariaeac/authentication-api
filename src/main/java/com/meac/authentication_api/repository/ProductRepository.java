package com.meac.authentication_api.repository;

import com.meac.authentication_api.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}