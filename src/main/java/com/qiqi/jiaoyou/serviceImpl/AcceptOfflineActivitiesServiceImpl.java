package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.AcceptOfflineActivitiesMapper;
import com.qiqi.jiaoyou.pojo.AcceptOfflineActivities;
import com.qiqi.jiaoyou.service.IAcceptOfflineActivitiesService;
import com.qiqi.jiaoyou.util.ResultUtils;
import com.qiqi.jiaoyou.vo.AcceptOfflineActivitiesVo;
import com.qiqi.jiaoyou.vo.Param;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 线下活动列表 服务实现类
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@Service
public class AcceptOfflineActivitiesServiceImpl extends ServiceImpl<AcceptOfflineActivitiesMapper, AcceptOfflineActivities> implements IAcceptOfflineActivitiesService {

    private final AcceptOfflineActivitiesMapper activitiesMapper;
    private final ResultUtils resultUtils;
    public AcceptOfflineActivitiesServiceImpl(AcceptOfflineActivitiesMapper activitiesMapper) {
        this.activitiesMapper = activitiesMapper;
        resultUtils = new ResultUtils();
    }

    /**
     * 取消赴约列表
     * author：nan
     * time:20210107
     * content:所以？是用户申请取消，才会在这里出现的
     * @return ResultUtils
     */
    public ResultUtils acceptList(Param param)
    {
        Map<String, String> map = new HashMap<>();
        if (param.getJson() != null && !"".equals(param.getJson())) {
            String[] split = param.getJson().split("&");
            for (String str : split) {
                String[] split1 = str.split("=");
                map.put(split1[0], split1.length == 1 ? "" : split1[1]);
            }
        }
        IPage<AcceptOfflineActivitiesVo> data = activitiesMapper.joinList(
                new Page<>(param.getPage(),param.getLimit()),
                map.get("nickName"),
                map.get("theme"),
                param.getTime(),
                map.get("status").equals("") ? null : Integer.valueOf(map.get("status"))
        );
        return resultUtils.success(data.getRecords(),(int)data.getTotal(),0);
    }

    /**
     *
     * @param id Integer 表id
     * @param status Integer 状态 1通过，2拒绝
     * @return ResultUtils
     */
    public ResultUtils acceptAlterStatus(Integer id,Integer status)
    {
        ResultUtils resultUtils = new ResultUtils();

//        int statusCode;
//        statusCode = status == 1 ? Status.CANCELED.status : Status.REFUSE.status;
//        boolean res = super.update(new UpdateWrapper<AcceptOfflineActivities>()
//                .eq("id", id)
//                .eq("keepAnAppointmentState", Status.TOAUDIT.status)
//                .set(statusCode == Status.CANCELED.status,"keepAnAppointmentState",statusCode)
//                .setSql(statusCode == Status.REFUSE.status,"keepAnAppointmentState = oldState")
//        );
        /***
         * 备注，臭狗屎，谢谢 5 取消 6拒绝
         * 通过是 申请取消通过 是取消状态
         * 不通过 申请取消不通过 是拒绝状态
         * 1:申请取消  2：强制取消
         */
        Boolean res = false;
        AcceptOfflineActivities acceptOfflineActivities = baseMapper.selectById(id);
        if(status == 1){
            acceptOfflineActivities.setKeepAnAppointmentState(5);
//            acceptOfflineActivities.setCloseType(0);
           res = baseMapper.updateById(acceptOfflineActivities) > 0 ? true :  false;
        }
        if(status == 2){
            acceptOfflineActivities.setKeepAnAppointmentState(6);
//            acceptOfflineActivities.setCloseType(0);
            res = baseMapper.updateById(acceptOfflineActivities) > 0 ? true : false;
        }
        if(res){
            resultUtils.setCode(200);
            resultUtils.setMessage("操作成功");
            return  resultUtils;
        }
        resultUtils.setCode(400);
        resultUtils.setMessage("操作失败");
        return  resultUtils;
//        return resultUtils.successError(res);
    }
}
