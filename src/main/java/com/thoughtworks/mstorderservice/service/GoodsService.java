package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.Repository.GoodsRepository;
import com.thoughtworks.mstorderservice.dto.GoodsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GoodsService {

    private final GoodsRepository goodsRepository;

    @Autowired
    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public List<GoodsDTO> getAllGoods(){
        return goodsRepository.findAll().stream()
                .map(GoodsDTO::from)
                .collect(Collectors.toList());
    }

    public Optional<GoodsDTO> findGoodsById(Long id) {
        return goodsRepository.findById(id)
                .map(GoodsDTO::from);
    }
}
