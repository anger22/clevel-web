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
@TableName("member_matching_log")
public class MemberMatchingLog extends Model<MemberMatchingLog> {

    private static final long serialVersionUID = 1L;


    @TableId(value = "member_matching_log_id", type = IdType.AUTO)
    private Integer memberMatchingLogId;


    @TableField("member_matching_log_member_id")
    private Integer memberMatchingLogMemberId;

    @TableField("member_matching_log_member_ids_soul")
    private String memberMatchingLogMemberIdsSoul;


    @TableField("member_matching_log_member_ids_car")
    private String memberMatchingLogMemberIdsCar;

    public Integer getMemberMatchingLogId() {
        return memberMatchingLogId;
    }

    public void setMemberMatchingLogId(Integer memberMatchingLogId) {
        this.memberMatchingLogId = memberMatchingLogId;
    }

    public Integer getMemberMatchingLogMemberId() {
        return memberMatchingLogMemberId;
    }

    public void setMemberMatchingLogMemberId(Integer memberMatchingLogMemberId) {
        this.memberMatchingLogMemberId = memberMatchingLogMemberId;
    }

    public String getMemberMatchingLogMemberIdsSoul() {
        return memberMatchingLogMemberIdsSoul;
    }

    public void setMemberMatchingLogMemberIdsSoul(String memberMatchingLogMemberIdsSoul) {
        this.memberMatchingLogMemberIdsSoul = memberMatchingLogMemberIdsSoul;
    }

    public String getMemberMatchingLogMemberIdsCar() {
        return memberMatchingLogMemberIdsCar;
    }

    public void setMemberMatchingLogMemberIdsCar(String memberMatchingLogMemberIdsCar) {
        this.memberMatchingLogMemberIdsCar = memberMatchingLogMemberIdsCar;
    }
}
