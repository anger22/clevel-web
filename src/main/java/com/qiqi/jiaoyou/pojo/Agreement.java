package com.qiqi.jiaoyou.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 协议表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Agreement extends Model<Agreement> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "untitled", type = IdType.AUTO)
    private Integer untitled;
    /**
     * 关于我们
     */
    private String aboutUS;
    /**
     * 注册协议
     */
    private String registrationAgreement;
    /**
     * 会员说明
     */
    private String memberDescription;
    /**
     * 分享规则
     */
    private String sharingRules;
    /**
     * 绿卡介绍
     */
    private String greenCard;
    /**
     * 编辑时间
     */
    private Date editTime;

    /**
     * 编辑时间
     */
    private String privacy;

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public Integer getUntitled() {
        return untitled;
    }

    public Agreement setUntitled(Integer untitled) {
        this.untitled = untitled;
        return this;
    }

    public String getAboutUS() {
        return aboutUS;
    }

    public Agreement setAboutUS(String aboutUS) {
        this.aboutUS = aboutUS;
        return this;
    }

    public String getRegistrationAgreement() {
        return registrationAgreement;
    }

    public Agreement setRegistrationAgreement(String registrationAgreement) {
        this.registrationAgreement = registrationAgreement;
        return this;
    }

    public String getMemberDescription() {
        return memberDescription;
    }

    public Agreement setMemberDescription(String memberDescription) {
        this.memberDescription = memberDescription;
        return this;
    }

    public String getSharingRules() {
        return sharingRules;
    }

    public Agreement setSharingRules(String sharingRules) {
        this.sharingRules = sharingRules;
        return this;
    }

    public String getGreenCard() {
        return greenCard;
    }

    public Agreement setGreenCard(String greenCard) {
        this.greenCard = greenCard;
        return this;
    }

    public Date getEditTime() {
        return editTime;
    }

    public Agreement setEditTime(Date editTime) {
        this.editTime = editTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.untitled;
    }

    @Override
    public String toString() {
        return "Agreement{" +
        "untitled=" + untitled +
        ", aboutUS=" + aboutUS +
        ", registrationAgreement=" + registrationAgreement +
        ", memberDescription=" + memberDescription +
        ", sharingRules=" + sharingRules +
        ", greenCard=" + greenCard +
        ", editTime=" + editTime +
        "}";
    }
}
