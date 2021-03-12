package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 会员设置表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@TableName("membership_settings")
public class MembershipSettings extends Model<MembershipSettings> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 会员id
     */
    private Integer memberId;
    /**
     * 同城内可查看 1：是2：否
     */
    private Integer sameCityWithinState;
    /**
     * 同城外可查看 1：是2：否
     */
    private Integer sameCityExternalState;
    /**
     * 信息保密开关 1：是2：否
     */
    private Integer confidentialityOfInformationState;
    /**
     * 好友消息提醒开关 1：是2：否
     */
    private Integer friendMessageState;
    /**
     * 系统消息/公告提醒开关 1：是2：否
     */
    private Integer noticeState;
    /**
     * 我的动态回复提醒开关 1：是2：否
     */
    private Integer dynamicResponseState;
    /**
     * 编辑时间
     */
    private Date editState;


    public Integer getId() {
        return id;
    }

    public MembershipSettings setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public MembershipSettings setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public Integer getSameCityWithinState() {
        return sameCityWithinState;
    }

    public MembershipSettings setSameCityWithinState(Integer sameCityWithinState) {
        this.sameCityWithinState = sameCityWithinState;
        return this;
    }

    public Integer getSameCityExternalState() {
        return sameCityExternalState;
    }

    public MembershipSettings setSameCityExternalState(Integer sameCityExternalState) {
        this.sameCityExternalState = sameCityExternalState;
        return this;
    }

    public Integer getConfidentialityOfInformationState() {
        return confidentialityOfInformationState;
    }

    public MembershipSettings setConfidentialityOfInformationState(Integer confidentialityOfInformationState) {
        this.confidentialityOfInformationState = confidentialityOfInformationState;
        return this;
    }

    public Integer getFriendMessageState() {
        return friendMessageState;
    }

    public MembershipSettings setFriendMessageState(Integer friendMessageState) {
        this.friendMessageState = friendMessageState;
        return this;
    }

    public Integer getNoticeState() {
        return noticeState;
    }

    public MembershipSettings setNoticeState(Integer noticeState) {
        this.noticeState = noticeState;
        return this;
    }

    public Integer getDynamicResponseState() {
        return dynamicResponseState;
    }

    public MembershipSettings setDynamicResponseState(Integer dynamicResponseState) {
        this.dynamicResponseState = dynamicResponseState;
        return this;
    }

    public Date getEditState() {
        return editState;
    }

    public MembershipSettings setEditState(Date editState) {
        this.editState = editState;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MembershipSettings{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", sameCityWithinState=" + sameCityWithinState +
        ", sameCityExternalState=" + sameCityExternalState +
        ", confidentialityOfInformationState=" + confidentialityOfInformationState +
        ", friendMessageState=" + friendMessageState +
        ", noticeState=" + noticeState +
        ", dynamicResponseState=" + dynamicResponseState +
        ", editState=" + editState +
        "}";
    }
}
