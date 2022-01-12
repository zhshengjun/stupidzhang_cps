package com.stupidzhang.jingfen.mode;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductOrder {

    private Integer number;

    private String estimateFee;

    private String items;

}
