package com.wallmart.developer.wallmartapi.controller;

import com.wallmart.developer.wallmartapi.common.Constants;
import com.wallmart.developer.wallmartapi.data.ProductDTO;
import com.wallmart.developer.wallmartapi.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTests {

    @Autowired
	private MockMvc mockMvc;

    @MockBean
	private ProductService service;

    private int page = 0;
    private int size = 10;
    private boolean asc = true;
    private String order = "id";
    private Sort sort = asc ? Sort.by(order) : Sort.by(order).descending();
    private String value = "2";
    @SuppressWarnings("unchecked")
    private Page<ProductDTO> testTarea = Mockito.mock(Page.class);
    ObjectMapper obj = new ObjectMapper();

    @Test
	@DisplayName("Get /search")
	void testGetDataId() throws Exception {
		Mockito.when(service.findByBrandDescriptionLike(PageRequest.of(page, size, sort), value)).thenReturn(testTarea);
		mockMvc.perform(get(Constants.END_REQUEST + Constants.SEARCH_BY_PRODUCT + "?value=1&page=0&size=10&order=id&asc=true")
            .contentType(MediaType.APPLICATION_JSON)
            .content(obj.toString()))
            .andExpect(status().isNoContent());
	}

    @Test
	@DisplayName("Get /search")
	void testGetData() throws Exception {
		Mockito.when(service.findByBrandDescriptionLike(PageRequest.of(page, size, sort), value)).thenReturn(testTarea);
		mockMvc.perform(get(Constants.END_REQUEST + Constants.SEARCH_BY_PRODUCT + "?value=&page=0&size=10&order=id&asc=true")
            .contentType(MediaType.APPLICATION_JSON)
            .content(obj.toString()))
            .andExpect(status().isNoContent());
	}

}