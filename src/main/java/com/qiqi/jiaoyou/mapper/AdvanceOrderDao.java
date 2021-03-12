package com.qiqi.jiaoyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiqi.jiaoyou.pojo.AdvanceOrder;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (AdvanceOrder)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-08 02:43:50
 */
public interface AdvanceOrderDao extends BaseMapper<AdvanceOrder> {
    @Select("SELECT * from advance_order")
    List<AdvanceOrder> selectListInfo();
}