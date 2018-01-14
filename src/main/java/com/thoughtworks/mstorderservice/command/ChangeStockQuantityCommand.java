package com.thoughtworks.mstorderservice.command;

import com.thoughtworks.mstorderservice.enums.StockQuantityOperator;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeStockQuantityCommand {

    private int quantity;

    private StockQuantityOperator operator;
}
