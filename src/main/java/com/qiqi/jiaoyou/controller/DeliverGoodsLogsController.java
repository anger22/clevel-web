package com.qiqi.jiaoyou.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.qiqi.jiaoyou.mapper.OrderManageDao;
import com.qiqi.jiaoyou.pojo.DeliverGoodsLogs;
import com.qiqi.jiaoyou.pojo.OrderManage;
import com.qiqi.jiaoyou.service.DeliverGoodsLogsService;
import com.qiqi.jiaoyou.service.OrderManageService;
import com.qiqi.jiaoyou.util.ResultUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 发货记录表(DeliverGoodsLogs)表控制层
 *
 * @author nan
 * @since 2020-12-08 13:59:44
 */
@Controller
@RequestMapping("/deliverLogs")
public class DeliverGoodsLogsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private DeliverGoodsLogsService deliverGoodsLogsService;
     @Autowired
    private OrderManageService orderManageService;
   @Autowired
   private OrderManageDao orderManageDao;

        private Logger log = LoggerFactory.getLogger(getClass());
        /*因为页面跳转其他部分实现了，所以这里我们写一个新增就可以了，哈哈哈哈哈哈哈*/
	@ApiOperation(value = "新增选项标签")
	@PostMapping("/add")
	@ResponseBody
	public ResultUtils add(@ModelAttribute DeliverGoodsLogs deliverGoodsLogs){
		return deliverGoodsLogsService.add(deliverGoodsLogs);
	}

    /**
     * 订单的回调地址
     */
	@ApiOperation(value = "新增选项标签")
	@PostMapping("/orderBackUrl")
	@ResponseBody
	public ResultUtils backUrl(HttpServletRequest request){
        //建议记录一下这个回调的内容，方便出问题后双方排查问题
        String param = request.getParameter("param");
        String sign = request.getParameter("parameters");
        //建议记录一下这个回调的内容，方便出问题后双方排查问题
//        System.out.println("快递100订阅推送回调结果"+param);
        JSONObject jsonObject = JSONObject.parseObject(param);
        String Num =  jsonObject.getString("kuaidinum");

        ResultUtils subscribeResp = new ResultUtils();
        if(!Num.equals("")){

  /*这里更新订单表里的某个订单的详细信息*/
            QueryWrapper<OrderManage> wrapper = new QueryWrapper<>();
            JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.getString("data"));
            wrapper.eq("order_id",jsonObject1.getString("orderId"));
            List<OrderManage> list =  orderManageDao.selectList(wrapper);
            if(list != null){
                OrderManage orderManage = new OrderManage();
                orderManage.setId(list.get(0).getId());
                orderManage.setExpressNum(Num);
                Boolean bollean = orderManageService.updateInfo(orderManage);
                if(bollean)
                {
                    subscribeResp.setCode(200);
                    subscribeResp.setMessage("快递单号获取并更新成功"+Num);
                }
                else{
                    subscribeResp.setCode(400);
                    subscribeResp.setMessage("快递单号获取成功但是更新数据库失败"+Num);
                }
//                System.out.println("快递单号获取并更新成功"+Num);
            }
            }
            return subscribeResp;
        }

}