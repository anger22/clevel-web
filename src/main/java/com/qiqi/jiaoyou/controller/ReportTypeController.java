package com.qiqi.jiaoyou.controller;

import com.qiqi.jiaoyou.pojo.Report;
import com.qiqi.jiaoyou.pojo.ReportType;
import com.qiqi.jiaoyou.service.ReportTypeService;
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
@RequestMapping("/reportType")
public class ReportTypeController {


    @Autowired
    private ReportTypeService reportTypeService;

    /**
    * 跳转到主页面
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/reportType/reportType"})
    public String index(){
        return "/pages/reportType/reportType";
    }

    /**
    * 跳转到新增页面
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/reportType/reportTypeAdd"})
    public String add(){
        return "/pages/reportType/reportTypeAdd";
    }

    /**
    * 跳转到修改页面
    */
    @GetMapping("/pages/ReportTypeDetail")
    public String edit(Integer id, Model model) {
        ReportType report = (ReportType)reportTypeService.getDetailsById(id).getData();
        model.addAttribute("reportType", report);
        return "/pages/reportType/reportTypeEdit";
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
        return reportTypeService.selectPageList(map,limit,page);
    }

    /**
    * 新增数据
    * @param reportType
    * @return
    */
    @PostMapping("/addReportType")
    @ResponseBody
    public ResultUtils addReportType(@ModelAttribute ReportType reportType) {
        return reportTypeService.addReportType(reportType);
    }

    /**
    * 修改数据
    * @param reportType
    * @return
    */
    @PostMapping("/editReportType")
    @ResponseBody
    public ResultUtils editReportType(@ModelAttribute ReportType reportType) {
        return reportTypeService.editReportType(reportType);
    }

    /**
    * 查看详情
    * @param reportTypeId
    * @return
    */
    @RequestMapping("/detail")
    @ResponseBody
    public ResultUtils detail(Integer reportTypeId) {
        return reportTypeService.getDetailsById(reportTypeId);
    }

    /**
    * 根据ID删除记录
    * @param reportTypeId
    * @return
    */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Integer reportTypeId) {
        return reportTypeService.deleteById(reportTypeId);
    }

    /**
    * 批量删除数据
    * @param ids ID集合
    * @return
    */
    @RequestMapping("/deleteBatch")
    @ResponseBody
    public ResultUtils deleteBatch(@RequestParam(value = "ids[]",required = true) List<Long> ids) {
        return reportTypeService.deleteBatch(ids);
    }

}
