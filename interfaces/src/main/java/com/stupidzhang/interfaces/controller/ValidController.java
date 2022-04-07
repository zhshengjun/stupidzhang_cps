package com.stupidzhang.interfaces.controller;

import com.stupidzhang.application.CpsValidService;
import com.stupidzhang.common.Result;
import com.stupidzhang.domain.model.req.ValidReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author stupidzhang
 * @date 2022/3/12 16:24
 */
@Api(tags = "C、失效")
@RestController
@RequestMapping("/cps/valid")
public class ValidController {

    @Autowired
    private CpsValidService cpsValidService;

    @ApiOperation(value = "校验")
    @GetMapping("")
    public Result<Boolean> valid(ValidReq validReq) {
        return Result.ok(cpsValidService.valid(validReq));
    }
}
