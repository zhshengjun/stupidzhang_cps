package com.stupidzhang.application.impl;

import com.alibaba.fastjson.JSON;
import com.stupidzhang.application.CpsConvertService;
import com.stupidzhang.domain.convert.model.req.ConvertReq;
import com.stupidzhang.domain.convert.service.ConvertService;
import com.stupidzhang.domain.convert.service.factory.ConvertServiceFactory;
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
        ConvertService convert = ConvertServiceFactory.getConvert(convertReq);
        return convert.convert(convertReq).getConvertContent();
    }
}
