package com.stupidzhang.domain.factory;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.config.PlatformConfig;
import com.stupidzhang.domain.service.CpsService;
import com.stupidzhang.domain.service.impl.dataoke.DaTaoKe4JingDong;
import com.stupidzhang.domain.service.impl.dataoke.DaTaoKe4PinDuoDuo;
import com.stupidzhang.domain.service.impl.dataoke.DaTaoKe4TaoBao;
import com.stupidzhang.domain.service.impl.dingdanxia.DingDanXia4JingDong;
import com.stupidzhang.domain.service.impl.dingdanxia.DingDanXia4PinDuoDuo;
import com.stupidzhang.domain.service.impl.dingdanxia.DingDanXia4TaoBao;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author stupidzhang
 * @date 2022/4/7 13:47
 */
@Component
public class CpsConfig extends PlatformConfig {

    /**
     * 转换策略组
     */
    protected static Map<String, CpsService> dtkMap = new ConcurrentHashMap<>();

    protected static Map<String, CpsService> ddxMap = new ConcurrentHashMap<>();

    @Resource
    private DaTaoKe4JingDong daTaoKe4JingDong;

    @Resource
    private DaTaoKe4TaoBao daTaoKe4TaoBao;

    @Resource
    private DaTaoKe4PinDuoDuo daTaoKe4PinDuoDuo;

    @Resource
    private DingDanXia4JingDong dingDanXia4JingDong;

    @Resource
    private DingDanXia4TaoBao dingDanXia4TaoBao;

    @Resource
    private DingDanXia4PinDuoDuo dingDanXia4PinDuoDuo;


    @PostConstruct
    public void init() {
        dtkMap.put(ResourcePlatform.JD.name(), daTaoKe4JingDong);
        dtkMap.put(ResourcePlatform.TB.name(), daTaoKe4TaoBao);
        dtkMap.put(ResourcePlatform.PDD.name(), daTaoKe4PinDuoDuo);
        ddxMap.put(ResourcePlatform.JD.name(), dingDanXia4JingDong);
        ddxMap.put(ResourcePlatform.TB.name(), dingDanXia4TaoBao);
        ddxMap.put(ResourcePlatform.PDD.name(), dingDanXia4PinDuoDuo);
    }
}
