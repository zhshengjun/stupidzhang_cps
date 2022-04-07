package com.stupidzhang.domain.model.req;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidReq {
    /**
     * 推广链接
     */
    private String content;
}
