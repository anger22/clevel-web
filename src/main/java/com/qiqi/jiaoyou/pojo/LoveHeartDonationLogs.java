package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * (LoveHeartDonationLogs)表实体类
 *
 * @author makejava
 * @since 2020-12-01 11:02:11
 */
@TableName("love_heart_donation_logs")
public class LoveHeartDonationLogs extends Model<LoveHeartDonationLogs> {

    private static final long serialVersionUID = 1L;
	 @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //捐赠用户id
   @TableField("user_id")
    private Integer userId;
    //捐赠项目id
   @TableField("donation_project_id")
    private Integer donationProjectId;
    //捐赠时间
   @TableField("donation_time")
    private Date donationTime;
    //捐赠金额
   @TableField("donation_money")
    private Double donationMoney;
    //备注
   @TableField("donation_remark")
    private String donationRemark;



   @TableField(exist = false)
   private  String nickName;
   @TableField(exist = false)
   private String head;

    @Override
    public String toString() {
        return "LoveHeartDonationLogs{" +
                "id=" + id +
                ", userId=" + userId +
                ", donationProjectId=" + donationProjectId +
                ", donationTime=" + donationTime +
                ", donationMoney=" + donationMoney +
                ", donationRemark='" + donationRemark + '\'' +
                ", nickName='" + nickName + '\'' +
                ", head='" + head + '\'' +
                '}';
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

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

    public Integer getDonationProjectId() {
        return donationProjectId;
    }

    public void setDonationProjectId(Integer donationProjectId) {
        this.donationProjectId = donationProjectId;
    }

    public Date getDonationTime() {
        return donationTime;
    }

    public void setDonationTime(Date donationTime) {
        this.donationTime = donationTime;
    }

    public Double getDonationMoney() {
        return donationMoney;
    }

    public void setDonationMoney(Double donationMoney) {
        this.donationMoney = donationMoney;
    }

    public String getDonationRemark() {
        return donationRemark;
    }

    public void setDonationRemark(String donationRemark) {
        this.donationRemark = donationRemark;
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