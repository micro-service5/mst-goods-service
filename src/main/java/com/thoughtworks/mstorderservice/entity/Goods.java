package com.thoughtworks.mstorderservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    @Id
    private Long id;

    private String name;

    private String description;

    private float price;

    private Integer stockQuantity;
}
