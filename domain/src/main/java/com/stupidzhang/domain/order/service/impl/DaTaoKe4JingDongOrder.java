package com.stupidzhang.domain.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.dtk.api.client.DtkApiClient;
import com.dtk.api.request.mastertool.DtkJdOrderQueryRequest;
import com.dtk.api.response.base.DtkApiResponse;
import com.dtk.api.response.mastertool.DtkJdOrderQueryResponse;
import com.stupidzhang.domain.order.model.vo.OrderInfoVO;
import com.stupidzhang.domain.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * dataoke 京东订单查询
 *
 * @author
 * @date
 */
@Slf4j
@Service
public class DaTaoKe4JingDongOrder implements OrderService {


    @Autowired
    private DtkApiClient dtkApiClient;

    @Value("${cps.platform.dataoke.jdSecret:}")
    private String jdSecret;

    @Value("${cps.platform.dataoke.valid.code:}")
    private List<String> validCodeList;

    @Override
    public List<OrderInfoVO> orderQuery(String startTime, String endTime) {
        DtkJdOrderQueryRequest request = new DtkJdOrderQueryRequest();
        request.setVersion("v1.0.0");
        request.setType("1");
        request.setPageNo(1);
        request.setPageSize(100);
        request.setFields("goodsInfo");
        request.setKey(jdSecret);
        request.setStartTime(startTime);
        request.setEndTime(endTime);
        DtkApiResponse<List<DtkJdOrderQueryResponse>> result = dtkApiClient.execute(request);
        List<DtkJdOrderQueryResponse> orderList = result.getData();
        log.info("JD 订单查询结果：{}", JSON.toJSONString(orderList));
        return orderList.stream()
                .filter(order -> !validCodeList.contains(order.getValidCode()))
                .map(item -> {
                    OrderInfoVO info = new OrderInfoVO();
                    info.setGoodsName(item.getSkuName());
                    info.setOrderNum(Integer.parseInt(item.getSkuNum()));
                    info.setEstimateCosPrice(Double.parseDouble(item.getEstimateCosPrice()));
                    info.setCommissionRate(Double.parseDouble(item.getCommissionRate()));
                    info.setFinalRate(Double.parseDouble(item.getFinalRate()));
                    return info;
                }).collect(Collectors.toList());
    }
}
