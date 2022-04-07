package com.stupidzhang.domain.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 转换前得内容
 * @author stupidzhang
 * @date 2022/3/12 13:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvertReq {

    /**
     * 原始内容（淘口令/链接/关键词）
     */
    private String originContent;

}
