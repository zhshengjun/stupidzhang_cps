package com.stupidzhang.domain.convert.service.impl.strategy;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.config.LinkMatchConfig;
import com.stupidzhang.domain.convert.model.req.ConvertReq;
import com.stupidzhang.domain.convert.service.RuleStrategy4Convert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:12
 */
@Service
public class JingDongRuleStrategy4Convert implements RuleStrategy4Convert {

    @Autowired
    private LinkMatchConfig linkMatchConfig;

    @Override
    public Boolean match(ConvertReq convertReq) {
        return StringUtils.startsWithAny(convertReq.getOriginContent(), linkMatchConfig.getJdLinkMatchs().split(","));
    }

    @Override
    public ResourcePlatform platform() {
        return ResourcePlatform.JD;
    }
}
