package com.stupidzhang.application;

import com.stupidzhang.domain.valid.model.req.ValidReq;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:13
 */
public interface CpsValidService {


    /**
     * 订单查询
     * @param validReq 查询参数
     * @return 订单列表
     */
    Boolean valid(ValidReq validReq);
}
