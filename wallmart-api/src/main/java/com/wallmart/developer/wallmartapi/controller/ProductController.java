package com.wallmart.developer.wallmartapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wallmart.developer.wallmartapi.common.Constants;
import com.wallmart.developer.wallmartapi.common.Util;
import com.wallmart.developer.wallmartapi.data.ProductDTO;
import com.wallmart.developer.wallmartapi.data.ResponseDTO;
import com.wallmart.developer.wallmartapi.document.ProductDocument;
import com.wallmart.developer.wallmartapi.interfaces.IProduct;

import lombok.extern.log4j.Log4j2;

import java.text.ParseException;
import java.util.Date;

import javax.validation.Valid;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
@CrossOrigin
@RestController
@RequestMapping(Constants.END_REQUEST)
@Log4j2
public class ProductController {

    @Autowired
	private IProduct iProduct;

    @GetMapping(path = Constants.SEARCH_ALL, produces = "application/json")
	public ResponseEntity<Page<ProductDTO>> findAll(
		@RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
		@RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
		@RequestParam(defaultValue = Constants.DEFAULT_ORDER) String order,
		@RequestParam(defaultValue = Constants.DEFAULT_ASC) boolean asc
	) throws ParseException {
		log.info("*START - Controller findAll*");
		var sort = asc ? Sort.by(order) : Sort.by(order).descending();
		var productsDTO = iProduct.findAll(PageRequest.of(page, size, sort));
		log.info("*FINISHED - Controller findAll*");
		return new ResponseEntity<>(productsDTO, new Util(true).typeStatus(productsDTO));
	}

	@GetMapping(path = Constants.SEARCH_BY_ID, produces = "application/json")
	public ResponseEntity<ProductDTO> findById(@RequestParam Long id) throws ParseException {
		log.info("*START - Controller findById*");
		var productsDTO = iProduct.findById(id);
		log.info("*FINISHED - Controller findById*");
		return new ResponseEntity<>(productsDTO, new Util(true).typeStatus(productsDTO));
	}

	@GetMapping(path = Constants.SEARCH_BY_PRODUCT, produces = "application/json")
	public ResponseEntity<Page<ProductDTO>> findByProduct(
		@RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
		@RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
		@RequestParam(defaultValue = Constants.DEFAULT_ORDER) String order,
		@RequestParam(defaultValue = Constants.DEFAULT_ASC) boolean asc,
		@RequestParam String value
	) throws ParseException {
		log.info("*START - Controller findByProduct*");
		var sort = asc ? Sort.by(order) : Sort.by(order).descending();
		var productsDTO = iProduct.findByBrandDescriptionLike(PageRequest.of(page, size, sort), value);
		log.info("*FINISHED - Controller findByProduct*");
		return new ResponseEntity<>(productsDTO, new Util(true).typeStatus(productsDTO));
	}

	@PostMapping(path =	Constants.SAVE, consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseDTO> save(@Valid @RequestBody ProductDocument tareaDTO) {
		log.info("*START - Controller save*");
		iProduct.save(tareaDTO);
		log.info("*FINISHED - Controller save*");
		return new ResponseEntity<>(new ResponseDTO(Constants.SUCCESS_SAVE, new Date(), true), HttpStatus.CREATED);
	}

}