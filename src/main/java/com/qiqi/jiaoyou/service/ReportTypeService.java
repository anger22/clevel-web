package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.ReportType;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author slq
 * @since 2020-07-13
 */
public interface ReportTypeService extends IService<ReportType> {

    /**
    * 分页查询列表
    * @return
    */
    ResultUtils selectPageList(Map<String,String> map, int limit, int page);

    /**
    * 新增数据
    * @param reportType
    */
    ResultUtils addReportType(ReportType reportType);

    /**
    * 修改数据
    * @param reportType
    */
    ResultUtils editReportType(ReportType reportType);

    /**
    * 查看详情
    * @param reportTypeId
    * @return
    */
    ResultUtils getDetailsById(Integer reportTypeId);

    /**
    * 删除数据
    * @param reportTypeId
    * @return
    */
    ResultUtils deleteById(Integer reportTypeId);

    /**
    * 批量删除
    * @param ids
    * @return
    */
    ResultUtils deleteBatch(List<Long> ids);

}

