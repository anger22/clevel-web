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
@TableName("red_receive_log")
public class RedReceiveLog extends Model<RedReceiveLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 领取记录id
     */
    @TableId(value = "red_receive_log_id", type = IdType.AUTO)
    private Integer redReceiveLogId;
    /**
     * 领取人id
     */
    @TableField("red_receive_log_member_id")
    private Integer redReceiveLogMemberId;
    /**
     * 领取人昵称
     */
    @TableField("red_receive_log_member_nick_name")
    private String redReceiveLogMemberNickName;
    /**
     * 领取人头像
     */
    @TableField("red_receive_log_member_head")
    private String redReceiveLogMemberHead;
    /**
     * 红包ID
     */
    @TableField("red_receive_log_red_id")
    private Integer redReceiveLogRedId;
    /**
     * 领取钻石数
     */
    @TableField("red_receive_log_gold_size")
    private Integer redReceiveLogGoldSize;
    /**
     * 领取时间
     */
    @TableField("red_receive_log_time")
    private Date redReceiveLogTime;
    /**
     * 是否是手气最佳  1:是  2：不是
     */
    @TableField("red_receive_log_is_luck")
    private Integer redReceiveLogIsLuck;


    public Integer getRedReceiveLogId() {
        return redReceiveLogId;
    }

    public RedReceiveLog setRedReceiveLogId(Integer redReceiveLogId) {
        this.redReceiveLogId = redReceiveLogId;
        return this;
    }

    public Integer getRedReceiveLogMemberId() {
        return redReceiveLogMemberId;
    }

    public RedReceiveLog setRedReceiveLogMemberId(Integer redReceiveLogMemberId) {
        this.redReceiveLogMemberId = redReceiveLogMemberId;
        return this;
    }

    public String getRedReceiveLogMemberNickName() {
        return redReceiveLogMemberNickName;
    }

    public RedReceiveLog setRedReceiveLogMemberNickName(String redReceiveLogMemberNickName) {
        this.redReceiveLogMemberNickName = redReceiveLogMemberNickName;
        return this;
    }

    public String getRedReceiveLogMemberHead() {
        return redReceiveLogMemberHead;
    }

    public RedReceiveLog setRedReceiveLogMemberHead(String redReceiveLogMemberHead) {
        this.redReceiveLogMemberHead = redReceiveLogMemberHead;
        return this;
    }

    public Integer getRedReceiveLogRedId() {
        return redReceiveLogRedId;
    }

    public RedReceiveLog setRedReceiveLogRedId(Integer redReceiveLogRedId) {
        this.redReceiveLogRedId = redReceiveLogRedId;
        return this;
    }

    public Integer getRedReceiveLogGoldSize() {
        return redReceiveLogGoldSize;
    }

    public RedReceiveLog setRedReceiveLogGoldSize(Integer redReceiveLogGoldSize) {
        this.redReceiveLogGoldSize = redReceiveLogGoldSize;
        return this;
    }

    public Date getRedReceiveLogTime() {
        return redReceiveLogTime;
    }

    public RedReceiveLog setRedReceiveLogTime(Date redReceiveLogTime) {
        this.redReceiveLogTime = redReceiveLogTime;
        return this;
    }

    public Integer getRedReceiveLogIsLuck() {
        return redReceiveLogIsLuck;
    }

    public RedReceiveLog setRedReceiveLogIsLuck(Integer redReceiveLogIsLuck) {
        this.redReceiveLogIsLuck = redReceiveLogIsLuck;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.redReceiveLogId;
    }

    @Override
    public String toString() {
        return "RedReceiveLog{" +
        "redReceiveLogId=" + redReceiveLogId +
        ", redReceiveLogMemberId=" + redReceiveLogMemberId +
        ", redReceiveLogMemberNickName=" + redReceiveLogMemberNickName +
        ", redReceiveLogMemberHead=" + redReceiveLogMemberHead +
        ", redReceiveLogRedId=" + redReceiveLogRedId +
        ", redReceiveLogGoldSize=" + redReceiveLogGoldSize +
        ", redReceiveLogTime=" + redReceiveLogTime +
        ", redReceiveLogIsLuck=" + redReceiveLogIsLuck +
        "}";
    }
}
