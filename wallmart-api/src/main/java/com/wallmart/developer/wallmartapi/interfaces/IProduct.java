package com.wallmart.developer.wallmartapi.interfaces;

import com.wallmart.developer.wallmartapi.data.ProductDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
public interface IProduct {

    public Page<ProductDTO> findByBrandDescriptionLike(Pageable productPage, String value);

}