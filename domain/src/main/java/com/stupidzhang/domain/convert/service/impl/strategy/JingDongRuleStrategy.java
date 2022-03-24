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
public class JingDongRuleStrategy implements RuleStrategy {

    public final String CONTENT_URL_PR = "https://item.jd.com/";
    public final String CONTENT_URL_PR_2 = "https://item.m.jd.com/";
    public final String CONTENT_URL_PR_3 = "https://u.jd.com/";

    @Override
    public Boolean match(ConvertReq convertReq) {
        return StringUtils.startsWithAny(convertReq.getOriginContent(), CONTENT_URL_PR, CONTENT_URL_PR_2, CONTENT_URL_PR_3);
    }

    @Override
    public ResourcePlatform platform() {
        return ResourcePlatform.JD;
    }
}
