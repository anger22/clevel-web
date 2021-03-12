package com.qiqi.jiaoyou.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 车友圈动态
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@TableName("rider_dynamics")
public class RiderDynamics extends Model<RiderDynamics> {

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
    private List<DynamicCommentsOfCarUsers> dynamicCommentsOfCarUsers;

    @TableField(exist = false)
    private List<String> img;

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }

    public List<DynamicCommentsOfCarUsers> getDynamicCommentsOfCarUsers() {
        return dynamicCommentsOfCarUsers;
    }

    public void setDynamicCommentsOfCarUsers(List<DynamicCommentsOfCarUsers> dynamicCommentsOfCarUsers) {
        this.dynamicCommentsOfCarUsers = dynamicCommentsOfCarUsers;
    }

    public Integer getId() {
        return id;
    }

    public RiderDynamics setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMemerId() {
        return memerId;
    }

    public RiderDynamics setMemerId(Integer memerId) {
        this.memerId = memerId;
        return this;
    }

    public String getMemberHead() {
        return memberHead;
    }

    public RiderDynamics setMemberHead(String memberHead) {
        this.memberHead = memberHead;
        return this;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public RiderDynamics setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
        return this;
    }

    public Integer getMemberSex() {
        return memberSex;
    }

    public RiderDynamics setMemberSex(Integer memberSex) {
        this.memberSex = memberSex;
        return this;
    }

    public Integer getMemberAge() {
        return memberAge;
    }

    public RiderDynamics setMemberAge(Integer memberAge) {
        this.memberAge = memberAge;
        return this;
    }

    public String getCity() {
        return city;
    }

    public RiderDynamics setCity(String city) {
        this.city = city;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public RiderDynamics setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public String getContext() {
        return context;
    }

    public RiderDynamics setContext(String context) {
        this.context = context;
        return this;
    }

    public String getImages() {
        return images;
    }

    public RiderDynamics setImages(String images) {
        this.images = images;
        return this;
    }

    public String getVideo() {
        return video;
    }

    public RiderDynamics setVideo(String video) {
        this.video = video;
        return this;
    }

    public Integer getLikeSize() {
        return likeSize;
    }

    public RiderDynamics setLikeSize(Integer likeSize) {
        this.likeSize = likeSize;
        return this;
    }

    public Integer getCommentSize() {
        return commentSize;
    }

    public RiderDynamics setCommentSize(Integer commentSize) {
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

    public RiderDynamics setStrangersInTheSameCity(Integer strangersInTheSameCity) {
        this.strangersInTheSameCity = strangersInTheSameCity;
        return this;
    }

    public Integer getStrangersOutsideTheCity() {
        return strangersOutsideTheCity;
    }

    public RiderDynamics setStrangersOutsideTheCity(Integer strangersOutsideTheCity) {
        this.strangersOutsideTheCity = strangersOutsideTheCity;
        return this;
    }

    public Integer getCitySynchronization() {
        return citySynchronization;
    }

    public RiderDynamics setCitySynchronization(Integer citySynchronization) {
        this.citySynchronization = citySynchronization;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "RiderDynamics{" +
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
