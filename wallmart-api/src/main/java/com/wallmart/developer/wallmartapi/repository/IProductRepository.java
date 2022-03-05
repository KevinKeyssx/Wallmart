package com.wallmart.developer.wallmartapi.repository;


import com.wallmart.developer.wallmartapi.document.ProductDocument;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
@Repository
public interface IProductRepository extends MongoRepository<ProductDocument, Long> {

}