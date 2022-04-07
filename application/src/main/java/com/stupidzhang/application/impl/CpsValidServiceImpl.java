package com.stupidzhang.application.impl;

import com.stupidzhang.application.CpsValidService;
import com.stupidzhang.domain.factory.CpsServiceFactory;
import com.stupidzhang.domain.model.req.ValidReq;
import com.stupidzhang.domain.service.CpsService;
import org.springframework.stereotype.Service;

@Service
public class CpsValidServiceImpl implements CpsValidService {
    @Override
    public Boolean valid(ValidReq validReq) {
        CpsService valid = CpsServiceFactory.getService(validReq.getContent());
        return valid.valid(validReq.getContent());
    }
}
