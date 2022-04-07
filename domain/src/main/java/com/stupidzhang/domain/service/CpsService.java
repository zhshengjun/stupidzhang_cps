package com.stupidzhang.domain.service;

import com.stupidzhang.domain.model.req.ConvertReq;
import com.stupidzhang.domain.model.req.ConvertResult;
import com.stupidzhang.domain.model.vo.OrderInfoVO;

import java.util.List;

/**
 * @author stupidzhang
 * @date 2022/4/7 13:41
 */
public interface CpsService {

    /**
     * 转换接口
     *
     * @param convertReq 转换内容
     * @return 转换结果
     */
    ConvertResult convert(ConvertReq convertReq);

    /**
     * 推广链接校验
     * @param content 内容
     * @return omit
     */
    Boolean valid(String content);



    /**
     * 根据实际能获取指定的订单
     * @param startTime 开始时间
     * @param endTime 结束书剑
     * @return 订单列表
     */
    List<OrderInfoVO> orderQuery(String startTime, String endTime);
}
