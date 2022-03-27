package com.stupidzhang.domain.valid.service.factory;

import com.stupidzhang.common.enums.ConvertPlatformEnum;
import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.valid.service.ValidService;
import org.springframework.context.annotation.Configuration;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:00
 */
@Configuration
public class ValidFactory extends ValidConfig {

    public static ValidService getValidService(ResourcePlatform resourcePlatform) {

        if (ConvertPlatformEnum.DDX.name().equals(platformType)) {
            return ddxValidMap.get(resourcePlatform.name());
        }
        return dtkValidMap.get(resourcePlatform.name());
    }
}
