package com.stupidzhang.domain.convert.service;

import com.stupidzhang.domain.convert.model.req.ConvertReq;
import com.stupidzhang.domain.convert.model.res.ConvertResult;

/**
 * @author stupidzhang
 * @date 2022/3/12 14:01
 */
public interface ConvertService {


    /**
     * 转换接口
     *
     * @param convertReq 转换内容
     * @return 转换结果
     */
    ConvertResult convert(ConvertReq convertReq);
}
