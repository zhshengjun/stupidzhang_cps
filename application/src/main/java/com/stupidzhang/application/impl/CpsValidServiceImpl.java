package com.stupidzhang.application.impl;

import com.stupidzhang.application.CpsValidService;
import com.stupidzhang.domain.valid.model.req.ValidReq;
import com.stupidzhang.domain.valid.service.ValidService;
import com.stupidzhang.domain.valid.service.factory.ValidServiceFactory;
import org.springframework.stereotype.Service;

@Service
public class CpsValidServiceImpl implements CpsValidService {
    @Override
    public Boolean valid(ValidReq validReq) {
        ValidService valid = ValidServiceFactory.getValid(validReq);
        return valid.valid(validReq.getContent());
    }
}
