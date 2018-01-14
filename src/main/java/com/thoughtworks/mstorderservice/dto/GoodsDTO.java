package com.thoughtworks.mstorderservice.dto;

import com.thoughtworks.mstorderservice.entity.Goods;
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

    public static GoodsDTO from(Goods goods){
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.id = String.valueOf(goods.getId());
        goodsDTO.name = goods.getName();
        goodsDTO.description = goods.getDescription();
        goodsDTO.price = goods.getPrice();
        goodsDTO.stockQuantity = goods.getStockQuantity();
        return goodsDTO;
    }
}
