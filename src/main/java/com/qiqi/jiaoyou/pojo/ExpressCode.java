package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 快递公司编码(ExpressCode)表实体类
 *
 * @author makejava
 * @since 2020-12-08 17:43:15
 */
@SuppressWarnings("serial")
public class ExpressCode extends Model<ExpressCode> {

    private Integer id;
    //公司名称
    private String name;
    //公司编码
    private String code;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}