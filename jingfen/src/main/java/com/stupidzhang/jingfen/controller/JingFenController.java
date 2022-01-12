package com.stupidzhang.jingfen.controller;

import com.stupidzhang.common.model.Result;
import com.stupidzhang.jingfen.constant.JdConstants;
import com.stupidzhang.jingfen.service.JingFenApiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("jingfen")
public class JingFenController {


    @Autowired
    private JingFenApiService jingFenApiService;

    @GetMapping(value = "/send")
    public Result<Object> testSend(@RequestParam(value = "orderTimeStr", required = false) String orderTimeStr,
                                   @RequestParam(value = "interval", required = false) Integer interval) {
        LocalDateTime orderTime;
        if (StringUtils.isNotBlank(orderTimeStr)) {
            orderTime = LocalDateTime.parse(orderTimeStr, DateTimeFormatter.ofPattern(JdConstants.DATE_TIME_FORMAT));
        } else {
            orderTime = LocalDateTime.now().withNano(0);
        }
        if (interval == null) {
            interval = 10;
        }
        LocalDateTime startTime = orderTime.minusMinutes(interval);
        String endTimeStr = orderTime.format(DateTimeFormatter.ofPattern(JdConstants.DATE_TIME_FORMAT));
        String startTimeStr = startTime.format(DateTimeFormatter.ofPattern(JdConstants.DATE_TIME_FORMAT));
        return Result.ok(jingFenApiService.queryOrderList(startTimeStr, endTimeStr));
    }


}
