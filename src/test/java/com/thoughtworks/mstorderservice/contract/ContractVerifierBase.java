package com.thoughtworks.mstorderservice.contract;

import com.thoughtworks.mstorderservice.MstGoodsServiceApplication;
import com.thoughtworks.mstorderservice.controller.GoodsController;
import com.thoughtworks.mstorderservice.dto.GoodsDTO;
import com.thoughtworks.mstorderservice.service.GoodsService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MstGoodsServiceApplication.class)
public class ContractVerifierBase {
    @Autowired
    private GoodsController goodsController;

    @MockBean
    private GoodsService goodsService;

    @Before
    public void setup() throws Exception {
        RestAssuredMockMvc.standaloneSetup(goodsController);
        GoodsDTO goodsDTO = GoodsDTO.builder().id("1").name("iPhone SE2").price(20.95F).build();
        Mockito.when(goodsService.getAllGoods()).thenReturn(Collections.singletonList(goodsDTO));
    }
}
