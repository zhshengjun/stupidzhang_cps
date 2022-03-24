package com.stupidzhang.domain.convert.service.impl.strategy;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.convert.model.req.ConvertReq;
import com.stupidzhang.domain.convert.service.RuleStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:12
 */
@Service
public class TaoBaoRuleStrategy implements RuleStrategy {

    @Override
    public Boolean match(ConvertReq convertReq) {
        String originContent = convertReq.getOriginContent();
        return StringUtils.containsAny(originContent, "https://m.tb.cn", "http://m.tb.cn", "嘻", "哈", "信", "啊", "hi:/", "ha:/");
    }

    @Override
    public ResourcePlatform platform() {
        return ResourcePlatform.TB;
    }
}
