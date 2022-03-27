package com.stupidzhang.domain.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author stupidzhang
 * @date 2022/3/23 15:00
 */
@RefreshScope
@Component
@Data
public class LinkMatchConfig {

    @Value("#{'${link.match.tb:}'.split(',')}")
    private String tbLinkMatchs;

    @Value("#{'${link.match.jd:}'.split(',')}")
    private String jdLinkMatchs;
}
