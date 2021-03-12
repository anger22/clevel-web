package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qiqi.jiaoyou.mapper.ReportTypeMapper;
import com.qiqi.jiaoyou.pojo.Report;
import com.qiqi.jiaoyou.pojo.ReportType;
import com.qiqi.jiaoyou.service.ReportTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author slq
 * @since 2020-07-13
 */
@Service
public class ReportTypeServiceImpl extends ServiceImpl<ReportTypeMapper, ReportType> implements ReportTypeService {

    /**
    * 分页查询列表
    * @return
    */
    @Override
    public ResultUtils selectPageList(Map<String,String> map, int limit, int page)  {
        ResultUtils resultUtils = new ResultUtils();
        Page pageContext = new Page(page,limit);
        QueryWrapper<ReportType> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key));
        }
        wrapper.orderByDesc("reportTypeId");
        List records = this.baseMapper.selectPage(pageContext, wrapper).getRecords();
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        resultUtils.setData(records);
        resultUtils.setCode(0);
        resultUtils.setCount((int)pageContext.getTotal());
        return resultUtils;
    }

    /**
    * 新增数据
    * @param reportType
    */
    @Override
    public ResultUtils addReportType(ReportType reportType) {
        ResultUtils resultUtils = new ResultUtils();
        reportType.setReportTypeCreateTime(new Timestamp(System.currentTimeMillis()));
        int insert = baseMapper.insert(reportType);
        if(insert > 0){
            resultUtils.setStatus(200);
            resultUtils.setMessage("添加成功");
        }else{
            resultUtils.setStatus(200);
            resultUtils.setMessage("添加失败");
        }
        return resultUtils;
    }

    /**
    * 修改数据
    * @param reportType
    */
    @Override
    public ResultUtils editReportType(ReportType reportType) {
        ResultUtils resultUtils = new ResultUtils();
        reportType.setReportTypeEditTime(new Timestamp(System.currentTimeMillis()));
        int i = baseMapper.updateById(reportType);
        if(i > 0){
            resultUtils.setStatus(200);
            resultUtils.setMessage("编辑成功");
        }else{
            resultUtils.setStatus(200);
            resultUtils.setMessage("编辑失败");
        }
        return resultUtils;
    }

    /**
    * 查看详情
    * @param reportTypeId
    * @return
    */
    @Override
    public ResultUtils getDetailsById(Integer reportTypeId) {
        ResultUtils resultUtils = new ResultUtils();
        ReportType report = baseMapper.selectById(reportTypeId);
        resultUtils.setData(report);
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        return resultUtils;
    }

    /**
    * 删除数据
    * @param reportTypeId
    * @return
    */
    @Override
    public ResultUtils deleteById(Integer reportTypeId) {
        ResultUtils resultUtils = new ResultUtils();
        int i = baseMapper.deleteById(reportTypeId);
        if(i > 0){
            resultUtils.setStatus(200);
            resultUtils.setMessage("删除成功");
        }else{
            resultUtils.setStatus(200);
            resultUtils.setMessage("删除失败");
        }
        return resultUtils;
    }

    /**
    * 批量删除
    * @param ids
    * @return
    */
    @Override
    public ResultUtils deleteBatch(List<Long> ids) {
        ResultUtils resultUtils = new ResultUtils();
        int i = baseMapper.deleteBatchIds(ids);
        if(i > 0){
            resultUtils.setStatus(200);
            resultUtils.setMessage("批量删除成功");
        }else{
            resultUtils.setStatus(200);
            resultUtils.setMessage("批量删除失败");
        }
        return resultUtils;
    }

}

