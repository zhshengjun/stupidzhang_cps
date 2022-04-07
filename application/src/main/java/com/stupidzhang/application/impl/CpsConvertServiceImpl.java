package com.stupidzhang.application.impl;

import com.alibaba.fastjson.JSON;
import com.stupidzhang.application.CpsConvertService;
import com.stupidzhang.domain.factory.CpsServiceFactory;
import com.stupidzhang.domain.model.req.ConvertReq;
import com.stupidzhang.domain.service.CpsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:15
 */
@Slf4j
@Service
public class CpsConvertServiceImpl implements CpsConvertService {

    @Override
    public String convert(ConvertReq convertReq) {
        // 获取转换类
        log.info("转换前参数：{}", JSON.toJSONString(convertReq));
        CpsService convert = CpsServiceFactory.getService(convertReq.getOriginContent());
        return convert.convert(convertReq).getConvertContent();
    }
}
