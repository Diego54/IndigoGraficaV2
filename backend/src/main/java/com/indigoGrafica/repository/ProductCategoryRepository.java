package com.indigoGrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.indigoGrafica.models.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
