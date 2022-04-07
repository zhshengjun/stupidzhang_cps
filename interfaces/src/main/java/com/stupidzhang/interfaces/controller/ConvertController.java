package com.stupidzhang.interfaces.controller;

import com.stupidzhang.application.CpsConvertService;
import com.stupidzhang.common.Result;
import com.stupidzhang.domain.model.req.ConvertReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:24
 */
@Api(tags = "A、转换")
@RestController
@RequestMapping("/cps/convert")
public class ConvertController {

    @Autowired
    private CpsConvertService cpsConvertService;

    @ApiOperation(value = "转换")
    @GetMapping("")
    public Result<String> convert(@RequestParam("origin") String origin) {
        return Result.ok(cpsConvertService.convert(new ConvertReq(origin)));
    }
}
