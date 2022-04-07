package com.stupidzhang.domain.factory;


import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.service.CpsService;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:17
 */
public class CpsServiceFactory {

    public static CpsService getService(String content) {
        ResourcePlatform ruleStrategy = RuleStrategyFactory.getRuleStrategy(content);
        return CpsFactory.getService(ruleStrategy);
    }
}
