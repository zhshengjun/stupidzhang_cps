package com.stupidzhang.domain.valid.service.factory;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.config.PlatformConfig;
import com.stupidzhang.domain.valid.service.ValidService;
import com.stupidzhang.domain.valid.service.impl.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ValidConfig extends PlatformConfig {

    /**
     * 转换策略组
     */
    protected static Map<String, ValidService> dtkValidMap = new ConcurrentHashMap<>();

    protected static Map<String, ValidService> ddxValidMap = new ConcurrentHashMap<>();

    @Resource
    private DaTaoKe4JingDongValid daTaoKe4JingDongValid;

    @Resource
    private DaTaoKe4TaoBaoValid daTaoKe4TaoBaoValid;

    @Resource
    private DaTaoKe4PinDuoDuoValid daTaoKe4PinDuoDuoValid;

    @Resource
    private DingDanXia4JingDongValid dingDanXiaValid;

    @Resource
    private DingDanXia4TaoBaoValid dingDanXia4TaoBaoValid;

    @Resource
    private DingDanXia4PinDuoDuoValid dingDanXia4PinDuoDuoValid;


    @PostConstruct
    public void init() {
        dtkValidMap.put(ResourcePlatform.JD.name(), daTaoKe4JingDongValid);
        dtkValidMap.put(ResourcePlatform.TB.name(), daTaoKe4TaoBaoValid);
        dtkValidMap.put(ResourcePlatform.PDD.name(), daTaoKe4PinDuoDuoValid);
        ddxValidMap.put(ResourcePlatform.JD.name(), dingDanXiaValid);
        ddxValidMap.put(ResourcePlatform.TB.name(), dingDanXia4TaoBaoValid);
        ddxValidMap.put(ResourcePlatform.PDD.name(), dingDanXia4PinDuoDuoValid);
    }
}
