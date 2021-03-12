package com.qiqi.jiaoyou.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.Report;
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
public interface ReportService extends IService<Report> {

    /**
    * 分页查询列表
    * @return
    */
    ResultUtils selectPageList(Map<String,String> map, int limit, int page);

    /**
    * 新增数据
    * @param report
    */
    ResultUtils addReport(Report report);

    /**
    * 修改数据
    * @param report
    */
    ResultUtils editReport(Report report);

    /**
    * 查看详情
    * @param reportId
    * @return
    */
    ResultUtils getDetailsById(Integer reportId);

    /**
    * 删除数据
    * @param reportId
    * @return
    */
    ResultUtils deleteById(Integer reportId);

    /**
    * 批量删除
    * @param ids
    * @return
    */
    ResultUtils deleteBatch(List<Long> ids);

}

