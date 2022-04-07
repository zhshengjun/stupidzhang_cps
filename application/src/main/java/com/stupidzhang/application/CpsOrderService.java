package com.stupidzhang.application;

import com.stupidzhang.domain.model.req.OrderReq;
import com.stupidzhang.domain.model.vo.OrderInfoVO;

import java.util.List;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:13
 */
public interface CpsOrderService {


    /**
     * 订单查询
     * @param orderReq 查询参数
     * @return 订单列表
     */
    List<OrderInfoVO> orderQuery(OrderReq orderReq);
}
