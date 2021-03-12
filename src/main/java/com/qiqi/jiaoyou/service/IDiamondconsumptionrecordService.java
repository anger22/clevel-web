package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.Diamondconsumptionrecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 钻石消费记录 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IDiamondconsumptionrecordService extends IService<Diamondconsumptionrecord> {

    /**
     * 查询钻石消费记录分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加钻石消费记录
     *
     * @param diamondconsumptionrecord 钻石消费记录
     * @return ResultUtils
     */
    ResultUtils add(Diamondconsumptionrecord diamondconsumptionrecord);

    /**
     * 删除钻石消费记录
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改钻石消费记录
     *
     * @param diamondconsumptionrecord 钻石消费记录
     * @return ResultUtils
     */
    ResultUtils updateData(Diamondconsumptionrecord diamondconsumptionrecord);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}
