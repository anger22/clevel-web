package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆表(CarCopy)表实体类
 *
 * @author makejava
 * @since 2020-12-23 17:26:54
 */
@TableName("car_copy")
public class CarCopy extends Model<CarCopy> {
    //id
    private Integer id;
    //关联会员
    private Integer memberId;
    //行驶证照片
    @TableField("driving_license_photo")
    private String drivingLicensePhoto;
    //车辆照片
    private String images;


    //车标图片
    @TableField(exist = false)
    private String carLable;

    public String getCarLable() {
        return carLable;
    }

    public void setCarLable(String carLable) {
        this.carLable = carLable;
    }

    //车型
    private String vehicleType;

    private String model;
    //绑定时间
    private Date addTime;
    //权重
    private Integer weight;
    //删除状态 1:已删除2:未删除
    private Integer deledeState;
    //1:待審核  2：審核通過 3：審核未通過
    private Integer auditState;
    //审核原因
    private String reason;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getDrivingLicensePhoto() {
        return drivingLicensePhoto;
    }

    public void setDrivingLicensePhoto(String drivingLicensePhoto) {
        this.drivingLicensePhoto = drivingLicensePhoto;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getDeledeState() {
        return deledeState;
    }

    public void setDeledeState(Integer deledeState) {
        this.deledeState = deledeState;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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