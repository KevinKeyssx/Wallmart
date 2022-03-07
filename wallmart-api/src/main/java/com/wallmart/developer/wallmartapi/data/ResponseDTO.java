package com.wallmart.developer.wallmartapi.data;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kevin Candia
 * 17-01-2022
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO implements Serializable {

    @JsonProperty("response")
    private String response;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("status")
    private Boolean status;

    @JsonIgnore
    private static final long serialVersionUID = 1L;

}