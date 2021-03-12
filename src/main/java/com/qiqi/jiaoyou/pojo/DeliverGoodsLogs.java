package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 发货记录表(DeliverGoodsLogs)表实体类
 *
 * @author nan
 * @since 2020-12-08 13:59:38
 */
@TableName("deliver_goods_logs")
public class DeliverGoodsLogs extends Model<DeliverGoodsLogs> {
private static final long serialVersionUID = 1L;
	 @TableId(value = "id", type = IdType.AUTO)

    private Integer id;
    //发货人id值
    @TableField("send_user_id")
    private Integer sendUserId;
    //订单id
    @TableField("order_id")
    private Integer orderId;
    //收件人姓名
    @TableField("receive_user_name")
    private String receiveUserName;
    //收件人手机号
    @TableField("receive_user_phone")
    private String receiveUserPhone;
    //收件人地址
    @TableField("receive_user_location")
    private String receiveUserLocation;
    //寄件人姓名
    @TableField("send_user_name")
    private String sendUserName;
    //寄件人手机号
    @TableField("send_user_phone")
    private String sendUserPhone;
    //寄件人地址
    @TableField("send_user_location")
    private String sendUserLocation;
    //快递类型 圆通顺丰。。。。。。
    @TableField("express_type")
    private String expressType;
    //快递重量
    @TableField("express_weight")
    private String expressWeight;
    //物品名称
    @TableField("goods_name")
    private String goodsName;
    //支付类型
    @TableField("pay_type")
    private String payType;
    //备注
    @TableField("remark")
    private String remark;
    //创建时间
    @TableField("create_time")
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }

    public String getReceiveUserPhone() {
        return receiveUserPhone;
    }

    public void setReceiveUserPhone(String receiveUserPhone) {
        this.receiveUserPhone = receiveUserPhone;
    }

    public String getReceiveUserLocation() {
        return receiveUserLocation;
    }

    public void setReceiveUserLocation(String receiveUserLocation) {
        this.receiveUserLocation = receiveUserLocation;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getSendUserPhone() {
        return sendUserPhone;
    }

    public void setSendUserPhone(String sendUserPhone) {
        this.sendUserPhone = sendUserPhone;
    }

    public String getSendUserLocation() {
        return sendUserLocation;
    }

    public void setSendUserLocation(String sendUserLocation) {
        this.sendUserLocation = sendUserLocation;
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    public String getExpressWeight() {
        return expressWeight;
    }

    public void setExpressWeight(String expressWeight) {
        this.expressWeight = expressWeight;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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