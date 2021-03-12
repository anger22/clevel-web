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
@TableName("new_friend")
public class NewFriend extends Model<NewFriend> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "new_friend_id", type = IdType.AUTO)
    private Integer newFriendId;
    /**
     * 自身ID
     */
    @TableField("new_friend_oneself_id")
    private Integer newFriendOneselfId;
    /**
     * 对方ID
     */
    @TableField("new_friend_other_party_id")
    private Integer newFriendOtherPartyId;
    /**
     * 对方头像
     */
    @TableField("new_friend_other_party_head")
    private String newFriendOtherPartyHead;
    /**
     * 对方头像车标
     */
    @TableField("new_friend_other_party_auto_logos")
    private String newFriendOtherPartyAutoLogos;
    /**
     * 对方昵称
     */
    @TableField("new_friend_other_party_nick_name")
    private String newFriendOtherPartyNickName;
    /**
     * 对方等级
     */
    @TableField("new_friend_other_party_level")
    private Integer newFriendOtherPartyLevel;
    /**
     * 对方性别 1:男 2：女
     */
    @TableField("new_friend_other_party_sex")
    private Integer newFriendOtherPartySex;
    /**
     * 对方年龄
     */
    @TableField("new_friend_other_party_age")
    private Integer newFriendOtherPartyAge;
    /**
     * 对方城市
     */
    @TableField("new_friend_other_party_city")
    private String newFriendOtherPartyCity;
    /**
     * 打招呼时间
     */
    @TableField("new_friend_other_party_add_time")
    private Date newFriendOtherPartyAddTime;
    /**
     * 过期时间
     */
    @TableField("new_friend_other_party_end_time")
    private Date newFriendOtherPartyEndTime;
    /**
     * 礼物ID
     */
    @TableField("new_friend_other_party_gift_id")
    private Integer newFriendOtherPartyGiftId;
    /**
     * 礼物图片
     */
    @TableField("new_friend_other_party_gift_image")
    private String newFriendOtherPartyGiftImage;
    /**
     * 礼物名称
     */
    @TableField("new_friend_other_party_gift_name")
    private String newFriendOtherPartyGiftName;
    /**
     * 礼物数量
     */
    @TableField("new_friend_other_party_gift_size")
    private Integer newFriendOtherPartyGiftSize;


    public Integer getNewFriendId() {
        return newFriendId;
    }

    public NewFriend setNewFriendId(Integer newFriendId) {
        this.newFriendId = newFriendId;
        return this;
    }

    public Integer getNewFriendOneselfId() {
        return newFriendOneselfId;
    }

    public NewFriend setNewFriendOneselfId(Integer newFriendOneselfId) {
        this.newFriendOneselfId = newFriendOneselfId;
        return this;
    }

    public Integer getNewFriendOtherPartyId() {
        return newFriendOtherPartyId;
    }

    public NewFriend setNewFriendOtherPartyId(Integer newFriendOtherPartyId) {
        this.newFriendOtherPartyId = newFriendOtherPartyId;
        return this;
    }

    public String getNewFriendOtherPartyHead() {
        return newFriendOtherPartyHead;
    }

    public NewFriend setNewFriendOtherPartyHead(String newFriendOtherPartyHead) {
        this.newFriendOtherPartyHead = newFriendOtherPartyHead;
        return this;
    }

    public String getNewFriendOtherPartyAutoLogos() {
        return newFriendOtherPartyAutoLogos;
    }

    public NewFriend setNewFriendOtherPartyAutoLogos(String newFriendOtherPartyAutoLogos) {
        this.newFriendOtherPartyAutoLogos = newFriendOtherPartyAutoLogos;
        return this;
    }

    public String getNewFriendOtherPartyNickName() {
        return newFriendOtherPartyNickName;
    }

    public NewFriend setNewFriendOtherPartyNickName(String newFriendOtherPartyNickName) {
        this.newFriendOtherPartyNickName = newFriendOtherPartyNickName;
        return this;
    }

    public Integer getNewFriendOtherPartyLevel() {
        return newFriendOtherPartyLevel;
    }

    public NewFriend setNewFriendOtherPartyLevel(Integer newFriendOtherPartyLevel) {
        this.newFriendOtherPartyLevel = newFriendOtherPartyLevel;
        return this;
    }

    public Integer getNewFriendOtherPartySex() {
        return newFriendOtherPartySex;
    }

    public NewFriend setNewFriendOtherPartySex(Integer newFriendOtherPartySex) {
        this.newFriendOtherPartySex = newFriendOtherPartySex;
        return this;
    }

    public Integer getNewFriendOtherPartyAge() {
        return newFriendOtherPartyAge;
    }

    public NewFriend setNewFriendOtherPartyAge(Integer newFriendOtherPartyAge) {
        this.newFriendOtherPartyAge = newFriendOtherPartyAge;
        return this;
    }

    public String getNewFriendOtherPartyCity() {
        return newFriendOtherPartyCity;
    }

    public NewFriend setNewFriendOtherPartyCity(String newFriendOtherPartyCity) {
        this.newFriendOtherPartyCity = newFriendOtherPartyCity;
        return this;
    }

    public Date getNewFriendOtherPartyAddTime() {
        return newFriendOtherPartyAddTime;
    }

    public NewFriend setNewFriendOtherPartyAddTime(Date newFriendOtherPartyAddTime) {
        this.newFriendOtherPartyAddTime = newFriendOtherPartyAddTime;
        return this;
    }

    public Date getNewFriendOtherPartyEndTime() {
        return newFriendOtherPartyEndTime;
    }

    public NewFriend setNewFriendOtherPartyEndTime(Date newFriendOtherPartyEndTime) {
        this.newFriendOtherPartyEndTime = newFriendOtherPartyEndTime;
        return this;
    }

    public Integer getNewFriendOtherPartyGiftId() {
        return newFriendOtherPartyGiftId;
    }

    public NewFriend setNewFriendOtherPartyGiftId(Integer newFriendOtherPartyGiftId) {
        this.newFriendOtherPartyGiftId = newFriendOtherPartyGiftId;
        return this;
    }

    public String getNewFriendOtherPartyGiftImage() {
        return newFriendOtherPartyGiftImage;
    }

    public NewFriend setNewFriendOtherPartyGiftImage(String newFriendOtherPartyGiftImage) {
        this.newFriendOtherPartyGiftImage = newFriendOtherPartyGiftImage;
        return this;
    }

    public String getNewFriendOtherPartyGiftName() {
        return newFriendOtherPartyGiftName;
    }

    public NewFriend setNewFriendOtherPartyGiftName(String newFriendOtherPartyGiftName) {
        this.newFriendOtherPartyGiftName = newFriendOtherPartyGiftName;
        return this;
    }

    public Integer getNewFriendOtherPartyGiftSize() {
        return newFriendOtherPartyGiftSize;
    }

    public NewFriend setNewFriendOtherPartyGiftSize(Integer newFriendOtherPartyGiftSize) {
        this.newFriendOtherPartyGiftSize = newFriendOtherPartyGiftSize;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.newFriendId;
    }

    @Override
    public String toString() {
        return "NewFriend{" +
        "newFriendId=" + newFriendId +
        ", newFriendOneselfId=" + newFriendOneselfId +
        ", newFriendOtherPartyId=" + newFriendOtherPartyId +
        ", newFriendOtherPartyHead=" + newFriendOtherPartyHead +
        ", newFriendOtherPartyAutoLogos=" + newFriendOtherPartyAutoLogos +
        ", newFriendOtherPartyNickName=" + newFriendOtherPartyNickName +
        ", newFriendOtherPartyLevel=" + newFriendOtherPartyLevel +
        ", newFriendOtherPartySex=" + newFriendOtherPartySex +
        ", newFriendOtherPartyAge=" + newFriendOtherPartyAge +
        ", newFriendOtherPartyCity=" + newFriendOtherPartyCity +
        ", newFriendOtherPartyAddTime=" + newFriendOtherPartyAddTime +
        ", newFriendOtherPartyEndTime=" + newFriendOtherPartyEndTime +
        ", newFriendOtherPartyGiftId=" + newFriendOtherPartyGiftId +
        ", newFriendOtherPartyGiftImage=" + newFriendOtherPartyGiftImage +
        ", newFriendOtherPartyGiftName=" + newFriendOtherPartyGiftName +
        ", newFriendOtherPartyGiftSize=" + newFriendOtherPartyGiftSize +
        "}";
    }
}
