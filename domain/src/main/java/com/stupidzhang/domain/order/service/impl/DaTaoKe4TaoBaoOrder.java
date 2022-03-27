package com.stupidzhang.domain.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.dtk.api.client.DtkApiClient;
import com.dtk.api.request.mastertool.DtkGetOrderDetailsRequest;
import com.dtk.api.response.base.DtkApiResponse;
import com.dtk.api.response.base.DtkPageResponse;
import com.dtk.api.response.mastertool.DtkGetOrderDetailsResponse;
import com.dtk.api.response.mastertool.DtkGetOrderDetailsResultsItemsResponse;
import com.dtk.api.response.mastertool.DtkGetOrderDetailsResultsResponse;
import com.stupidzhang.domain.order.model.vo.OrderInfoVO;
import com.stupidzhang.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DaTaoKe4TaoBaoOrder implements OrderService {


    @Autowired
    private DtkApiClient dtkApiClient;

    @Override
    public List<OrderInfoVO> orderQuery(String startTime, String endTime) {
        DtkGetOrderDetailsRequest request = new DtkGetOrderDetailsRequest();
        request.setVersion("v1.0.0");
        request.setQueryType(2);
        request.setStartTime(startTime);
        request.setEndTime(endTime);
        request.setTkStatus(12);
        request.setJumpType(1);
        request.setOrderScene(1);
        DtkApiResponse<DtkGetOrderDetailsResponse> execute = dtkApiClient.execute(request);
        JSON.toJSONString(execute);
        DtkGetOrderDetailsResponse data = execute.getData();
        if (data == null) {
            return Collections.emptyList();
        }
        DtkGetOrderDetailsResultsResponse results = data.getResults();
        if (results == null) {
            return Collections.emptyList();
        }
        List<DtkGetOrderDetailsResultsItemsResponse> orderList = results.getPublisherOrderDto();
        return orderList.stream().map(item -> {
            OrderInfoVO info = new OrderInfoVO();
            info.setGoodsName(item.getItemTitle());
            info.setOrderNum(item.getItemNum());
            info.setEstimateCosPrice(Double.parseDouble(item.getAlipayTotalPrice()));
            info.setCommissionRate(Double.parseDouble(item.getIncomeRate()));
            info.setFinalRate(Double.parseDouble(item.getIncomeRate()));
            return info;
        }).collect(Collectors.toList());
    }
}
