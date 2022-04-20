package com.indigoGrafica.service;

import com.indigoGrafica.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> findByCategoryId(Integer id);
}
