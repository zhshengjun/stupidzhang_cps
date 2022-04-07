package com.stupidzhang.domain.factory;

import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.common.enums.ServerPlatformEnum;
import com.stupidzhang.domain.service.CpsService;
import org.springframework.context.annotation.Configuration;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:00
 */
@Configuration
public class CpsFactory extends CpsConfig {

    public static CpsService getService(ResourcePlatform resourcePlatform) {

        if (ServerPlatformEnum.DDX.name().equals(platformType)) {
            return ddxMap.get(resourcePlatform.name());
        }
        return dtkMap.get(resourcePlatform.name());
    }
}
