package com.wallmart.developer.wallmartapi.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO implements Serializable {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("brand")
	private String brand;
    @JsonProperty("description")
	private String description;
    @JsonProperty("image")
	private String image;
    @JsonProperty("price")
	private int price;

}