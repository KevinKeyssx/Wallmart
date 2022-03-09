package com.wallmart.developer.wallmartapi.document;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class ProductDocumentTests {

    @Test
	void testConstructor() {
		var productDTO = new ProductDocument(
			1L,
            "Test",
            "Product",
            "image",
            123123
		);
		assertEquals(productDTO);
	}

	@Test
	void testSetter() {
		var product = new ProductDocument();
		product.setId(1L);
		product.setBrand("Test");
		product.setDescription("Product");
		product.setImage("image");
		product.setPrice(123123);
		assertEquals(product);
	}

	private void assertEquals(ProductDocument product) {
		Assert.assertNotNull(product);
		Assert.assertEquals("1", String.valueOf(product.getId()));
		Assert.assertEquals("Test", product.getBrand());
		Assert.assertEquals("Product", product.getDescription());
		Assert.assertEquals("image", product.getImage());
		Assert.assertEquals(123123, product.getPrice());
	}

}