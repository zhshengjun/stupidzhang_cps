package com.stupidzhang.domain.factory;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.service.RuleStrategy4Convert;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:23
 */
public class RuleStrategyFactory extends RuleStrategyConfig {

    public static ResourcePlatform getRuleStrategy(String content) {
        for (RuleStrategy4Convert ruleStrategy4Convert : strategyList) {
            if (Boolean.TRUE.equals(ruleStrategy4Convert.match(content))) {
                return ruleStrategy4Convert.platform();
            }
        }
        return ResourcePlatform.DEFAULT;
    }
}
