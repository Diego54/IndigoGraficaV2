package com.indigoGrafica.controllers;

import com.indigoGrafica.models.Product;
import com.indigoGrafica.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Inject
    protected ObjectMapper objectMapper;

    @RequestMapping(value = "/product/getByCategoryId",method = RequestMethod.GET)
    public List<Product> getByCategoryId(@RequestParam Integer id) {
        return productService.findByCategoryId(id);
    }
}
