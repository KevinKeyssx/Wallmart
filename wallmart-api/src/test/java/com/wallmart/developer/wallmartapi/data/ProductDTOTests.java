package com.wallmart.developer.wallmartapi.data;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class ProductDTOTests {

    @Test
	void testConstructor() {
		var productDTO = new ProductDTO(
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
		var productDTO = new ProductDTO();
		productDTO.setId(1L);
		productDTO.setBrand("Test");
		productDTO.setDescription("Product");
		productDTO.setImage("image");
		productDTO.setPrice(123123);
		assertEquals(productDTO);
	}

	private void assertEquals(ProductDTO productDTO) {
		Assert.assertNotNull(productDTO);
		Assert.assertEquals("1", String.valueOf(productDTO.getId()));
		Assert.assertEquals("Test", productDTO.getBrand());
		Assert.assertEquals("Product", productDTO.getDescription());
		Assert.assertEquals("image", productDTO.getImage());
		Assert.assertEquals(123123, productDTO.getPrice());
	}

}