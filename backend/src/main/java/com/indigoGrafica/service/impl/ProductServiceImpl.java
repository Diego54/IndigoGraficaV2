package com.indigoGrafica.service.impl;

import com.indigoGrafica.models.Product;
import com.indigoGrafica.repository.ProductRepository;
import com.indigoGrafica.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findByCategoryId(Integer id) {
        return productRepository.findByCategoryId(id);
    }
}
