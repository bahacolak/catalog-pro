package com.bahadircolak.catalogpro.repository;

import com.bahadircolak.catalogpro.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
