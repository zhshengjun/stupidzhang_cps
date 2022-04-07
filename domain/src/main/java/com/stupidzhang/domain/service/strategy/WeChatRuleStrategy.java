package com.stupidzhang.domain.service.strategy;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.service.RuleStrategy4Convert;
import org.springframework.stereotype.Service;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:12
 */
@Service
public class WeChatRuleStrategy implements RuleStrategy4Convert {

    @Override
    public Boolean match(String content) {
        return null;
    }

    @Override
    public ResourcePlatform platform() {
        return ResourcePlatform.WECHAT;
    }
}
