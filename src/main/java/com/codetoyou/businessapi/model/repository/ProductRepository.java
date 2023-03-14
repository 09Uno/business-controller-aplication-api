package com.codetoyou.businessapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetoyou.businessapi.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
