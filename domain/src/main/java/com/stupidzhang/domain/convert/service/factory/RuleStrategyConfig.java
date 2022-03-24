package com.stupidzhang.domain.convert.service.factory;

import com.stupidzhang.domain.convert.service.RuleStrategy;
import com.stupidzhang.domain.convert.service.impl.strategy.JingDongRuleStrategy;
import com.stupidzhang.domain.convert.service.impl.strategy.PinDuoDuoRuleStrategy;
import com.stupidzhang.domain.convert.service.impl.strategy.TaoBaoRuleStrategy;
import com.stupidzhang.domain.convert.service.impl.strategy.WeChatRuleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:16
 */
@Component
public class RuleStrategyConfig {
    /**
     * 转换匹配规则组
     */
    protected static CopyOnWriteArrayList<RuleStrategy> strategyList = new CopyOnWriteArrayList<>();

    @Autowired
    private JingDongRuleStrategy jingDongRuleStrategy;

    @Autowired
    private TaoBaoRuleStrategy taoBaoRuleStrategy;

    @Autowired
    private PinDuoDuoRuleStrategy pinDuoDuoRuleStrategy;

    @Autowired
    private WeChatRuleStrategy weChatRuleStrategy;


    @PostConstruct
    public void init() {
        strategyList.add(jingDongRuleStrategy);
        strategyList.add(taoBaoRuleStrategy);
        strategyList.add(pinDuoDuoRuleStrategy);
        strategyList.add(weChatRuleStrategy);
    }

}
