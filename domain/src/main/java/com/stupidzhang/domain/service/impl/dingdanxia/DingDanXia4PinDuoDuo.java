package com.stupidzhang.domain.service.impl.dingdanxia;

import com.stupidzhang.domain.model.req.ConvertReq;
import com.stupidzhang.domain.model.req.ConvertResult;
import com.stupidzhang.domain.model.vo.OrderInfoVO;
import com.stupidzhang.domain.service.CpsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单侠拼多多转换
 *
 * @author stupidzhang
 * @date 2022/3/12 14:05
 */
@Service
public class DingDanXia4PinDuoDuo implements CpsService {


    @Override
    public ConvertResult convert(ConvertReq convertReq) {
        return null;
    }

    @Override
    public Boolean valid(String content) {
        return null;
    }

    @Override
    public List<OrderInfoVO> orderQuery(String startTime, String endTime) {
        return null;
    }
}
