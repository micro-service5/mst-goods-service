package com.thoughtworks.mstorderservice.command;

import com.thoughtworks.mstorderservice.enums.StockQuantityOperator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ChangeStockQuantityCommand {

    private int quantity;

    private StockQuantityOperator operator;
}
