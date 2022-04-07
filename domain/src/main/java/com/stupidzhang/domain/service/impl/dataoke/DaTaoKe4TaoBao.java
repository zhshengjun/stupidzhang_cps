package com.stupidzhang.domain.service.impl.dataoke;

import com.alibaba.fastjson.JSON;
import com.dtk.api.client.DtkApiClient;
import com.dtk.api.request.mastertool.DtkGetOrderDetailsRequest;
import com.dtk.api.request.mastertool.DtkTwdToTwdRequest;
import com.dtk.api.response.base.DtkApiResponse;
import com.dtk.api.response.mastertool.DtkGetOrderDetailsResponse;
import com.dtk.api.response.mastertool.DtkGetOrderDetailsResultsItemsResponse;
import com.dtk.api.response.mastertool.DtkGetOrderDetailsResultsResponse;
import com.dtk.api.response.mastertool.DtkTwdToTwdResponse;
import com.stupidzhang.domain.model.req.ConvertReq;
import com.stupidzhang.domain.model.req.ConvertResult;
import com.stupidzhang.domain.model.vo.OrderInfoVO;
import com.stupidzhang.domain.service.CpsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 大淘客淘宝转换
 *
 * @author stupidzhang
 * @date 2022/3/12 14:05
 */
@Slf4j
@Service
public class DaTaoKe4TaoBao implements CpsService {

    @Autowired
    private DtkApiClient dtkApiClient;

    @Override
    public ConvertResult convert(ConvertReq convertReq) {

        DtkTwdToTwdRequest request = new DtkTwdToTwdRequest();
        request.setVersion("v1.0.0");
        request.setContent(convertReq.getOriginContent());
        DtkApiResponse<DtkTwdToTwdResponse> execute = dtkApiClient.execute(request);
        log.info("转换结果:{}", JSON.toJSONString(execute));
        if(execute.getCode() == 0){
            DtkTwdToTwdResponse data = execute.getData();
            String longTpwd = data.getLongTpwd();
            String couponEndTime = data.getCouponEndTime();
            String couponInfo = data.getCouponInfo();
            return  new ConvertResult(String.format("%s fu至内容app即可领取【%s】优惠券 限%s前使用",longTpwd,couponInfo,couponEndTime));
        }
        return  new ConvertResult("非常抱歉，您的商品未查询到相关优惠券");
    }

    @Override
    public Boolean valid(String content) {
        return null;
    }

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
