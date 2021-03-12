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
@TableName("report_type")
public class ReportType extends Model<ReportType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "report_type_id", type = IdType.AUTO)
    private Integer reportTypeId;
    @TableField("report_type_name")
    private String reportTypeName;
    @TableField("report_type_create_time")
    private Date reportTypeCreateTime;
    @TableField("report_type_edit_time")
    private Date reportTypeEditTime;


    public Integer getReportTypeId() {
        return reportTypeId;
    }

    public ReportType setReportTypeId(Integer reportTypeId) {
        this.reportTypeId = reportTypeId;
        return this;
    }

    public String getReportTypeName() {
        return reportTypeName;
    }

    public ReportType setReportTypeName(String reportTypeName) {
        this.reportTypeName = reportTypeName;
        return this;
    }

    public Date getReportTypeCreateTime() {
        return reportTypeCreateTime;
    }

    public ReportType setReportTypeCreateTime(Date reportTypeCreateTime) {
        this.reportTypeCreateTime = reportTypeCreateTime;
        return this;
    }

    public Date getReportTypeEditTime() {
        return reportTypeEditTime;
    }

    public ReportType setReportTypeEditTime(Date reportTypeEditTime) {
        this.reportTypeEditTime = reportTypeEditTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.reportTypeId;
    }

    @Override
    public String toString() {
        return "ReportType{" +
        "reportTypeId=" + reportTypeId +
        ", reportTypeName=" + reportTypeName +
        ", reportTypeCreateTime=" + reportTypeCreateTime +
        ", reportTypeEditTime=" + reportTypeEditTime +
        "}";
    }
}
