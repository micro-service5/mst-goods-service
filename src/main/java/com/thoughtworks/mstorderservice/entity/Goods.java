package com.thoughtworks.mstorderservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
@Getter
@Setter
public class Goods {

    private Long id;

    private String name;

    private String description;

    private float price;

    private Integer stockQuantity;
}
