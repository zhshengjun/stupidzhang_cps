package com.stupidzhang.domain.valid.service.impl.strategy;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.config.LinkMatchConfig;
import com.stupidzhang.domain.valid.model.req.ValidReq;
import com.stupidzhang.domain.valid.service.RuleStrategy4Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:12
 */
@Service
public class JingDongRuleStrategy4Valid implements RuleStrategy4Valid {

    @Autowired
    private LinkMatchConfig linkMatchConfig;

    @Override
    public Boolean match(ValidReq validReq) {
        return StringUtils.startsWithAny(validReq.getContent(),linkMatchConfig.getJdLinkMatchs().split(","));
    }

    @Override
    public ResourcePlatform platform() {
        return ResourcePlatform.JD;
    }
}
