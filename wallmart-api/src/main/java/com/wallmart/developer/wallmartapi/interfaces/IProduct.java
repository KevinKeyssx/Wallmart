package com.wallmart.developer.wallmartapi.interfaces;

import java.util.List;

import com.wallmart.developer.wallmartapi.document.ProductDocument;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
public interface IProduct {

    public List<ProductDocument> findAll();

}