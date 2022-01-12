package com.stupidzhang.convert.service.impl;

import com.stupidzhang.convert.service.UrlConvertService;
import com.stupidzhang.convert.service.strategy.JdUrl4DingDanXia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JdUrlConvertServiceImpl implements UrlConvertService {

    @Autowired
    private JdUrl4DingDanXia jdUrl4DingDanXia;

    @Override
    public String convert(String content) {
        return jdUrl4DingDanXia.jdShortUrl(content);
    }

    @Override
    public Boolean support(String type) {
        return "jd".equals(type);
    }

}
