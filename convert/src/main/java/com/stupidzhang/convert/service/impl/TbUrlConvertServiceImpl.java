package com.stupidzhang.convert.service.impl;

import com.stupidzhang.convert.service.UrlConvertService;
import com.stupidzhang.convert.service.strategy.TaoBaoUrl4DaTaoKe;
import com.stupidzhang.convert.service.strategy.TaoBaoUrl4DingDanXia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class TbUrlConvertServiceImpl implements UrlConvertService {

    @Value("${convert.dataSource:dtk}")
    private String dataSource;

    @Autowired
    private TaoBaoUrl4DingDanXia taoBaoUrl4DingDanXia;

    @Autowired
    private TaoBaoUrl4DaTaoKe taoBaoUrl4DaTaoKe;

    @Override
    public String convert(String content) {
        if ("ddx".equals(dataSource)) {
            return taoBaoUrl4DingDanXia.convert(content);
        }
        return taoBaoUrl4DaTaoKe.taoBaoTwdToTwd(content);

    }

    @Override
    public Boolean support(String type) {
        return "tb".equals(type);
    }

}
