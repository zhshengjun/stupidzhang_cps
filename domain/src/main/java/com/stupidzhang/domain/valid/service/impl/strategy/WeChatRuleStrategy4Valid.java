package com.stupidzhang.domain.valid.service.impl.strategy;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.valid.model.req.ValidReq;
import com.stupidzhang.domain.valid.service.RuleStrategy4Valid;
import org.springframework.stereotype.Service;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:12
 */
@Service
public class WeChatRuleStrategy4Valid implements RuleStrategy4Valid {

    @Override
    public Boolean match(ValidReq validReq) {
        return null;
    }

    @Override
    public ResourcePlatform platform() {
        return ResourcePlatform.WECHAT;
    }
}
