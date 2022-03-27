package com.stupidzhang.domain.valid.service.factory;
import com.stupidzhang.domain.valid.service.RuleStrategy4Valid;
import com.stupidzhang.domain.valid.service.impl.strategy.JingDongRuleStrategy4Valid;
import com.stupidzhang.domain.valid.service.impl.strategy.PinDuoDuoRuleStrategy4Valid;
import com.stupidzhang.domain.valid.service.impl.strategy.TaoBaoRuleStrategy4Valid;
import com.stupidzhang.domain.valid.service.impl.strategy.WeChatRuleStrategy4Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author stupidzhang
 * @date 2022/3/12 15:16
 */
@Component
public class RuleStrategyConfig4Valid {
    /**
     * 转换匹配规则组
     */
    protected static CopyOnWriteArrayList<RuleStrategy4Valid> strategyList = new CopyOnWriteArrayList<>();

    @Autowired
    private JingDongRuleStrategy4Valid jingDongRuleStrategy;

    @Autowired
    private TaoBaoRuleStrategy4Valid taoBaoRuleStrategy;

    @Autowired
    private PinDuoDuoRuleStrategy4Valid pinDuoDuoRuleStrategy;

    @Autowired
    private WeChatRuleStrategy4Valid weChatRuleStrategy;


    @PostConstruct
    public void init() {
        strategyList.add(jingDongRuleStrategy);
        strategyList.add(taoBaoRuleStrategy);
        strategyList.add(pinDuoDuoRuleStrategy);
        strategyList.add(weChatRuleStrategy);
    }

}
