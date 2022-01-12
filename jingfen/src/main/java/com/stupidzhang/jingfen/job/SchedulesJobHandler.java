package com.stupidzhang.jingfen.job;


import com.stupidzhang.jingfen.constant.JdConstants;
import com.stupidzhang.jingfen.mode.ProductOrder;
import com.stupidzhang.jingfen.service.JingFenApiService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Slf4j
@Component
public class SchedulesJobHandler {

    @Autowired
    private JingFenApiService jingFenApiService;


    @XxlJob("schedulesJobHandler")
    public ReturnT<String> schedulesJobHandler() {
        LocalDateTime orderTime = LocalDateTime.now().withNano(0);
        LocalDateTime startTime = orderTime.minusMinutes(60);
        String endTimeStr = orderTime.format(DateTimeFormatter.ofPattern(JdConstants.DATE_TIME_FORMAT));
        String startTimeStr = startTime.format(DateTimeFormatter.ofPattern(JdConstants.DATE_TIME_FORMAT));
        ProductOrder productOrder = jingFenApiService.queryOrderList(startTimeStr, endTimeStr);
        log.warn("京粉订单消息定时任务调度成功");
        if(productOrder != null){
            log.info("京粉订单:{}", productOrder);
        }
        return ReturnT.SUCCESS;
    }


    @XxlJob("testJobHandler")
    public ReturnT<String> testJobHandler() {
        log.warn("测试任务接收成功");
        return ReturnT.SUCCESS;
    }

}
