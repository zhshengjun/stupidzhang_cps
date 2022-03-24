package com.stupidzhang.domain.convert.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author stupidzhang
 * @date 2022/3/12 13:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvertResult {

    /**
     * 转换后得内容
     */
    private String convertContent;
}
