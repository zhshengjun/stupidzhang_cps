package com.stupidzhang.domain.service.impl.dataoke;

import com.alibaba.fastjson.JSON;
import com.dtk.api.client.DtkApiClient;
import com.dtk.api.request.mastertool.DtkJdCommodityTransformLinkRequest;
import com.dtk.api.request.mastertool.DtkJdLinkAnalysisRequest;
import com.dtk.api.request.mastertool.DtkJdOrderQueryRequest;
import com.dtk.api.request.putstorage.DtkJdCommodityDetailsRequest;
import com.dtk.api.request.putstorage.DtkStaleGoodsByTimeRequest;
import com.dtk.api.response.base.DtkApiResponse;
import com.dtk.api.response.mastertool.DtkJdCommodityTransformLinkResponse;
import com.dtk.api.response.mastertool.DtkJdLinkAnalysisResponse;
import com.dtk.api.response.mastertool.DtkJdOrderQueryResponse;
import com.dtk.api.response.putstorage.DtkJdCommodityDetailsResponse;
import com.stupidzhang.common.ResultCode;
import com.stupidzhang.domain.model.req.ConvertReq;
import com.stupidzhang.domain.model.req.ConvertResult;
import com.stupidzhang.domain.model.vo.OrderInfoVO;
import com.stupidzhang.domain.service.CpsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 大淘客京东转换
 *
 * @author stupidzhang
 * @date 2022/3/12 14:05
 */
@Slf4j
@Service
public class DaTaoKe4JingDong implements CpsService {


    @Value("${cps.platform.dataoke.unionId:}")
    private String unionId;

    @Value("${cps.platform.dataoke.jdSecret:}")
    private String jdSecret;

    @Value("${cps.platform.dataoke.valid.code:}")
    private List<String> validCodeList;

    @Autowired
    private DtkApiClient dtkApiClient;

    @Override
    public ConvertResult convert(ConvertReq convertReq) {
        DtkJdCommodityTransformLinkRequest request = new DtkJdCommodityTransformLinkRequest();
        request.setVersion("v1.0.0");
        request.setUnionId(unionId);
        request.setMaterialId(convertReq.getOriginContent());
        DtkApiResponse<DtkJdCommodityTransformLinkResponse> result = dtkApiClient.execute(request);
        log.info("转换结果:{}", JSON.toJSONString(result));
        if (result.getCode() == 0) {
            return new ConvertResult(result.getData().getShortUrl());
        }
        return new ConvertResult("查询优惠券失败");
    }

    @Override
    public Boolean valid(String content) {
        DtkJdLinkAnalysisRequest request = new DtkJdLinkAnalysisRequest();
        request.setVersion("v1.0.0");
        request.setUrl(content);
        DtkApiResponse<DtkJdLinkAnalysisResponse> result = dtkApiClient.execute(request);
        log.info("{}:链接解析,结果:{}", content, JSON.toJSONString(result));
        if (!Objects.equals(ResultCode._0, result.getCode())) {
            return Boolean.FALSE;
        }
        String skuId = result.getData().getSkuId();

        DtkJdCommodityDetailsRequest request2 = new DtkJdCommodityDetailsRequest();
        request2.setVersion("v1.0.0");
        request2.setSkuIds(skuId);
        DtkApiResponse<List<DtkJdCommodityDetailsResponse>> result2 = dtkApiClient.execute(request2);
        log.info("{}:商品详情解析,结果:{}", content, JSON.toJSONString(result2));
        return Objects.equals(ResultCode._0, result2.getCode());
    }

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
        return orderList.stream().filter(order -> !validCodeList.contains(order.getValidCode())).map(item -> {
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
