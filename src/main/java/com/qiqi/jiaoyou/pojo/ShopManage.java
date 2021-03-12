package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品管理(ShopManage)表实体类
 *
 * @author makejava
 * @since 2020-12-02 17:19:49
 */
@TableName("shop_manage")
public class ShopManage extends Model<ShopManage> {
private static final long serialVersionUID = 1L;
	 @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //商品名称
    @TableField("shop_name")
    private String shopName;
    //商品单价
    @TableField("shop_price")
    private Double shopPrice;
    //商品规格
    @TableField("shop_specs")
    private String shopSpecs;
    //商品简介
    @TableField("shop_introduce")
    private String shopIntroduce;
    //商品图片
    @TableField("shop_img")
    private String shopImg;
    //商品状态(0：删除，1：正常)
    @TableField("shop_status")
    private String shopStatus;
    //是否置顶（0：未置顶，1：置顶）
    @TableField("shop_is_top")
    private String shopIsTop;

    @TableField("business_name")
    private String businessName;

    @Override
    public String toString() {
        return "ShopManage{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", shopPrice=" + shopPrice +
                ", shopSpecs='" + shopSpecs + '\'' +
                ", shopIntroduce='" + shopIntroduce + '\'' +
                ", shopImg='" + shopImg + '\'' +
                ", shopStatus='" + shopStatus + '\'' +
                ", shopIsTop='" + shopIsTop + '\'' +
                ", businessName='" + businessName + '\'' +
                ", width='" + width + '\'' +
                ", city='" + city + '\'' +
                ", businessIcon='" + businessIcon + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    /*简介图片的宽高比（宽/高）默认两位小数*/
   @TableField("width")
   private String width;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @TableField("city")
    private String city;

    public String getBusinessIcon() {
        return businessIcon;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setBusinessIcon(String businessIcon) {
        this.businessIcon = businessIcon;
    }

    @TableField("business_icon")
    private String businessIcon;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getShopSpecs() {
        return shopSpecs;
    }

    public void setShopSpecs(String shopSpecs) {
        this.shopSpecs = shopSpecs;
    }

    public String getShopIntroduce() {
        return shopIntroduce;
    }

    public void setShopIntroduce(String shopIntroduce) {
        this.shopIntroduce = shopIntroduce;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getShopIsTop() {
        return shopIsTop;
    }

    public void setShopIsTop(String shopIsTop) {
        this.shopIsTop = shopIsTop;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}