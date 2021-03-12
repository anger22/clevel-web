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
 * 朋友圈动态
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@TableName("circle_of_friends")
public class CircleOfFriends extends Model<CircleOfFriends> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    private Integer memerId;
    /**
     * 用户头像
     */
    private String memberHead;
    /**
     * 昵称
     */
    private String memberNickName;
    /**
     * 性别 1:男2:女
     */
    private Integer memberSex;
    /**
     * 年龄
     */
    private Integer memberAge;
    /**
     * 所在市
     */
    private String city;
    /**
     * 发布时间
     */
    private Date addTime;
    /**
     * 动态内容
     */
    private String context;
    /**
     * 图片数组
     */
    private String images;
    /**
     * 视频
     */
    private String video;
    /**
     * 点赞量
     */
    private Integer likeSize;
    /**
     * 评论量
     */
    private Integer commentSize;
    /**
     * 转发量
     */
    private Integer state;
    /**
     * 是否允许同城陌生人查看  1：允许  2：不允许
     */
    private Integer strangersInTheSameCity;
    /**
     * 是否允许同城以外陌生人 1：允许  2：不允许
     */
    private Integer strangersOutsideTheCity;
    /**
     * 是否同步到HC大咖秀  1：同步  2：不同步
     */
    private Integer citySynchronization;

    @TableField(exist = false)
    private List<DynamicReviewOfFriendsCircle> dynamicReviewOfFriendsCircleList;

    @TableField(exist = false)
    private List<String> img;

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }

    public List<DynamicReviewOfFriendsCircle> getDynamicReviewOfFriendsCircleList() {
        return dynamicReviewOfFriendsCircleList;
    }

    public void setDynamicReviewOfFriendsCircleList(List<DynamicReviewOfFriendsCircle> dynamicReviewOfFriendsCircleList) {
        this.dynamicReviewOfFriendsCircleList = dynamicReviewOfFriendsCircleList;
    }

    public Integer getId() {
        return id;
    }

    public CircleOfFriends setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMemerId() {
        return memerId;
    }

    public CircleOfFriends setMemerId(Integer memerId) {
        this.memerId = memerId;
        return this;
    }

    public String getMemberHead() {
        return memberHead;
    }

    public CircleOfFriends setMemberHead(String memberHead) {
        this.memberHead = memberHead;
        return this;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public CircleOfFriends setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
        return this;
    }

    public Integer getMemberSex() {
        return memberSex;
    }

    public CircleOfFriends setMemberSex(Integer memberSex) {
        this.memberSex = memberSex;
        return this;
    }

    public Integer getMemberAge() {
        return memberAge;
    }

    public CircleOfFriends setMemberAge(Integer memberAge) {
        this.memberAge = memberAge;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CircleOfFriends setCity(String city) {
        this.city = city;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public CircleOfFriends setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public String getContext() {
        return context;
    }

    public CircleOfFriends setContext(String context) {
        this.context = context;
        return this;
    }

    public String getImages() {
        return images;
    }

    public CircleOfFriends setImages(String images) {
        this.images = images;
        return this;
    }

    public String getVideo() {
        return video;
    }

    public CircleOfFriends setVideo(String video) {
        this.video = video;
        return this;
    }

    public Integer getLikeSize() {
        return likeSize;
    }

    public CircleOfFriends setLikeSize(Integer likeSize) {
        this.likeSize = likeSize;
        return this;
    }

    public Integer getCommentSize() {
        return commentSize;
    }

    public CircleOfFriends setCommentSize(Integer commentSize) {
        this.commentSize = commentSize;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStrangersInTheSameCity() {
        return strangersInTheSameCity;
    }

    public CircleOfFriends setStrangersInTheSameCity(Integer strangersInTheSameCity) {
        this.strangersInTheSameCity = strangersInTheSameCity;
        return this;
    }

    public Integer getStrangersOutsideTheCity() {
        return strangersOutsideTheCity;
    }

    public CircleOfFriends setStrangersOutsideTheCity(Integer strangersOutsideTheCity) {
        this.strangersOutsideTheCity = strangersOutsideTheCity;
        return this;
    }

    public Integer getCitySynchronization() {
        return citySynchronization;
    }

    public CircleOfFriends setCitySynchronization(Integer citySynchronization) {
        this.citySynchronization = citySynchronization;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CircleOfFriends{" +
        "id=" + id +
        ", memerId=" + memerId +
        ", memberHead=" + memberHead +
        ", memberNickName=" + memberNickName +
        ", memberSex=" + memberSex +
        ", memberAge=" + memberAge +
        ", city=" + city +
        ", addTime=" + addTime +
        ", context=" + context +
        ", images=" + images +
        ", video=" + video +
        ", likeSize=" + likeSize +
        ", commentSize=" + commentSize +
        ", state=" + state +
        ", strangersInTheSameCity=" + strangersInTheSameCity +
        ", strangersOutsideTheCity=" + strangersOutsideTheCity +
        ", citySynchronization=" + citySynchronization +
        "}";
    }
}
