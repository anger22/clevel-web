package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 银行卡管理(BankManage)表实体类
 *
 * @author makejava
 * @since 2020-12-04 18:38:32
 */
@TableName("bank_Manage")
public class BankManage extends Model<BankManage> {
	 @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    //银行卡开户行名字（如：中国银行）
    private String bankName;
    //银行卡图标
    private String bankIcon;
    //银行卡排序
    private String bankSort;
    //颜色值1
    private String bankColor1;
    //颜色值2
    private String bankColor2;
    //状态 0：正常 1：删除
    private String bankStatus;

    private Date createTime;

    @Override
    public String toString() {
        return "BankManage{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", bankIcon='" + bankIcon + '\'' +
                ", bankSort='" + bankSort + '\'' +
                ", bankColor1='" + bankColor1 + '\'' +
                ", bankColor2='" + bankColor2 + '\'' +
                ", bankStatus='" + bankStatus + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getBankIcon() {
        return bankIcon;
    }

    public void setBankIcon(String bankIcon) {
        this.bankIcon = bankIcon;
    }

    public String getBankSort() {
        return bankSort;
    }

    public void setBankSort(String bankSort) {
        this.bankSort = bankSort;
    }

    public String getBankColor1() {
        return bankColor1;
    }

    public void setBankColor1(String bankColor1) {
        this.bankColor1 = bankColor1;
    }

    public String getBankColor2() {
        return bankColor2;
    }

    public void setBankColor2(String bankColor2) {
        this.bankColor2 = bankColor2;
    }

    public String getBankStatus() {
        return bankStatus;
    }

    public void setBankStatus(String bankStatus) {
        this.bankStatus = bankStatus;
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

    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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