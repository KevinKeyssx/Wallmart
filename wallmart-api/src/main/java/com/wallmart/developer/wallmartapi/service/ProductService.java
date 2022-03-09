package com.wallmart.developer.wallmartapi.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wallmart.developer.wallmartapi.common.Util;
import com.wallmart.developer.wallmartapi.data.ProductDTO;
import com.wallmart.developer.wallmartapi.document.ProductDocument;
import com.wallmart.developer.wallmartapi.interfaces.IProduct;
import com.wallmart.developer.wallmartapi.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${data}")
    private String data;
    private boolean fillDB = false;

    @Override
    public Page<ProductDTO> findByBrandDescriptionLike(Pageable productPage, String value) {
        Page<ProductDocument> findLike = null;
        fillDBData();
        if (new Util(true).isLong(value)) {
            log.info("STARTING - findById");
            var valueLong = Long.parseLong(value);
            findLike = productRepository.findById(productPage, valueLong);
		}
        else {
            log.info("STARTING - findByBrandLikeOrDescriptionLike");
            findLike = productRepository.findByBrandLikeOrDescriptionLike(productPage, value, value);
        }
        applyDiscount(findLike);
        log.info("FINISHING - findBy");
        return fillProductDTO(findLike);
    }

    private void fillDBData() {
        if (!fillDB) {
            fillDB = true;
            //insertar datos
            productRepository.saveAll(new Gson().fromJson(data, new TypeToken<List<ProductDocument>>(){}.getType()));
            log.info("***SAVE ALL");
        }
    }

    private void applyDiscount(Page<ProductDocument> find){
        if (find == null) {
            return;
        }
        log.info("STARTING - applyDiscount");
        var util = new Util(true);
        find.forEach(product -> {
            if (
                util.isPalindrome(product.getBrand()) ||
                util.isPalindrome(product.getDescription()) ||
                util.isPalindrome(String.valueOf(product.getId()))
            ) {
                //Aplicar 50% de descuento
                log.info("IS PALINDROME!!!");
                product.setPrice((int)(product.getPrice() * 0.5));
            }
        });
        log.info("FINISHING - applyDiscount");
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

}