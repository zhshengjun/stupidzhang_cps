package com.stupidzhang.domain.convert.service.factory;

import com.stupidzhang.domain.convert.service.RuleStrategy4Convert;
import com.stupidzhang.domain.convert.service.impl.strategy.JingDongRuleStrategy4Convert;
import com.stupidzhang.domain.convert.service.impl.strategy.PinDuoDuoRuleStrategy4Convert;
import com.stupidzhang.domain.convert.service.impl.strategy.TaoBaoRuleStrategy4Convert;
import com.stupidzhang.domain.convert.service.impl.strategy.WeChatRuleStrategy4Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:16
 */
@Component
public class RuleStrategyConfig4Convert {
    /**
     * 转换匹配规则组
     */
    protected static CopyOnWriteArrayList<RuleStrategy4Convert> strategyList = new CopyOnWriteArrayList<>();

    @Autowired
    private JingDongRuleStrategy4Convert jingDongRuleStrategy;

    @Autowired
    private TaoBaoRuleStrategy4Convert taoBaoRuleStrategy;

    @Autowired
    private PinDuoDuoRuleStrategy4Convert pinDuoDuoRuleStrategy;

    @Autowired
    private WeChatRuleStrategy4Convert weChatRuleStrategy;


    @PostConstruct
    public void init() {
        strategyList.add(jingDongRuleStrategy);
        strategyList.add(taoBaoRuleStrategy);
        strategyList.add(pinDuoDuoRuleStrategy);
        strategyList.add(weChatRuleStrategy);
    }

}
