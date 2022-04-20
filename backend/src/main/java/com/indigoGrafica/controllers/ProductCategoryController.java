package com.indigoGrafica.controllers;

import com.indigoGrafica.models.ProductCategory;
import com.indigoGrafica.service.ProductCategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Inject
    protected ObjectMapper objectMapper;

    @RequestMapping(value = "/productCategory/getAll",method = RequestMethod.GET)
    public List<ProductCategory> getAll() {
        return productCategoryService.findAll();
    }
}
