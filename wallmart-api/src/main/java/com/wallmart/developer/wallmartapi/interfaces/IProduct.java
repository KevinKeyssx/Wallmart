package com.wallmart.developer.wallmartapi.interfaces;

import com.wallmart.developer.wallmartapi.data.ProductDTO;
import com.wallmart.developer.wallmartapi.document.ProductDocument;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
public interface IProduct {

    public Page<ProductDTO> findAll(Pageable productPage);

    public ProductDTO findById(Long id);

    public Page<ProductDTO> findByBrandDescriptionLike(Pageable productPage, String value);

    public void save(ProductDocument product);

}