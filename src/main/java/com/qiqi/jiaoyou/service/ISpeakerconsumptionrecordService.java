package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.Speakerconsumptionrecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 喇叭消费记录 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface ISpeakerconsumptionrecordService extends IService<Speakerconsumptionrecord> {

    /**
     * 查询喇叭消费记录分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加喇叭消费记录
     *
     * @param speakerconsumptionrecord 喇叭消费记录
     * @return ResultUtils
     */
    ResultUtils add(Speakerconsumptionrecord speakerconsumptionrecord);

    /**
     * 删除喇叭消费记录
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改喇叭消费记录
     *
     * @param speakerconsumptionrecord 喇叭消费记录
     * @return ResultUtils
     */
    ResultUtils updateData(Speakerconsumptionrecord speakerconsumptionrecord);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}
