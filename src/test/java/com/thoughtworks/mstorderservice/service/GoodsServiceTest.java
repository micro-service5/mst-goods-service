package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.Repository.GoodsRepository;
import com.thoughtworks.mstorderservice.command.ChangeStockQuantityCommand;
import com.thoughtworks.mstorderservice.enums.StockQuantityOperator;
import com.thoughtworks.mstorderservice.exception.GoodsNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static com.thoughtworks.mstorderservice.enums.StockQuantityOperator.MINUS;
import static com.thoughtworks.mstorderservice.enums.StockQuantityOperator.PLUS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class GoodsServiceTest {

    @InjectMocks
    GoodsService goodsService;

    @Mock
    GoodsRepository goodsRepository;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void should_throw_GoodsNotFoundException_when_goods_is_not_found_by_given_id() {
        final Long id = 1L;

        when(goodsRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(GoodsNotFoundException.class, () -> goodsService.changeStockQuantity(id, null));
    }

    @Test
    void should_plus_stock_quantity_successfully() {
        final int stockQuantity = 10;

        Integer result = goodsService.calculateStockQuantity(
                stockQuantity, generateChangeStockQuantityCommand(5, PLUS));

        assertEquals(15, result.intValue());
    }

    @Test
    void should_minus_stock_quantity_successfully() {
        final int stockQuantity = 10;

        Integer result = goodsService.calculateStockQuantity(
                stockQuantity, generateChangeStockQuantityCommand(5, MINUS));

        assertEquals(5, result.intValue());
    }

    ChangeStockQuantityCommand generateChangeStockQuantityCommand(int quantity, StockQuantityOperator operator) {
        return new ChangeStockQuantityCommand(quantity, operator);
    }

}
