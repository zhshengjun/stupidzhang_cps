package com.stupidzhang.domain.service;

import com.stupidzhang.common.enums.ResourcePlatform;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:08
 */
public interface RuleStrategy4Convert {


    /**
     * 匹配规则
     *
     * @param content 转换请求
     * @return 是否匹配
     */
    Boolean match(String content);


    /**
     * 平台
     *
     * @return omit
     */
    ResourcePlatform platform();

}
