package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 俱乐部(Club)表实体类
 *
 * @author makejava
 * @since 2020-12-30 19:30:03
 */

@TableName("club")
public class Club extends Model<Club> {

        private static final long serialVersionUID = 1L;
        @TableId(value = "address_id", type = IdType.AUTO)
    private Integer clubId;
    //名称
    private String clubName;
    //图标
    private String clubIcon;
    //等级
    private Integer clubGrade;
    //简介
    private String clubIntroduction;
    //每日工资（银钻对的这个是银钻）
    private Integer wage;
    //每日发工资的时间
    private String wageTime;
    //公告
    private String clubNotice;
    //0潜力俱乐部;1阔绰俱乐部
    private String type;
    //创建人id
    private Integer memberid;
    //创建时间
    private Date createTime;
    //累计工资
    private Double totalWages;
    //隐私模式 0开;1关
    private String privacyMode;
    //可以设置几个俱乐部秘书
    private Integer secretaryNumber;
    //排序
    private Integer clubSort;


    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubIcon() {
        return clubIcon;
    }

    public void setClubIcon(String clubIcon) {
        this.clubIcon = clubIcon;
    }

    public Integer getClubGrade() {
        return clubGrade;
    }

    public void setClubGrade(Integer clubGrade) {
        this.clubGrade = clubGrade;
    }

    public String getClubIntroduction() {
        return clubIntroduction;
    }

    public void setClubIntroduction(String clubIntroduction) {
        this.clubIntroduction = clubIntroduction;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public String getWageTime() {
        return wageTime;
    }

    public void setWageTime(String wageTime) {
        this.wageTime = wageTime;
    }

    public String getClubNotice() {
        return clubNotice;
    }

    public void setClubNotice(String clubNotice) {
        this.clubNotice = clubNotice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getTotalWages() {
        return totalWages;
    }

    public void setTotalWages(Double totalWages) {
        this.totalWages = totalWages;
    }

    public String getPrivacyMode() {
        return privacyMode;
    }

    public void setPrivacyMode(String privacyMode) {
        this.privacyMode = privacyMode;
    }

    public Integer getSecretaryNumber() {
        return secretaryNumber;
    }

    public void setSecretaryNumber(Integer secretaryNumber) {
        this.secretaryNumber = secretaryNumber;
    }

    public Integer getClubSort() {
        return clubSort;
    }

    public void setClubSort(Integer clubSort) {
        this.clubSort = clubSort;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.clubId;
    }
}