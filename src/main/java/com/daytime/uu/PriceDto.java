package com.daytime.uu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Description:
 * Author: Jiangchangpeng
 * Date: 2025/01/09/11:18
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceDto {
    @JsonProperty("Id")
    private int id;

    @JsonProperty("IsFavorite")
    private Object isFavorite;

    @JsonProperty("GameId")
    private int gameId;

    @JsonProperty("GameName")
    private String gameName;

    @JsonProperty("GameIcon")
    private String gameIcon;

    @JsonProperty("CommodityName")
    private String commodityName;

    @JsonProperty("CommodityHashName")
    private String commodityHashName;

    @JsonProperty("IconUrl")
    private String iconUrl;

    @JsonProperty("IconUrlLarge")
    private String iconUrlLarge;

    @JsonProperty("OnSaleCount")
    private int onSaleCount;

    @JsonProperty("OnLeaseCount")
    private int onLeaseCount;

    @JsonProperty("LeaseUnitPrice")
    private String leaseUnitPrice;

    @JsonProperty("LongLeaseUnitPrice")
    private String longLeaseUnitPrice;

    @JsonProperty("LeaseDeposit")
    private String leaseDeposit;

    @JsonProperty("Price")
    private String price;

    @JsonProperty("SteamPrice")
    private String steamPrice;

    @JsonProperty("SteamUSDPrice")
    private String steamUSDPrice;

    @JsonProperty("TypeName")
    private String typeName;

    @JsonProperty("Exterior")
    private String exterior;

    @JsonProperty("ExteriorColor")
    private String exteriorColor;

    @JsonProperty("Rarity")
    private String rarity;

    @JsonProperty("RarityColor")
    private String rarityColor;

    @JsonProperty("Quality")
    private String quality;

    @JsonProperty("QualityColor")
    private String qualityColor;

    @JsonProperty("SortId")
    private int sortId;

    @JsonProperty("HaveLease")
    private int haveLease;

    @JsonProperty("Rent")
    private String rent;

    @JsonProperty("StickersIsSort")
    private boolean stickersIsSort;

    @JsonProperty("SubsidyPurchase")
    private int subsidyPurchase;

    @JsonProperty("Stickers")
    private Object stickers;

    @JsonProperty("Label")
    private Object label;

    @JsonProperty("MinLeaseDeposit")
    private Object minLeaseDeposit;

    @JsonProperty("ListType")
    private Object listType;

    @JsonProperty("TemplatePurchaseCountText")
    private Object templatePurchaseCountText;

    @JsonProperty("TemplateTags")
    private Object templateTags;

}
