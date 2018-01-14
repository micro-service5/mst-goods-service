package com.thoughtworks.mstorderservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsDTO {

    private String id;

    private String name;

    private String description;

    private float price;

    private Integer stockQuantity;
}
