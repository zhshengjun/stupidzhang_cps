package com.stupidzhang.application.impl;

import com.stupidzhang.application.CpsOrderService;
import com.stupidzhang.domain.order.model.req.OrderReq;
import com.stupidzhang.domain.order.model.vo.OrderInfoVO;
import com.stupidzhang.domain.order.service.OrderService;
import com.stupidzhang.domain.order.service.factory.OrderFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpsOrderServiceImpl implements CpsOrderService {


    @Override
    public List<OrderInfoVO> orderQuery(OrderReq orderReq) {
        // 获取转换类
        OrderService orderService = OrderFactory.getOrderService(orderReq.getPlatform());
        return orderService.orderQuery(orderReq.getStartTime(),orderReq.getEndTime());
    }
}
