package com.stupidzhang.convert.controller;

import com.stupidzhang.common.model.Result;
import com.stupidzhang.convert.service.UrlConvertContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("convert")
public class ConvertController {

    @Autowired
    private UrlConvertContext urlConvertContext;

    @GetMapping(value = "")
    public Result<String> convert(@RequestParam(value = "source", required = false) String source,
                                  @RequestParam(value = "originUrl") String originUrl) {
        return Result.ok(urlConvertContext.convertUrl(source,originUrl));
    }
}
