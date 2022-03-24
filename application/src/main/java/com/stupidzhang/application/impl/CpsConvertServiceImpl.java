package com.stupidzhang.application.impl;

import com.stupidzhang.application.CpsConvertService;
import com.stupidzhang.domain.convert.model.req.ConvertReq;
import com.stupidzhang.domain.convert.service.ConvertService;
import com.stupidzhang.domain.convert.service.factory.ConvertServiceFactory;
import org.springframework.stereotype.Service;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:15
 */
@Service
public class CpsConvertServiceImpl implements CpsConvertService {

    @Override
    public String convert(ConvertReq convertReq) {
        // 获取转换类
        ConvertService convert = ConvertServiceFactory.getConvert(convertReq);
        return convert.convert(convertReq).getConvertContent();
    }
}
