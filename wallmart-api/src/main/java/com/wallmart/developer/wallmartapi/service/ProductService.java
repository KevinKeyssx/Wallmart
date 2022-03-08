package com.wallmart.developer.wallmartapi.service;

import java.util.ArrayList;

import com.wallmart.developer.wallmartapi.common.Util;
import com.wallmart.developer.wallmartapi.data.ProductDTO;
import com.wallmart.developer.wallmartapi.document.ProductDocument;
import com.wallmart.developer.wallmartapi.interfaces.IProduct;
import com.wallmart.developer.wallmartapi.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<ProductDTO> findByBrandDescriptionLike(Pageable productPage, String value) {
        log.info("STARTING - findByBrandLikeOrDescriptionLike");
        Page<ProductDocument> findLike = null;
        if (new Util(true).isLong(value)) {
            var valueLong = Long.parseLong(value);
            findLike = productRepository.findById(productPage, valueLong);
		}
        else {
            findLike = productRepository.findByBrandLikeOrDescriptionLike(productPage, value, value);
        }
        applyDiscount(findLike);
        log.info("FINISHING - findByBrandLikeOrDescriptionLike");
        return fillProductDTO(findLike);
    }

    private void applyDiscount(Page<ProductDocument> find){
        find.forEach(product -> {
            if (new Util(true).isPalindrome(product.getBrand())) {
                //Aplicar 50% de descuento
                log.info("IS PALINDROME!!!");
                product.setPrice((int)(product.getPrice() * 0.5));
            }
        });
    }

    private Page<ProductDTO> fillProductDTO(Page<ProductDocument> productPage) {
        log.info("STARTING - fillProductDTO");
        if (productPage == null || productPage.getNumberOfElements() == 0) {
            return null;
        }
        var listProductDTO = new ArrayList<ProductDTO>();
        productPage.forEach(product -> {
            listProductDTO.add(fillProductDTO(product));
        });
        log.info("FINISHING - findByBrandLikeOrDescriptionLike");
        return new PageImpl<ProductDTO>(listProductDTO);
    }

    private ProductDTO fillProductDTO(ProductDocument product) {
        return new ProductDTO(
            product.getId(),
            product.getBrand(),
            product.getDescription(),
            product.getImage(),
            product.getPrice()
        );
    }

    @Override
    public void save(ProductDocument product) {
        log.info("STARTING - save");
        productRepository.save(product);
        log.info("FINISHING - save");
    }

}