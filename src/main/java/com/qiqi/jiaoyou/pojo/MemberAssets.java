package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 会员资产表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@TableName("member_assets")
public class MemberAssets extends Model<MemberAssets> {

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
     * 剩余黑钻石数
     */
    private Long memberDiamondsizeOfBlack;
    /**
     * 会员喇叭数
     */
    private Long memberhornSize;
    /**
     * 会员经验值
     */
    private Long meberExperienceSize;
    /**
     * 会员标签
     */
    private String memberLabel;
    private String ciphertext;
    /**
     * 剩余金钻数
     */
    private Long memberDiamondsizeOfGold;
    /**
     * 剩余银钻数
     */
    private Long memberDiamondsizeOfSilver;
    /**
     * 已提现黑钻数量
     */
    private Long oldMemberDiamondsizeOfBlack;
    /**
     * 累计银钻数
     */
    private Long oldMemberDiamondsizeOfSilver;


    public Integer getId() {
        return id;
    }

    public MemberAssets setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public MemberAssets setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public Long getMemberDiamondsizeOfBlack() {
        return memberDiamondsizeOfBlack;
    }

    public MemberAssets setMemberDiamondsizeOfBlack(Long memberDiamondsizeOfBlack) {
        this.memberDiamondsizeOfBlack = memberDiamondsizeOfBlack;
        return this;
    }

    public Long getMemberhornSize() {
        return memberhornSize;
    }

    public MemberAssets setMemberhornSize(Long memberhornSize) {
        this.memberhornSize = memberhornSize;
        return this;
    }

    public Long getMeberExperienceSize() {
        return meberExperienceSize;
    }

    public MemberAssets setMeberExperienceSize(Long meberExperienceSize) {
        this.meberExperienceSize = meberExperienceSize;
        return this;
    }

    public String getMemberLabel() {
        return memberLabel;
    }

    public MemberAssets setMemberLabel(String memberLabel) {
        this.memberLabel = memberLabel;
        return this;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    public MemberAssets setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
        return this;
    }

    public Long getMemberDiamondsizeOfGold() {
        return memberDiamondsizeOfGold;
    }

    public MemberAssets setMemberDiamondsizeOfGold(Long memberDiamondsizeOfGold) {
        this.memberDiamondsizeOfGold = memberDiamondsizeOfGold;
        return this;
    }

    public Long getMemberDiamondsizeOfSilver() {
        return memberDiamondsizeOfSilver;
    }

    public MemberAssets setMemberDiamondsizeOfSilver(Long memberDiamondsizeOfSilver) {
        this.memberDiamondsizeOfSilver = memberDiamondsizeOfSilver;
        return this;
    }

    public Long getOldMemberDiamondsizeOfBlack() {
        return oldMemberDiamondsizeOfBlack;
    }

    public MemberAssets setOldMemberDiamondsizeOfBlack(Long oldMemberDiamondsizeOfBlack) {
        this.oldMemberDiamondsizeOfBlack = oldMemberDiamondsizeOfBlack;
        return this;
    }

    public Long getOldMemberDiamondsizeOfSilver() {
        return oldMemberDiamondsizeOfSilver;
    }

    public MemberAssets setOldMemberDiamondsizeOfSilver(Long oldMemberDiamondsizeOfSilver) {
        this.oldMemberDiamondsizeOfSilver = oldMemberDiamondsizeOfSilver;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MemberAssets{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", memberDiamondsizeOfBlack=" + memberDiamondsizeOfBlack +
        ", memberhornSize=" + memberhornSize +
        ", meberExperienceSize=" + meberExperienceSize +
        ", memberLabel=" + memberLabel +
        ", ciphertext=" + ciphertext +
        ", memberDiamondsizeOfGold=" + memberDiamondsizeOfGold +
        ", memberDiamondsizeOfSilver=" + memberDiamondsizeOfSilver +
        ", oldMemberDiamondsizeOfBlack=" + oldMemberDiamondsizeOfBlack +
        ", oldMemberDiamondsizeOfSilver=" + oldMemberDiamondsizeOfSilver +
        "}";
    }
}
