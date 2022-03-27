package com.stupidzhang.domain.convert.service.factory;


import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.convert.model.req.ConvertReq;
import com.stupidzhang.domain.convert.service.ConvertService;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:17
 */
public class ConvertServiceFactory {

    public static ConvertService getConvert(ConvertReq convertReq) {
        ResourcePlatform ruleStrategy = RuleStrategyFactory4Convert.getRuleStrategy(convertReq);
        return ConvertFactory.getConvertService(ruleStrategy);
    }
}
