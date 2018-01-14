package com.thoughtworks.mstorderservice.controller;

import com.thoughtworks.mstorderservice.dto.GoodsDTO;
import com.thoughtworks.mstorderservice.command.ChangeStockQuantityCommand;
import com.thoughtworks.mstorderservice.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("goods")
@Slf4j
public class GoodsController {

    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping
    public List<GoodsDTO> getAllGoods() {
        return goodsService.getAllGoods();
    }

    @GetMapping("/{id}")
    public Optional<GoodsDTO> getGoods(@PathVariable Long id) {
        log.info("get goods detail by id: {}", id);
        return goodsService.findGoodsById(id);
    }

    @PatchMapping(value = "/{id}", headers = "X-MST-COMMAND=changeStockQuantity")
    public GoodsDTO updateGoods(@PathVariable String id, @RequestBody ChangeStockQuantityCommand changeStockQuantityCommand) {
        log.info("change goods [id = {}] stock quantity by command {}", id, changeStockQuantityCommand);
        return null;
    }
}
