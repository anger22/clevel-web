package com.qiqi.jiaoyou.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * 车友动态评论表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@TableName("dynamic_comments_of_car_users")
public class DynamicCommentsOfCarUsers extends Model<DynamicCommentsOfCarUsers> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 动态id/评论id 主要看级别
     */
    private Integer dynamicIdOrCommentId;
    /**
     * 评论人
     */
    private Integer memberId;
    /**
     * 头像
     */
    private String memberHead;
    /**
     * 昵称
     */
    private String memberNickName;
    /**
     * 评论内容
     */
    private String context;
    /**
     * 评论时间
     */
    private Date addTime;
    /**
     * 评论级别 1：直接评论动态2：回复评论
     */
    private Integer level;

    @TableField(exist = false)
    private List<DynamicCommentsOfCarUsers> lowerList;


    public List<DynamicCommentsOfCarUsers> getLowerList() {
        return lowerList;
    }

    public void setLowerList(List<DynamicCommentsOfCarUsers> lowerList) {
        this.lowerList = lowerList;
    }

    public Integer getId() {
        return id;
    }

    public DynamicCommentsOfCarUsers setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getDynamicIdOrCommentId() {
        return dynamicIdOrCommentId;
    }

    public DynamicCommentsOfCarUsers setDynamicIdOrCommentId(Integer dynamicIdOrCommentId) {
        this.dynamicIdOrCommentId = dynamicIdOrCommentId;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public DynamicCommentsOfCarUsers setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getMemberHead() {
        return memberHead;
    }

    public DynamicCommentsOfCarUsers setMemberHead(String memberHead) {
        this.memberHead = memberHead;
        return this;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public DynamicCommentsOfCarUsers setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
        return this;
    }

    public String getContext() {
        return context;
    }

    public DynamicCommentsOfCarUsers setContext(String context) {
        this.context = context;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public DynamicCommentsOfCarUsers setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public DynamicCommentsOfCarUsers setLevel(Integer level) {
        this.level = level;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DynamicCommentsOfCarUsers{" +
        "id=" + id +
        ", dynamicIdOrCommentId=" + dynamicIdOrCommentId +
        ", memberId=" + memberId +
        ", memberHead=" + memberHead +
        ", memberNickName=" + memberNickName +
        ", context=" + context +
        ", addTime=" + addTime +
        ", level=" + level +
        "}";
    }
}
