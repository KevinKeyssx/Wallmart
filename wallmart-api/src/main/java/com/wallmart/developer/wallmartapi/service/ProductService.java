package com.wallmart.developer.wallmartapi.service;

import java.util.ArrayList;
import java.util.List;

import com.wallmart.developer.wallmartapi.document.ProductDocument;
import com.wallmart.developer.wallmartapi.interfaces.IProduct;
import com.wallmart.developer.wallmartapi.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
@Log4j2
@Service
public class ProductService implements IProduct {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<ProductDocument> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}