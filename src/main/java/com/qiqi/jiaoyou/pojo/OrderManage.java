package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

/**
 * @author nan
 * Now Do It
 * 2020-12-09 10:38:54
 */
@TableName("order_manage")
public class OrderManage extends Model<OrderManage> {
    private static final long serialVersionUID = -14030602576682452L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * userId
     * 用户id（购买者）
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * orderNumber
     * 订单号码
     */
    @TableField("order_number")
    private String orderNumber;
    /**
     * orderStatus
     * 订单状态（1：待支付，2：待收货，3：已完成，4：已取消）
     */
    @TableField("order_status")
    private String orderStatus;
    /**
     * orderShopName
     * 商品名称
     */
    @TableField("order_shop_name")
    private String orderShopName;
    /**
     * orderShopId
     * 商品id
     */
    @TableField("order_shop_id")
    private Integer orderShopId;
    /**
     * orderPrice
     * 订单价格（单价）
     */
    @TableField("order_price")
    private Double orderPrice;
    /**
     * orderShopSpecs
     * 商品规格
     */
    @TableField("order_shop_specs")
    private String orderShopSpecs;
    /**
     * orderAddressId
     * 地址表id
     */
    @TableField("order_address_id")
    private Integer orderAddressId;
    /**
     * orderRealPrice
     * 实付金额
     */
    @TableField("order_real_price")
    private Double orderRealPrice;
    /**
     * orderShopNumber
     * 订单商品数量
     */
    @TableField("order_shop_number")
    private Integer orderShopNumber;
    /**
     * receverPeopleName
     * 收货人（名字）
     */
    @TableField("recever_people_name")
    private String receverPeopleName;
    /**
     * receverPhone
     * 收货人手机号
     */
    @TableField("recever_phone")
    private String receverPhone;
    /**
     * receverAddress
     * 收货人地址
     */
    @TableField("recever_address")
    private String receverAddress;
    /**
     * orderDelStatus
     * 删除状态（0：删除，1：正常）
     */
    @TableField("order_del_status")
    private String orderDelStatus;
    /**
     * createTime
     * 下单时间（创建时间）
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * updateTime
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * type
     * 服务类型 0：商品 1 服务
     */
    @TableField("type")
    private String type;
    /**
     * payType
     * 付款方式0微信;1支付宝
     */
    @TableField("pay_type")
    private String payType;
    /**
     * payStatus
     * 支付状态0待支付;1支付成功;2支付失败
     */
    @TableField("pay_status")
    private String payStatus;
    /**
     * expressNum
     * 快递单号
     */
    @TableField("express_num")
    private String expressNum;
    /**
     * expressCode
     * 快递公司编码
     */
    @TableField("express_code")
    private String expressCode;
    /**
     * expressName
     * 快递公司名称
     */
    @TableField("express_name")
    private String expressName;
    /**
     * expressFrom
     * 出发地城市，省-市-区
     */
    @TableField("express_from")
    private String expressFrom;
    /**
     * expressTo
     * 目的地城市，省-市-区
     */
    @TableField("express_to")
    private String expressTo;
    /**
     * buyerMessage
     * 买家留言
     */
    @TableField("buyer_message")
    private String buyerMessage;
    /**
     * businessName
     * 店铺名称
     */
    @TableField("business_name")
    private String businessName;
    /**
     * businessIcon
     * 店铺log
     */
    @TableField("business_icon")
    private String businessIcon;
    /**
     * shopImg
     * 商品图片
     */
    @TableField("shop_img")
    private String shopImg;
    /**
     * shopIntroduce
     * 商品简介
     */
    @TableField("shop_introduce")
    private String shopIntroduce;

