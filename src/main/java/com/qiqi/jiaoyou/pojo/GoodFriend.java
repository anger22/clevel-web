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
 * 好友列表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@TableName("good_friend")
public class GoodFriend extends Model<GoodFriend> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 会员id
     */
    private Integer oneselfId;
    /**
     * 好友id
     */
    private Integer memberId;
    /**
     * 好友头像
     */
    private String memberHead;
    /**
     * 好友昵称
     */
    private String memberNickName;
    /**
     * 好友备注
     */
    private String remarks;
    /**
     * 成为好友时间
     */
    private Date addTime;


    public Integer getId() {
        return id;
    }

    public GoodFriend setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOneselfId() {
        return oneselfId;
    }

    public GoodFriend setOneselfId(Integer oneselfId) {
        this.oneselfId = oneselfId;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public GoodFriend setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getMemberHead() {
        return memberHead;
    }

    public GoodFriend setMemberHead(String memberHead) {
        this.memberHead = memberHead;
        return this;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public GoodFriend setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public GoodFriend setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public GoodFriend setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "GoodFriend{" +
        "id=" + id +
        ", oneselfId=" + oneselfId +
        ", memberId=" + memberId +
        ", memberHead=" + memberHead +
        ", memberNickName=" + memberNickName +
        ", remarks=" + remarks +
        ", addTime=" + addTime +
        "}";
    }
}
