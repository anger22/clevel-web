package com.qiqi.jiaoyou.controller;

import com.qiqi.jiaoyou.pojo.RedLog;
import com.qiqi.jiaoyou.service.RedLogService;
import com.qiqi.jiaoyou.util.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 红包发送记录表(RedLog)表控制层
 *
 * @author      nan
 * @since 2020-11-26 10:18:19
 */
@Api(tags = {"礼物记录表"})
@Controller
@RequestMapping("/redLog")
public class RedLogController {
	/**
	 * 服务对象
	 */
	@Resource
	private RedLogService redLogService;

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 *
	 * @return 单条数据
	 */
	@GetMapping("/selectOne")
	public RedLog selectOne(Integer id) {
		return this.redLogService.queryById(id);
	}



	@ApiOperation(value = "查询红包发送记录分页数据")
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
        return redLogService.findListByPage(page, limit,map);
    }

}