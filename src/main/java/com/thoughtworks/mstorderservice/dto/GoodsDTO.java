package com.thoughtworks.mstorderservice.dto;

import com.thoughtworks.mstorderservice.entity.Goods;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GoodsDTO {

    private String id;

    private String name;

    private String description;

    private float price;

    private Integer stockQuantity;

    public static GoodsDTO from(Goods goods) {
        GoodsDTO goodsDTO = GoodsDTO.builder()
                .id(String.valueOf(goods.getId()))
                .name(goods.getName())
                .description(goods.getDescription())
                .price(goods.getPrice())
                .stockQuantity(goods.getStockQuantity())
                .build();
        return goodsDTO;
    }
}
