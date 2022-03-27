package com.stupidzhang.domain.valid.service.factory;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.valid.model.req.ValidReq;
import com.stupidzhang.domain.valid.service.RuleStrategy4Valid;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:23
 */
public class RuleStrategyFactory4Valid extends RuleStrategyConfig4Valid {

    public static ResourcePlatform getRuleStrategy(ValidReq validReq) {
        for (RuleStrategy4Valid ruleStrategy4Valid : strategyList) {
            if (Boolean.TRUE.equals(ruleStrategy4Valid.match(validReq))) {
                return ruleStrategy4Valid.platform();
            }
        }
        return ResourcePlatform.DEFAULT;
    }
}
