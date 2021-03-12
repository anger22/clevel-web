package com.qiqi.jiaoyou.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Param implements Serializable {
    private static final long serialVersionUID = -7864835756476635473L;
    private String name;
    private String theme;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private Integer status;
    private int page;
    private int limit;
    private String json;
}
