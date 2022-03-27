package com.stupidzhang.domain.convert.service.impl.strategy;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.convert.model.req.ConvertReq;
import com.stupidzhang.domain.convert.service.RuleStrategy4Convert;
import org.springframework.stereotype.Service;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:12
 */
@Service
public class PinDuoDuoRuleStrategy4Convert implements RuleStrategy4Convert {

    @Override
    public Boolean match(ConvertReq convertReq) {
        return null;
    }

    @Override
    public ResourcePlatform platform() {
        return ResourcePlatform.PDD;
    }
}
