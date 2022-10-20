/**
 * @(#)CommonResult.java, 5月 20, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.market.sever.config;

import com.market.sever.constant.CommonCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author u7382548
 */
@Getter
@Setter
public class CommonResult {
    private String token;
    private String message;
    private int code;
    private Object data;

    public static CommonResult success(){
        CommonResult CommonResult =new CommonResult();
        CommonResult.setCode(CommonCode.SUCCESS.getCode());
        CommonResult.setMessage(CommonCode.SUCCESS.getMessage());
        return CommonResult;
    }

    public static CommonResult innerError(){
        CommonResult CommonResult =new CommonResult();
        CommonResult.setCode(CommonCode.INNER_ERROR.getCode());
        CommonResult.setMessage(CommonCode.INNER_ERROR.getMessage());
        return CommonResult;
    }

    public static CommonResult outError() {

        CommonResult CommonResult = new CommonResult();
        CommonResult.setCode(CommonCode.OUTTER_ERROR.getCode());
        CommonResult.setMessage(CommonCode.OUTTER_ERROR.getMessage());
        return CommonResult;
    }

    public static CommonResult successWithData(Object data){

        CommonResult CommonResult =new CommonResult();
        CommonResult.setCode(CommonCode.SUCCESS.getCode());
        CommonResult.setMessage(CommonCode.SUCCESS.getMessage());
        CommonResult.setData(data);
        return CommonResult;
    }

    public static CommonResult objectNotExist(){

        CommonResult CommonResult =new CommonResult();
        CommonResult.setCode(CommonCode.NO_OBJECT.getCode());
        CommonResult.setMessage(CommonCode.NO_OBJECT.getMessage());
        CommonResult.setData(null);
        return CommonResult;
    }



    public static CommonResult result(int code,String message,Object data){

        CommonResult CommonResult =new CommonResult();
        CommonResult.setCode(code);
        CommonResult.setMessage(message);
        CommonResult.setData(data);
        return CommonResult;
    }

    public static CommonResult tokenError(){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(CommonCode.TOKEN_FAIL.getCode());
        commonResult.setMessage(CommonCode.TOKEN_FAIL.getMessage());
        commonResult.setData(null);
        return commonResult;
    }
}