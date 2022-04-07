package com.stupidzhang.application;

import com.stupidzhang.domain.model.req.ConvertReq;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:13
 */
public interface CpsConvertService {

    String convert(ConvertReq convertReq);
}
