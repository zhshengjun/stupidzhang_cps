package com.stupidzhang.domain.order.model.req;

import com.stupidzhang.common.enums.ResourcePlatform;
import lombok.Data;

/**
 * 订单查询类
 *
 * @author stupidzhang
 * @date 2022/3/12 10:57
 */
@Data
public class OrderReq {

    /**
     * 平台
     */
    private ResourcePlatform platform;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;
}
