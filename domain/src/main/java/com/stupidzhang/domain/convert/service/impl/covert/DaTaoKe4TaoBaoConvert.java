package com.stupidzhang.domain.convert.service.impl.covert;

import com.alibaba.fastjson.JSON;
import com.dtk.api.client.DtkApiClient;
import com.dtk.api.request.mastertool.DtkTwdToTwdRequest;
import com.dtk.api.response.base.DtkApiResponse;
import com.dtk.api.response.mastertool.DtkTwdToTwdResponse;
import com.stupidzhang.domain.convert.model.req.ConvertReq;
import com.stupidzhang.domain.convert.model.res.ConvertResult;
import com.stupidzhang.domain.convert.service.ConvertService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 大淘客淘宝转换
 *
 * @author stupidzhang
 * @date 2022/3/12 14:05
 */
@Slf4j
@Service
public class DaTaoKe4TaoBaoConvert implements ConvertService {

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
}
