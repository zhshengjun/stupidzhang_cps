package com.stupidzhang.domain.valid.service.impl;

import com.alibaba.fastjson.JSON;
import com.dtk.api.client.DtkApiClient;
import com.dtk.api.request.mastertool.DtkJdLinkAnalysisRequest;
import com.dtk.api.response.base.DtkApiResponse;
import com.dtk.api.response.mastertool.DtkJdLinkAnalysisResponse;
import com.stupidzhang.common.ResultCode;
import com.stupidzhang.domain.valid.service.ValidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class DaTaoKe4JingDongValid implements ValidService {

    @Autowired
    private DtkApiClient dtkApiClient;

    @Override
    public Boolean valid(String content) {
        DtkJdLinkAnalysisRequest request = new DtkJdLinkAnalysisRequest();
        request.setVersion("v1.0.0");
        request.setUrl(content);
        DtkApiResponse<DtkJdLinkAnalysisResponse> result = dtkApiClient.execute(request);
        log.info("{}:失效检查,结果:{}",content, JSON.toJSONString(result));
        return Objects.equals(ResultCode._0, result.getCode());
    }
}
