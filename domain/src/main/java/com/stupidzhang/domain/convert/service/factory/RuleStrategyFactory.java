package com.stupidzhang.domain.convert.service.factory;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.convert.model.req.ConvertReq;
import com.stupidzhang.domain.convert.service.RuleStrategy;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:23
 */
public class RuleStrategyFactory extends RuleStrategyConfig {

    public static ResourcePlatform getRuleStrategy(ConvertReq convertReq) {
        for (RuleStrategy ruleStrategy : strategyList) {
            if (Boolean.TRUE.equals(ruleStrategy.match(convertReq))) {
                return ruleStrategy.platform();
            }
        }
        return ResourcePlatform.DEFAULT;
    }
}
