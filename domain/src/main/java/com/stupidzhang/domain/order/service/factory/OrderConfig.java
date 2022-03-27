package com.stupidzhang.domain.order.service.factory;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.config.PlatformConfig;
import com.stupidzhang.domain.order.service.OrderService;
import com.stupidzhang.domain.order.service.impl.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author stupidzhang
 * @date 2022/3/12 14:10
 */
@Component
public class OrderConfig extends PlatformConfig {

    /**
     * 转换策略组
     */
    protected static Map<String, OrderService> dtkOrderMap = new ConcurrentHashMap<>();

    protected static Map<String, OrderService> ddxOrderMap = new ConcurrentHashMap<>();

    @Resource
    private DaTaoKe4JingDongOrder daTaoKe4JingDongOrder;

    @Resource
    private DaTaoKe4TaoBaoOrder daTaoKe4TaoBaoOrder;

    @Resource
    private DaTaoKe4PinDuoDuoOrder daTaoKe4PinDuoDuoOrder;

    @Resource
    private DingDanXia4JingDongOrder dingDanXia4JingDongOrder;

    @Resource
    private DingDanXia4TaoBaoOrder dingDanXia4TaoBaoOrder;

    @Resource
    private DingDanXia4PinDuoDuoOrder dingDanXia4PinDuoDuoOrder;


    @PostConstruct
    public void init() {
        dtkOrderMap.put(ResourcePlatform.JD.name(), daTaoKe4JingDongOrder);
        dtkOrderMap.put(ResourcePlatform.TB.name(), daTaoKe4TaoBaoOrder);
        dtkOrderMap.put(ResourcePlatform.PDD.name(), daTaoKe4PinDuoDuoOrder);
        ddxOrderMap.put(ResourcePlatform.JD.name(), dingDanXia4JingDongOrder);
        ddxOrderMap.put(ResourcePlatform.TB.name(), dingDanXia4TaoBaoOrder);
        ddxOrderMap.put(ResourcePlatform.PDD.name(), dingDanXia4PinDuoDuoOrder);
    }

}
