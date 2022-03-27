package com.stupidzhang.domain.order.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单明细
 *
 * @author stupidzhang
 * @date 2022/3/12 11:04
 */
@Data
@NoArgsConstructor
public class OrderInfoVO {

    /**
     * 商品title
     */
    private String goodsName;


    /**
     * 订单数量
     */
    private Integer orderNum;

    /**
     * 估计价格
     */
    private Double estimateCosPrice;

    /**
     * 佣金比例
     */
    private Double commissionRate;

    /**
     * 最终分成比例
     */
    private Double finalRate;
}
