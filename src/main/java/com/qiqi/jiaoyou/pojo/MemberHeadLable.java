package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@TableName("member_head_lable")
public class MemberHeadLable extends Model<MemberHeadLable> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "member_head_lable_id", type = IdType.AUTO)
    private Integer memberHeadLableId;
    @TableField("member_head_lable_name")
    private String memberHeadLableName;
    @TableField("member_head_lable_image")
    private String memberHeadLableImage;
    /**
     * 1：启用 2：禁用
     */
    @TableField("member_head_lable_enable_state")
    private String memberHeadLableEnableState;
    /**
     * 1:已删除 2：未删除
     */
    @TableField("member_head_lable_del_state")
    private String memberHeadLableDelState;
    @TableField("member_head_lable_add_time")
    private Date memberHeadLableAddTime;
    @TableField("member_head_lable_edit_time")
    private Date memberHeadLableEditTime;


    public Integer getMemberHeadLableId() {
        return memberHeadLableId;
    }

    public MemberHeadLable setMemberHeadLableId(Integer memberHeadLableId) {
        this.memberHeadLableId = memberHeadLableId;
        return this;
    }

    public String getMemberHeadLableName() {
        return memberHeadLableName;
    }

    public MemberHeadLable setMemberHeadLableName(String memberHeadLableName) {
        this.memberHeadLableName = memberHeadLableName;
        return this;
    }

    public String getMemberHeadLableImage() {
        return memberHeadLableImage;
    }

    public MemberHeadLable setMemberHeadLableImage(String memberHeadLableImage) {
        this.memberHeadLableImage = memberHeadLableImage;
        return this;
    }

    public String getMemberHeadLableEnableState() {
        return memberHeadLableEnableState;
    }

    public MemberHeadLable setMemberHeadLableEnableState(String memberHeadLableEnableState) {
        this.memberHeadLableEnableState = memberHeadLableEnableState;
        return this;
    }

    public String getMemberHeadLableDelState() {
        return memberHeadLableDelState;
    }

    public MemberHeadLable setMemberHeadLableDelState(String memberHeadLableDelState) {
        this.memberHeadLableDelState = memberHeadLableDelState;
        return this;
    }

    public Date getMemberHeadLableAddTime() {
        return memberHeadLableAddTime;
    }

    public MemberHeadLable setMemberHeadLableAddTime(Date memberHeadLableAddTime) {
        this.memberHeadLableAddTime = memberHeadLableAddTime;
        return this;
    }

    public Date getMemberHeadLableEditTime() {
        return memberHeadLableEditTime;
    }

    public MemberHeadLable setMemberHeadLableEditTime(Date memberHeadLableEditTime) {
        this.memberHeadLableEditTime = memberHeadLableEditTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.memberHeadLableId;
    }

    @Override
    public String toString() {
        return "MemberHeadLable{" +
        "memberHeadLableId=" + memberHeadLableId +
        ", memberHeadLableName=" + memberHeadLableName +
        ", memberHeadLableImage=" + memberHeadLableImage +
        ", memberHeadLableEnableState=" + memberHeadLableEnableState +
        ", memberHeadLableDelState=" + memberHeadLableDelState +
        ", memberHeadLableAddTime=" + memberHeadLableAddTime +
        ", memberHeadLableEditTime=" + memberHeadLableEditTime +
        "}";
    }
}
