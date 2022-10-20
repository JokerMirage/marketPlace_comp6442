package com.market.sever.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author u7382548
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommodityVO {
    @ApiModelProperty("commodityId")
    long commodityID;

    @ApiModelProperty("commodityName")
    String commodityName;

    @ApiModelProperty("price")
    double price;

    @ApiModelProperty("img_url")
    String img_url;

    @ApiModelProperty("description")
    String description;

    @ApiModelProperty("category")
    String category;

    @ApiModelProperty("brand")
    String brand;

    @ApiModelProperty("status")
    int status;

    @ApiModelProperty("belongID")
    long belongID;



}
