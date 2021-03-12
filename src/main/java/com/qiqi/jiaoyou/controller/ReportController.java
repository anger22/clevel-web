package com.qiqi.jiaoyou.controller;

import com.qiqi.jiaoyou.pojo.Report;
import com.qiqi.jiaoyou.service.ReportService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author slq
 * @since 2020-07-13
 */
@Controller
@RequestMapping("/report")
public class ReportController {


    @Autowired
    private ReportService reportService;

    /**
    * 跳转到主页面
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/report/report"})
    public String index(){
        return "/pages/report/report";
    }

    /**
    * 跳转到修改页面
    */
    @GetMapping("/pages/ReportDetail")
    public String edit(Integer id, Model model) {
        Report report = (Report)reportService.getDetailsById(id).getData();
        model.addAttribute("report", report);
        return "/pages/report/reportEdit";
    }

    /**
    * 查询列表
    * @param limit
    * @param page
    * @return
    */
    @RequestMapping("/findListByPage")
    @ResponseBody
    public ResultUtils findListByPage(@RequestParam Integer page,
                                      @RequestParam Integer limit,
                                      @RequestParam String json) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        if (json != null && !"".equals(json)) {
            String[] split = json.split("&");
            for (String str : split) {
                String[] split1 = str.split("=");
                if (split1.length == 1) {
                    continue;
                } else {
                    map.put(split1[0],split1[1]);
                }
            }
        }
      return reportService.selectPageList(map,limit,page);
    }

    /**
    * 新增数据
    * @param report
    * @return
    */
    @RequestMapping("/addReport")
    @ResponseBody
    public ResultUtils addReport(Report report) {
        return reportService.addReport(report);
    }

    /**
    * 修改数据
    * @param report
    * @return
    */
    @PostMapping("/editReport")
    @ResponseBody
    public ResultUtils editReport(@ModelAttribute  Report report) {
        return reportService.editReport(report);
    }

    /**
    * 查看详情
    * @param reportId
    * @return
    */
    @RequestMapping("/detail")
    @ResponseBody
    public ResultUtils detail(Integer reportId) {
        return reportService.getDetailsById(reportId);
    }

    /**
    * 根据ID删除记录
    * @param reportId
    * @return
    */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Integer reportId) {
        return reportService.deleteById(reportId);
    }

    /**
    * 批量删除数据
    * @param ids ID集合
    * @return
    */
    @RequestMapping("/deleteBatch")
    @ResponseBody
    public ResultUtils deleteBatch(@RequestParam(value = "ids[]",required = true) List<Long> ids) {
        return reportService.deleteBatch(ids);
    }

}
