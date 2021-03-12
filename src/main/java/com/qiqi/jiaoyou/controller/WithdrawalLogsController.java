package com.qiqi.jiaoyou.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.qiqi.jiaoyou.service.WithdrawalLogsService;
import com.qiqi.jiaoyou.util.ResultUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 金钻银钻兑换记录表(WithdrawalLogs)表控制层
 *
 * @author nan
 * @since 2020-12-14 09:32:35
 */
@Controller
@RequestMapping("/withdrawalLogs")
public class WithdrawalLogsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private WithdrawalLogsService withdrawalLogsService;


@ApiOperation(value = "查询兑换记录信息表的记录信息")
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
		return withdrawalLogsService.findListByPage(page, limit,map);
	}}