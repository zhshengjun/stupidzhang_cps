package com.stupidzhang.domain.convert.service.impl.covert;

import com.alibaba.fastjson.JSON;
import com.dtk.api.client.DtkApiClient;
import com.dtk.api.request.mastertool.DtkJdCommodityTransformLinkRequest;
import com.dtk.api.response.base.DtkApiResponse;
import com.dtk.api.response.mastertool.DtkJdCommodityTransformLinkResponse;
import com.stupidzhang.domain.convert.model.req.ConvertReq;
import com.stupidzhang.domain.convert.model.res.ConvertResult;
import com.stupidzhang.domain.convert.service.ConvertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 大淘客京东转换
 *
 * @author stupidzhang
 * @date 2022/3/12 14:05
 */
@Slf4j
@Service
public class DaTaoKe4JingDongConvert implements ConvertService {


    @Value("${convert.platform.dataoke.unionId:}")
    private String unionId;

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
}
