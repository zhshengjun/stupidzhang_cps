package com.stupidzhang.application.impl;

import com.stupidzhang.application.CpsOrderService;
import com.stupidzhang.domain.factory.CpsFactory;
import com.stupidzhang.domain.model.req.OrderReq;
import com.stupidzhang.domain.model.vo.OrderInfoVO;
import com.stupidzhang.domain.service.CpsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpsOrderServiceImpl implements CpsOrderService {


    @Override
    public List<OrderInfoVO> orderQuery(OrderReq orderReq) {
        // 获取转换类
        CpsService orderService = CpsFactory.getService(orderReq.getPlatform());
        return orderService.orderQuery(orderReq.getStartTime(),orderReq.getEndTime());
    }
}