    @Override
    public String toString() {
        return "OrderManage{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderShopName='" + orderShopName + '\'' +
                ", orderShopId=" + orderShopId +
                ", orderPrice=" + orderPrice +
                ", orderShopSpecs='" + orderShopSpecs + '\'' +
                ", orderAddressId=" + orderAddressId +
                ", orderRealPrice=" + orderRealPrice +
                ", orderShopNumber=" + orderShopNumber +
                ", receverPeopleName='" + receverPeopleName + '\'' +
                ", receverPhone='" + receverPhone + '\'' +
                ", receverAddress='" + receverAddress + '\'' +
                ", orderDelStatus='" + orderDelStatus + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", type='" + type + '\'' +
                ", payType='" + payType + '\'' +
                ", payStatus='" + payStatus + '\'' +
                ", expressNum='" + expressNum + '\'' +
                ", expressCode='" + expressCode + '\'' +
                ", expressName='" + expressName + '\'' +
                ", expressFrom='" + expressFrom + '\'' +
                ", expressTo='" + expressTo + '\'' +
                ", buyerMessage='" + buyerMessage + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessIcon='" + businessIcon + '\'' +
                ", shopImg='" + shopImg + '\'' +
                ", shopIntroduce='" + shopIntroduce + '\'' +
                ", width=" + width +
                ", isEvaluate='" + isEvaluate + '\'' +
                ", orderId='" + orderId + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", headImg='" + headImg + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * width
     * 简介图片的宽高比（宽/高）默认两位小数
     */
    @TableField("width")
    private Double width;
    /**
     * isEvaluate
     * 是否评价1是;0不是
     */
    @TableField("is_evaluate")
    private String isEvaluate;

    /*订单*/
    @TableField("order_id")
    private String orderId;

   /*用户昵称*/
    @TableField(exist = false)
    private String  userNickName;

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /*头像*/
    @TableField(exist = false)
    private String headImg;
    /*手机号*/
    @TableField(exist = false)
    private String userPhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderShopName() {
        return orderShopName;
    }

    public void setOrderShopName(String orderShopName) {
        this.orderShopName = orderShopName;
    }

    public Integer getOrderShopId() {
        return orderShopId;
    }

    public void setOrderShopId(Integer orderShopId) {
        this.orderShopId = orderShopId;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderShopSpecs() {
        return orderShopSpecs;
    }

    public void setOrderShopSpecs(String orderShopSpecs) {
        this.orderShopSpecs = orderShopSpecs;
    }

    public Integer getOrderAddressId() {
        return orderAddressId;
    }

    public void setOrderAddressId(Integer orderAddressId) {
        this.orderAddressId = orderAddressId;
    }

    public Double getOrderRealPrice() {
        return orderRealPrice;
    }

    public void setOrderRealPrice(Double orderRealPrice) {
        this.orderRealPrice = orderRealPrice;
    }

    public Integer getOrderShopNumber() {
        return orderShopNumber;
    }

    public void setOrderShopNumber(Integer orderShopNumber) {
        this.orderShopNumber = orderShopNumber;
    }

    public String getReceverPeopleName() {
        return receverPeopleName;
    }

    public void setReceverPeopleName(String receverPeopleName) {
        this.receverPeopleName = receverPeopleName;
    }

    public String getReceverPhone() {
        return receverPhone;
    }

    public void setReceverPhone(String receverPhone) {
        this.receverPhone = receverPhone;
    }

    public String getReceverAddress() {
        return receverAddress;
    }

    public void setReceverAddress(String receverAddress) {
        this.receverAddress = receverAddress;
    }

    public String getOrderDelStatus() {
        return orderDelStatus;
    }

    public void setOrderDelStatus(String orderDelStatus) {
        this.orderDelStatus = orderDelStatus;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getExpressNum() {
        return expressNum;
    }

    public void setExpressNum(String expressNum) {
        this.expressNum = expressNum;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressFrom() {
        return expressFrom;
    }

    public void setExpressFrom(String expressFrom) {
        this.expressFrom = expressFrom;
    }

    public String getExpressTo() {
        return expressTo;
    }

    public void setExpressTo(String expressTo) {
        this.expressTo = expressTo;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
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

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public String getShopIntroduce() {
        return shopIntroduce;
    }

    public void setShopIntroduce(String shopIntroduce) {
        this.shopIntroduce = shopIntroduce;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public String getIsEvaluate() {
        return isEvaluate;
    }

    public void setIsEvaluate(String isEvaluate) {
        this.isEvaluate = isEvaluate;
    }

}