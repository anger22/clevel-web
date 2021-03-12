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
 * 常见问题表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Problem extends Model<Problem> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 问题名称
     */
    private String title;
    /**
     * 答案
     */
    private String answer;
    /**
     * 发布时间
     */
    private Date addTime;
    /**
     * 编辑时间
     */
    private Date editTime;
    /**
     * 启用状态 1:启用2:禁用
     */
    private Integer enableState;
    /**
     * 删除状态 1:已删除2:未删除
     */
    private Integer deleteState;


    public Integer getId() {
        return id;
    }

    public Problem setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Problem setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public Problem setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Problem setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Date getEditTime() {
        return editTime;
    }

    public Problem setEditTime(Date editTime) {
        this.editTime = editTime;
        return this;
    }

    public Integer getEnableState() {
        return enableState;
    }

    public Problem setEnableState(Integer enableState) {
        this.enableState = enableState;
        return this;
    }

    public Integer getDeleteState() {
        return deleteState;
    }

    public Problem setDeleteState(Integer deleteState) {
        this.deleteState = deleteState;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Problem{" +
        "id=" + id +
        ", title=" + title +
        ", answer=" + answer +
        ", addTime=" + addTime +
        ", editTime=" + editTime +
        ", enableState=" + enableState +
        ", deleteState=" + deleteState +
        "}";
    }
}
