package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 俱乐部好友表(ClubBuddy)表实体类
 *
 * @author makejava
 * @since 2020-12-30 19:43:17
 */
@TableName("club_buddy")
public class ClubBuddy extends Model<ClubBuddy> {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(value = "diamonds_id", type = IdType.AUTO)
    private Integer buddyId;
    //自身id
    private Integer oneselfId;
    //会员id
    private Integer memberId;
    //0不是秘书1是秘书
    private String secretaryStatus;
    //俱乐部id
    private Integer clubId;
    //获取的金钻数量
    private Integer diamondnumber;
    //每日获取的金钻数量
    private Integer diamonddaynumber;
    //每周获取的金钻数量
    private Integer diamondweeknumber;
    //每月获取的金钻数量
    private Integer diamondmothnumber;
    //金钻得时间
    private Date diamondTime;
    //消息免打扰 0,开-打扰;1关-不打扰
    private String noDisturbing;
    //创建时间
    private Date createTime;


    public Integer getBuddyId() {
        return buddyId;
    }

    public void setBuddyId(Integer buddyId) {
        this.buddyId = buddyId;
    }

    public Integer getOneselfId() {
        return oneselfId;
    }

    public void setOneselfId(Integer oneselfId) {
        this.oneselfId = oneselfId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getSecretaryStatus() {
        return secretaryStatus;
    }

    public void setSecretaryStatus(String secretaryStatus) {
        this.secretaryStatus = secretaryStatus;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Integer getDiamondnumber() {
        return diamondnumber;
    }

    public void setDiamondnumber(Integer diamondnumber) {
        this.diamondnumber = diamondnumber;
    }

    public Integer getDiamonddaynumber() {
        return diamonddaynumber;
    }

    public void setDiamonddaynumber(Integer diamonddaynumber) {
        this.diamonddaynumber = diamonddaynumber;
    }

    public Integer getDiamondweeknumber() {
        return diamondweeknumber;
    }

    public void setDiamondweeknumber(Integer diamondweeknumber) {
        this.diamondweeknumber = diamondweeknumber;
    }

    public Integer getDiamondmothnumber() {
        return diamondmothnumber;
    }

    public void setDiamondmothnumber(Integer diamondmothnumber) {
        this.diamondmothnumber = diamondmothnumber;
    }

    public Date getDiamondTime() {
        return diamondTime;
    }

    public void setDiamondTime(Date diamondTime) {
        this.diamondTime = diamondTime;
    }

    public String getNoDisturbing() {
        return noDisturbing;
    }

    public void setNoDisturbing(String noDisturbing) {
        this.noDisturbing = noDisturbing;
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
        return this.buddyId;
    }
}