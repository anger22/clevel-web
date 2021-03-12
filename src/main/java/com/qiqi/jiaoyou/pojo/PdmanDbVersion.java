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
@TableName("PDMAN_DB_VERSION")
public class PdmanDbVersion extends Model<PdmanDbVersion> {

    private static final long serialVersionUID = 1L;

    @TableField("DB_VERSION")
    private String dbVersion;
    @TableField("VERSION_DESC")
    private String versionDesc;
    @TableField("CREATED_TIME")
    private String createdTime;


    public String getDbVersion() {
        return dbVersion;
    }

    public PdmanDbVersion setDbVersion(String dbVersion) {
        this.dbVersion = dbVersion;
        return this;
    }

    public String getVersionDesc() {
        return versionDesc;
    }

    public PdmanDbVersion setVersionDesc(String versionDesc) {
        this.versionDesc = versionDesc;
        return this;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public PdmanDbVersion setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    @Override
    public String toString() {
        return "PdmanDbVersion{" +
        "dbVersion=" + dbVersion +
        ", versionDesc=" + versionDesc +
        ", createdTime=" + createdTime +
        "}";
    }
}
