package com.stupidzhang.domain.valid.service.factory;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.valid.model.req.ValidReq;
import com.stupidzhang.domain.valid.service.ValidService;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:17
 */
public class ValidServiceFactory {

    public static ValidService getValid(ValidReq validReq) {
        ResourcePlatform ruleStrategy = RuleStrategyFactory4Valid.getRuleStrategy(validReq);
        return ValidFactory.getValidService(ruleStrategy);
    }
}
