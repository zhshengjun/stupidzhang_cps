package com.stupidzhang.domain.order.service.factory;

import com.stupidzhang.common.enums.ConvertPlatformEnum;
import com.stupidzhang.common.enums.ResourcePlatform;
import com.stupidzhang.domain.convert.service.ConvertService;
import com.stupidzhang.domain.convert.service.factory.ConvertConfig;
import com.stupidzhang.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:00
 */
@Configuration
public class OrderFactory extends OrderConfig {

    public static OrderService getOrderService(ResourcePlatform resourcePlatform) {
        if (ConvertPlatformEnum.DDX.name().equals(platformType)) {
            return ddxOrderMap.get(resourcePlatform.name());
        }
        return dtkOrderMap.get(resourcePlatform.name());
    }
}
