package com.stupidzhang.domain.order.service;

import com.stupidzhang.domain.order.model.vo.OrderInfoVO;

import java.util.List;

/**
 * 订单查询
 */
public interface OrderService {

    /**
     * 根据实际能获取指定的订单
     * @param startTime 开始时间
     * @param endTime 结束书剑
     * @return 订单列表
     */
    List<OrderInfoVO> orderQuery(String startTime, String endTime);
}
