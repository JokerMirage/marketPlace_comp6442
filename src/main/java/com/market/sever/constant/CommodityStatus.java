package com.market.sever.constant;

import com.market.sever.entity.Commodity;

import java.util.Optional;
/**
 * @author u7382548
 */
public enum CommodityStatus {
    ON_SHELVES(0,"unpurchased"),
    PURCHASED(1,"Purchased, but not delivered."),
    DELIVERED(2,"On its way to its new owner."),
    REACHED(3,"Reached to its new owner's place but unchecked by the owner."),
    OWNED(4,"Checked by the new owner, and can be put on shelves.");

    private int statusCode;
    private String description;

    CommodityStatus(int statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;

    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Optional<CommodityStatus> findByCode(int value) {
        for (CommodityStatus item : CommodityStatus.values()) {
            if (item.statusCode == value) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }
}
