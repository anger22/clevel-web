package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.MemberMapper;
import com.qiqi.jiaoyou.mapper.ReportMapper;
import com.qiqi.jiaoyou.mapper.ReportTypeMapper;
import com.qiqi.jiaoyou.pojo.Member;
import com.qiqi.jiaoyou.pojo.Report;
import com.qiqi.jiaoyou.pojo.ReportType;
import com.qiqi.jiaoyou.service.ReportService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;
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
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements ReportService {

    @Autowired
    private ReportTypeMapper reportTypeMapper;
    @Autowired
    private MemberMapper memberMapper;

    /**
    * 分页查询列表
    * @param
    * @return
    */
    @Override
    public ResultUtils selectPageList(Map<String,String> map, int limit, int page)  {
        ResultUtils resultUtils = new ResultUtils();
        Page pageContext = new Page(page,limit);
        QueryWrapper<Report> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key));
        }
        wrapper.orderByDesc("reportId");
        List<Report> records = this.baseMapper.selectPage(pageContext, wrapper).getRecords();
        //查询所有分类
        List<ReportType> reportTypes = reportTypeMapper.selectList(new QueryWrapper<ReportType>());
        Map<Integer,String> map1 = new HashMap<>();
        for (ReportType reportType : reportTypes){
            map1.put(reportType.getReportTypeId(),reportType.getReportTypeName());
        }
        for (Report report : records){
            report.setStr(map1.get(report.getReportReason()));
        }
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        resultUtils.setData(records);
        resultUtils.setCode(0);
        resultUtils.setCount((int)pageContext.getTotal());
        return resultUtils;
    }

    /**
    * 新增数据
    * @param report
    */
    @Override
    public ResultUtils addReport(Report report) {
        ResultUtils resultUtils = new ResultUtils();
        int insert = baseMapper.insert(report);
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
    * @param report
    */
    @Override
    public ResultUtils editReport(Report report) {
        ResultUtils resultUtils = new ResultUtils();
        int i = baseMapper.updateById(report);
        report = baseMapper.selectById(report.getReportId());
        if(i > 0){
            if (report.getReportExamineState() == 2){
                Integer reportBeiInformantId = report.getReportBeiInformantId();
                Member member = new Member();
                member.setId(reportBeiInformantId);
                member.setEnableSate(2);
                int i1 = memberMapper.updateById(member);
                if (i1 > 0){
                    resultUtils.setStatus(200);
                    resultUtils.setMessage("审核完成");
                }else {
                    resultUtils.setStatus(200);
                    resultUtils.setMessage("审核失败");
                }
            }else {
                resultUtils.setStatus(200);
                resultUtils.setMessage("审核失败");
            }
        }else{
            resultUtils.setStatus(200);
            resultUtils.setMessage("审核失败");
        }
        return resultUtils;
    }

    /**
    * 查看详情
    * @param reportId
    * @return
    */
    @Override
    public ResultUtils getDetailsById(Integer reportId) {
        ResultUtils resultUtils = new ResultUtils();
        Report report = baseMapper.selectById(reportId);
        resultUtils.setData(report);
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        return resultUtils;
    }

    /**
    * 删除数据
    * @param reportId
    * @return
    */
    @Override
    public ResultUtils deleteById(Integer reportId) {
        ResultUtils resultUtils = new ResultUtils();
        int i = baseMapper.deleteById(reportId);
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

