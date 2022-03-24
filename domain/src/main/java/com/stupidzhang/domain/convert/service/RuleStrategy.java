package com.stupidzhang.domain.convert.service;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.convert.model.req.ConvertReq;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:08
 */
public interface RuleStrategy {


    /**
     * 匹配规则
     *
     * @param convertReq 转换请求
     * @return 是否匹配
     */
    Boolean match(ConvertReq convertReq);


    /**
     * 平台
     *
     * @return omit
     */
    ResourcePlatform platform();

}
