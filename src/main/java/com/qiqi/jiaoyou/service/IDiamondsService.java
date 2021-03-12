package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.Diamonds;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author GR123
 * @since 2020-07-15
 */
public interface IDiamondsService extends IService<Diamonds> {

    ResultUtils add(Diamonds diamonds);

    ResultUtils delete(Integer id);

    ResultUtils updateData(Diamonds diamonds);

    ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map);

    ResultUtils findById(Long id);
}
