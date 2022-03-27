package com.stupidzhang.domain.convert.service.factory;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.config.PlatformConfig;
import com.stupidzhang.domain.convert.service.ConvertService;
import com.stupidzhang.domain.convert.service.impl.covert.*;
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
public class ConvertConfig extends PlatformConfig {

    /**
     * 转换策略组
     */
    protected static Map<String, ConvertService> dtkConvertMap = new ConcurrentHashMap<>();

    protected static Map<String, ConvertService> ddxConvertMap = new ConcurrentHashMap<>();

    @Resource
    private DaTaoKe4JingDongConvert daTaoKe4JingDongConvert;

    @Resource
    private DaTaoKe4TaoBaoConvert daTaoKe4TaoBaoConvert;

    @Resource
    private DaTaoKe4PinDuoDuoConvert daTaoKe4PinDuoDuoConvert;

    @Resource
    private DingDanXia4JingDongConvert dingDanXiaConvert;

    @Resource
    private DingDanXia4TaoBaoConvert dingDanXia4TaoBaoConvert;

    @Resource
    private DingDanXia4PinDuoDuoConvert dingDanXia4PinDuoDuoConvert;


    @PostConstruct
    public void init() {
        dtkConvertMap.put(ResourcePlatform.JD.name(), daTaoKe4JingDongConvert);
        dtkConvertMap.put(ResourcePlatform.TB.name(), daTaoKe4TaoBaoConvert);
        dtkConvertMap.put(ResourcePlatform.PDD.name(), daTaoKe4PinDuoDuoConvert);
        ddxConvertMap.put(ResourcePlatform.JD.name(), dingDanXiaConvert);
        ddxConvertMap.put(ResourcePlatform.TB.name(), dingDanXia4TaoBaoConvert);
        ddxConvertMap.put(ResourcePlatform.PDD.name(), dingDanXia4PinDuoDuoConvert);
    }

}
