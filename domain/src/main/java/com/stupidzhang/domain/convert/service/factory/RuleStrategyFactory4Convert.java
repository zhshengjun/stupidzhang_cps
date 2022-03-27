package com.stupidzhang.domain.convert.service.factory;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.convert.model.req.ConvertReq;
import com.stupidzhang.domain.convert.service.RuleStrategy4Convert;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:23
 */
public class RuleStrategyFactory4Convert extends RuleStrategyConfig4Convert {

    public static ResourcePlatform getRuleStrategy(ConvertReq convertReq) {
        for (RuleStrategy4Convert ruleStrategy4Convert : strategyList) {
            if (Boolean.TRUE.equals(ruleStrategy4Convert.match(convertReq))) {
                return ruleStrategy4Convert.platform();
            }
        }
        return ResourcePlatform.DEFAULT;
    }
}
