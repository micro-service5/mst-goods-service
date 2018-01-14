package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.Repository.GoodsRepository;
import com.thoughtworks.mstorderservice.command.ChangeStockQuantityCommand;
import com.thoughtworks.mstorderservice.dto.GoodsDTO;
import com.thoughtworks.mstorderservice.entity.Goods;
import com.thoughtworks.mstorderservice.exception.GoodsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.thoughtworks.mstorderservice.enums.StockQuantityOperator.MINUS;

@Service
public class GoodsService {

    private final GoodsRepository goodsRepository;

    @Autowired
    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public List<GoodsDTO> getAllGoods() {
        return goodsRepository.findAll().stream()
                .map(GoodsDTO::from)
                .collect(Collectors.toList());
    }

    public Optional<GoodsDTO> findGoodsById(Long id) {
        return goodsRepository.findById(id)
                .map(GoodsDTO::from);
    }

    public GoodsDTO changeStockQuantity(Long id, ChangeStockQuantityCommand changeStockQuantityCommand) {
        Goods goods = goodsRepository.findById(id)
                .orElseThrow(() -> new GoodsNotFoundException(id));

        goods.setStockQuantity(calculateStockQuantity(goods.getStockQuantity(), changeStockQuantityCommand));

        return GoodsDTO.from(goodsRepository.save(goods));
    }

    Integer calculateStockQuantity(Integer originStockQuantity, ChangeStockQuantityCommand changeStockQuantityCommand) {
        int quantity = changeStockQuantityCommand.getQuantity();

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (changeStockQuantityCommand.getOperator() == MINUS) {
            return originStockQuantity - quantity;
        } else {
            return originStockQuantity + quantity;
        }
    }
}
