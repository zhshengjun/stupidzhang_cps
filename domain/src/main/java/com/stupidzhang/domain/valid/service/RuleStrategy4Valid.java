package com.stupidzhang.domain.valid.service;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.valid.model.req.ValidReq;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:08
 */
public interface RuleStrategy4Valid {


    /**
     * 匹配规则
     *
     * @param validReq 转换请求
     * @return 是否匹配
     */
    Boolean match(ValidReq validReq);


    /**
     * 平台
     *
     * @return omit
     */
    ResourcePlatform platform();

}
