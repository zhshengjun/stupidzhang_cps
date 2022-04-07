package com.stupidzhang.domain.factory;

import com.stupidzhang.domain.service.RuleStrategy4Convert;
import com.stupidzhang.domain.service.strategy.JingDongRuleStrategy;
import com.stupidzhang.domain.service.strategy.PinDuoDuoRuleStrategy;
import com.stupidzhang.domain.service.strategy.TaoBaoRuleStrategy;
import com.stupidzhang.domain.service.strategy.WeChatRuleStrategy;
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
    protected static CopyOnWriteArrayList<RuleStrategy4Convert> strategyList = new CopyOnWriteArrayList<>();

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
