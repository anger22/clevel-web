package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * (AdvanceOrder)表实体类
 *
 * @author makejava
 * @since 2021-01-08 02:43:49
 */
@TableName("advance_order")
public class AdvanceOrder extends Model<AdvanceOrder> {

    private Integer id;
    //到店时间
    @TableField("to_shop_time")
    private Date toShopTime;
    //商品id
    @TableField("shop_id")
    private Integer shopId;
    //商品图片
    @TableField("shop_url")
    private String shopUrl;
    //商品名称
    @TableField("shop_name")
    private String shopName;
    //称呼
    @TableField(exist = false)
    private String call;
    //入住天数
    @TableField("check_in")
    private Integer checkIn;
    //状态
    private String status;
    //用户id
    @TableField("user_id")
    private Integer userId;

    @TableField("create_time")
    private Date createTime;
    //店铺名称
    @TableField("business_name")
    private String businessName;
    //店铺lo
    @TableField("business_icon")
    private String businessIcon;
    //商品简介
    @TableField("shop_introduce")
    private String shopIntroduce;
    //简介图片的宽高比（宽/高）默认两位小数
    private String width;

    private Integer isDealWith;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @TableField(exist = false)
    private String phone;

    @TableField(exist = false)
    private String nickName;

    /*性别 1：男2：女*/
    @TableField(exist = false)
    private Integer sex;

    @Override
    public String toString() {
        return "AdvanceOrder{" +
                "id=" + id +
                ", toShopTime=" + toShopTime +
                ", shopId=" + shopId +
                ", shopUrl='" + shopUrl + '\'' +
                ", shopName='" + shopName + '\'' +
                ", call='" + call + '\'' +
                ", checkIn=" + checkIn +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", businessName='" + businessName + '\'' +
                ", businessIcon='" + businessIcon + '\'' +
                ", shopIntroduce='" + shopIntroduce + '\'' +
                ", width='" + width + '\'' +
                ", isDealWith=" + isDealWith +
                ", phone='" + phone + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                '}';
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getIsDealWith() {
        return isDealWith;
    }

    public void setIsDealWith(Integer isDealWith) {
        this.isDealWith = isDealWith;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getToShopTime() {
        return toShopTime;
    }

    public void setToShopTime(Date toShopTime) {
        this.toShopTime = toShopTime;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public Integer getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Integer checkIn) {
        this.checkIn = checkIn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessIcon() {
        return businessIcon;
    }

    public void setBusinessIcon(String businessIcon) {
        this.businessIcon = businessIcon;
    }

    public String getShopIntroduce() {
        return shopIntroduce;
    }

    public void setShopIntroduce(String shopIntroduce) {
        this.shopIntroduce = shopIntroduce;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
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