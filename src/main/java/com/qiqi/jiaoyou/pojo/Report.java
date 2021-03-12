package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author slq
 * @since 2020-07-13
 */
@Data
@TableName("report")
public class Report extends Model<Report> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "report_id", type = IdType.AUTO)
    private Integer reportId;

    /**
     * 举报人ID
     */
    @TableField("report_informant_id")
    private Integer reportInformantId;

    /**
     * 举报人头像
     */
    @TableField("report_informant_head")
    private String reportInformantHead;

    /**
     * 举报人昵称
     */
    @TableField("report_informant_nick_name")
    private String reportInformantNickName;

    /**
     * 举报人电话
     */
    @TableField("report_informant_phone")
    private String reportInformantPhone;

    /**
     * 被举报人ID
     */
    @TableField("report_bei_informant_id")
    private Integer reportBeiInformantId;

    /**
     * 被举报人头像
     */
    @TableField("report_bei_informant_head")
    private String reportBeiInformantHead;

    /**
     * 被举报人昵称
     */
    @TableField("report_bei_informant_nick_name")
    private String reportBeiInformantNickName;

    /**
     * 被举报人电话
     */
    @TableField("report_bei_informant_phone")
    private String reportBeiInformantPhone;

    /**
     * 举报原因
     */
    @TableField("report_reason")
    private Integer reportReason;

    /**
     * 举报内容
     */
    @TableField("report_context")
    private String reportContext;

    /**
     * 举报时间
     */
    @TableField("report_add_time")
    private Date reportAddTime;

    /**
     * 审核状态 1：待审核  2：审核通过 3：审核未通过
     */
    @TableField("report_Examine_state")
    private Integer reportExamineState;

    /**
     * 审核原因
     */
    @TableField("report_Examone_reason")
    private String reportExamoneReason;


    /**
     * 举报原因str
     */
    @TableField(exist = false)
    private String str;


    @Override
    protected Serializable pkVal() {
        return this.reportId;
    }

}
