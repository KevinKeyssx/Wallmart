package com.wallmart.developer.wallmartapi.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class ProductDocument implements Serializable {

    @Id
    private Long id;
	private String brand;
	private String description;
	private String image;
	private int price;

}