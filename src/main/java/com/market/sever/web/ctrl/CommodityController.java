package com.market.sever.web.ctrl;

import com.market.sever.config.CommonResult;
import com.market.sever.entity.Commodity;
import com.market.sever.web.logic.spi.CommodityLogic;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
/**
 * @author u7382548
 */
@Slf4j
@RestController
@RequestMapping(value = "/market/api/commodity")
public class CommodityController {
    @Autowired
    public CommodityLogic commodityLogic;

    @ApiOperation("根据商品ID(commodity_id)查询商品")
    @GetMapping(value = "/id")
    public CommonResult getCommodityById(@RequestParam("commodity_id")long Id) {
        return commodityLogic.findCommodityByID(Id).isPresent()
                ?CommonResult.successWithData(commodityLogic.findCommodityByID(Id))
                : CommonResult.objectNotExist();
    }

    @ApiOperation("根据商品分类(categroty)获取商品表单")
    @GetMapping(value = "/category")
    public CommonResult getCommoditiesByCategory(@RequestParam("category")String category){
        return CommonResult.successWithData(commodityLogic.findCommodityByCategory(category));
    }

    @ApiOperation("根据商品品牌(brand)获取商品表单")
    @GetMapping(value = "/brand")
    public CommonResult getCommoditiesByBrand(@RequestParam("brand")String brand){
        return CommonResult.successWithData(commodityLogic.findCommodityByBrand(brand));
    }

    @ApiOperation("根据商品名字(name)获取商品表单")
    @GetMapping(value = "/name")
    public CommonResult getCommoditiesByName(@RequestParam("name")String name){
        return CommonResult.successWithData(commodityLogic.findCommodityByName(name));
    }

    @ApiOperation("根据用户id(belongUserID)获取名下所有商品")
    @GetMapping(value = "/belongID")
    public CommonResult getCommoditiesByBelongID(@RequestParam("belongID")long belongID){
        return CommonResult.successWithData(commodityLogic.findCommodityBybelongID(belongID));
    }

    @ApiOperation("创建新的商品")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name", value = "商品名字"),
//            @ApiImplicitParam(name = "price", value = "商品价格"),
//            @ApiImplicitParam(name = "img_url", value = "商品图片url"),
//            @ApiImplicitParam(name = "description", value = "商品描述"),
//            @ApiImplicitParam(name = "brand",value = "商品品牌"),
//            @ApiImplicitParam(name = "category", value = "商品分类"),
//            @ApiImplicitParam(name = "belongUserID",value = "商品卖家id"),
//    })
    @PostMapping(value = "/postCommodity")
    public CommonResult addNewCommodity(@RequestBody Commodity commodity){
        return CommonResult.successWithData(commodityLogic.findCommodityByID(commodityLogic.addNewCommodity(commodity.getName(),commodity.getPrice()
                ,commodity.getImg_url(),commodity.getDescription(),commodity.getBrand(),commodity.getCategory(),commodity.getBelongUserID())));
    }

    @ApiOperation("更新商品除商品ID外的任意信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name", value = "商品名字"),
//            @ApiImplicitParam(name = "price", value = "商品价格"),
//            @ApiImplicitParam(name = "img_url", value = "商品图片url"),
//            @ApiImplicitParam(name = "description", value = "商品描述"),
//            @ApiImplicitParam(name = "brand",value = "商品品牌"),
//            @ApiImplicitParam(name = "category", value = "商品分类"),
//            @ApiImplicitParam(name = "status",value = "商品状态码"),
//            @ApiImplicitParam(name = "belongUserID",value = "商品卖家id"),
//    })
    @PostMapping(value = "updateInfo")
    public CommonResult updateCommodityInfo(@RequestBody Commodity commodity){
        return commodityLogic.updateCommodityInfo(commodity.getCommodity_id(), commodity.getName(),commodity.getPrice(),
                commodity.getImg_url(), commodity.getDescription(),commodity.getCategory(),commodity.getBrand(),
                commodity.getStatus(),commodity.getBelongUserID());
    }
}
