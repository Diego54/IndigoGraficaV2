package com.indigoGrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indigoGrafica.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>{

    List<Product> findByCategoryId(Integer id);

}