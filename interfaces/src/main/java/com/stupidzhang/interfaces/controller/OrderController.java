package com.stupidzhang.interfaces.controller;

import com.stupidzhang.application.CpsOrderService;
import com.stupidzhang.common.Result;
import com.stupidzhang.domain.order.model.req.OrderReq;
import com.stupidzhang.domain.order.model.vo.OrderInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:24
 */
@Api(tags = "B、订单")
@RestController
@RequestMapping("/cps/order")
public class OrderController {

    @Autowired
    private CpsOrderService cpsOrderService;

    @ApiOperation(value = "订单")
    @GetMapping("")
    public Result<List<OrderInfoVO>> convert(OrderReq orderReq) {
        return Result.ok(cpsOrderService.orderQuery(orderReq));
    }
}
