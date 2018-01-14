package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.Repository.GoodsRepository;
import com.thoughtworks.mstorderservice.exception.GoodsNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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

}
