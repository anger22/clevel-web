package com.qiqi.jiaoyou.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 车辆表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Car extends Model<Car> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 关联会员
     */
    private Integer memberId;
    /**
     * 行驶证照片
     */
    @TableField("driving_license_photo")
    private String drivingLicensePhoto;
    /**
     * 车辆照片
     */
    private String images;
    /**
     * 车型
     */
    private String vehicleType;
    private String model;
    /**
     * 绑定时间
     */
    private Date addTime;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 删除状态 1:已删除2:未删除
     */
    private Integer deledeState;
    /**
     * 1:待審核  2：審核通過 3：審核未通過
     */
    private Integer auditState;
    /**
     * 审核原因
     */
    private String reason;

    @TableField(exist = false)
    private String carLable;

    public String getCarLable() {
        return carLable;
    }

    public void setCarLable(String carLable) {
        this.carLable = carLable;
    }

    public Integer getId() {
        return id;
    }

    public Car setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Car setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getDrivingLicensePhoto() {
        return drivingLicensePhoto;
    }

    public Car setDrivingLicensePhoto(String drivingLicensePhoto) {
        this.drivingLicensePhoto = drivingLicensePhoto;
        return this;
    }

    public String getImages() {
        return images;
    }

    public Car setImages(String images) {
        this.images = images;
        return this;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public Car setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Car setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public Car setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public Integer getDeledeState() {
        return deledeState;
    }

    public Car setDeledeState(Integer deledeState) {
        this.deledeState = deledeState;
        return this;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public Car setAuditState(Integer auditState) {
        this.auditState = auditState;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public Car setReason(String reason) {
        this.reason = reason;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Car{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", drivingLicensePhoto=" + drivingLicensePhoto +
        ", images=" + images +
        ", vehicleType=" + vehicleType +
        ", model=" + model +
        ", addTime=" + addTime +
        ", weight=" + weight +
        ", deledeState=" + deledeState +
        ", auditState=" + auditState +
        ", reason=" + reason +
        "}";
    }
}
