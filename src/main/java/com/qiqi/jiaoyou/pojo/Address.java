package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 地址管理表(Address)表实体类
 *
 * @author nan
 * @since 2020-12-03 16:59:06
 */
@TableName("address")
public class Address extends Model<Address> {
private static final long serialVersionUID = 1L;
	 @TableId(value = "address_id", type = IdType.AUTO)
    private Integer addressId;
    //收货人姓名
    @TableField("consignee_name")
    private String consigneeName;
    //收货人地址
    @TableField("consignee_address")
    private String consigneeAddress;
    //收货人联系方式
    @TableField("consignee_phone")
    private String consigneePhone;
    //收货地址状态0默认;1不默认
    @TableField("status")
    private String status;
    //用户id
    @TableField("address_user_id")
    private Integer addressUserId;
    //省
    @TableField("province")
    private String province;
    //市
    @TableField("city")
    private String city;
    //区
    @TableField("district")
    private String district;


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAddressUserId() {
        return addressUserId;
    }

    public void setAddressUserId(Integer addressUserId) {
        this.addressUserId = addressUserId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.addressId;
    }
}