package com.stupidzhang.domain.convert.service.factory;

import com.stupidzhang.common.enums.ConvertPlatformEnum;
import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.convert.service.ConvertService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:00
 */
@Configuration
public class ConvertFactory extends ConvertConfig {


    private static String platformType;

    @Value("${convert.platform.type:}")
    public void setPlatform(String type) {
        platformType = type;
    }

    public static ConvertService getConvertService(ResourcePlatform resourcePlatform) {

        if (ConvertPlatformEnum.DDX.name().equals(platformType)) {
            return ddxConvertMap.get(resourcePlatform.name());
        }
        return dtkConvertMap.get(resourcePlatform.name());
    }
}
