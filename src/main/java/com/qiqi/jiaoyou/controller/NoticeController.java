package com.qiqi.jiaoyou.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.qiqi.jiaoyou.service.INoticeService;
import com.qiqi.jiaoyou.pojo.Notice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 公告表 前端控制器
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Api(tags = {"公告表"})
@Controller
@RequestMapping("/notice")
public class NoticeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private INoticeService noticeService;


    @ApiOperation(value = "新增公告表")
    @PostMapping("/add")
    @ResponseBody
    public ResultUtils add(@ModelAttribute Notice notice){
        return noticeService.add(notice);
    }

    @ApiOperation(value = "删除公告表")
    @GetMapping("/delete")
    @ResponseBody
    public ResultUtils delete(Long id){
        return noticeService.delete(id);
    }

    @ApiOperation(value = "更新公告表")
    @PostMapping("/update")
    @ResponseBody
    public ResultUtils update(@ModelAttribute Notice notice){
        return noticeService.updateData(notice);
    }

    @ApiOperation(value = "查询公告表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/findListByPage")
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
        return noticeService.findListByPage(page, limit,map);
    }

    @ApiOperation(value = "id查询公告表")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtils findById(@PathVariable Long id){
        return noticeService.findById(id);
    }

    /**
    * 跳转列表页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = {"/pages/NoticeList"})
    public String index(){
        return "/pages/Notice/NoticeList";
    }

    /**
    * 跳转添加页面
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/NoticeAdd")
    public String accountAdd(){
        return"/pages/Notice/NoticeAdd";
    }

    /**
    * 跳转修改页面
    * @param id  实体ID
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/pages/NoticeUpdate")
    public String accountUpdate(Long id,Model model){
        model.addAttribute("notice", (Notice)noticeService.findById(id).getData());
        return"/pages/Notice/NoticeUpdate";
    }

    /**
     * 修改启用状态
     */
    @ApiOperation(value = "修改启用状态")
    @RequestMapping(method = RequestMethod.GET, value = "/updateEnable")
    @ResponseBody
    public ResultUtils updateEnable(Integer id,Integer enableState){
        return noticeService.updateEnable(id,enableState);
    }

}
