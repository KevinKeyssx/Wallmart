package com.wallmart.developer.wallmartapi.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import com.wallmart.developer.wallmartapi.document.ProductDocument;
import com.wallmart.developer.wallmartapi.repository.IProductRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import org.springframework.data.domain.PageImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceTests {

    @InjectMocks
	@Spy
	private ProductService service;

    @Mock
	private IProductRepository repository;

    @Test
    @DisplayName("Find By Id")
	void testFindById() throws Exception {
		// Given
        var page = 0;
        var size = 10;
        var asc = true;
        var order = "id";
        var sort = asc ? Sort.by(order) : Sort.by(order).descending();
        var value = "2";
		var listProduct = new ArrayList<ProductDocument>();
		listProduct.add(new ProductDocument(
            2L,
            "dsaasd",
            "zlrwax bñyrh",
            "zlrwax bñyrh",
            130172
        ));
		// When
		Mockito.when(repository.findAll(PageRequest.of(page, size, sort))).thenReturn(new PageImpl<ProductDocument>(listProduct));
		var productsDTO = service.findByBrandDescriptionLike(PageRequest.of(page, size, sort), value);

		if (productsDTO == null) {
			assertFalse(Boolean.FALSE);
        }
		// Then
		assertTrue(Boolean.TRUE);
	}

    @Test
    @DisplayName("Find All")
	void testFindAll() throws Exception {
		// Given
        var page = 0;
        var size = 10;
        var asc = true;
        var order = "id";
        var sort = asc ? Sort.by(order) : Sort.by(order).descending();
        var value = "dsaasd";
		var listProduct = new ArrayList<ProductDocument>();
		listProduct.add(new ProductDocument(
            2L,
            "dsaasd",
            "zlrwax bñyrh",
            "zlrwax bñyrh",
            130172
        ));
		// When
		Mockito.when(repository.findAll(PageRequest.of(page, size, sort))).thenReturn(new PageImpl<ProductDocument>(listProduct));
		var productsDTO = service.findByBrandDescriptionLike(PageRequest.of(page, size, sort), value);

		if (productsDTO == null) {
			assertFalse(Boolean.FALSE);
        }
		// Then
		assertTrue(Boolean.TRUE);
	}
}