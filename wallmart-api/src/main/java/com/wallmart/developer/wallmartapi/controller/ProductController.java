package com.wallmart.developer.wallmartapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wallmart.developer.wallmartapi.common.Constants;
import com.wallmart.developer.wallmartapi.common.Util;
import com.wallmart.developer.wallmartapi.document.ProductDocument;
import com.wallmart.developer.wallmartapi.interfaces.IProduct;
import com.wallmart.developer.wallmartapi.repository.IProductRepository;

import lombok.extern.log4j.Log4j2;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
@RestController
@RequestMapping(Constants.END_REQUEST)
@Log4j2
public class ProductController {

    @Autowired
	private IProduct iProduct;

    @GetMapping(path = Constants.SEARCH_ALL, produces = "application/json")
	public ResponseEntity<List<ProductDocument>> findAll() throws ParseException {
		log.info("*START - Controller findAll*");
		var productsDTO = iProduct.findAll();
		log.info("*FINISHED - Controller findAll*");
		return new ResponseEntity<>(productsDTO, new Util(true).typeStatus(productsDTO));
	}

}