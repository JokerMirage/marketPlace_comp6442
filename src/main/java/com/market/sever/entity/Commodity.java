package com.market.sever.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author u7382548
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {
    public long commodity_id;
    public String name;
    public double price;
    public String img_url;
    public String description;
    public String brand;
    public String category;
    public int status;
    public long belongUserID;
}
