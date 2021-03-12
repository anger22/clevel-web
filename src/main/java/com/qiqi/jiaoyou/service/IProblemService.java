package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.Problem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 常见问题表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IProblemService extends IService<Problem> {

    /**
     * 查询常见问题表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加常见问题表
     *
     * @param problem 常见问题表
     * @return ResultUtils
     */
    ResultUtils add(Problem problem);

    /**
     * 删除常见问题表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改常见问题表
     *
     * @param problem 常见问题表
     * @return ResultUtils
     */
    ResultUtils updateData(Problem problem);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);

    /**
     * 修改启用状态
     */
    ResultUtils updateEnable(Integer id, Integer enableState);
}
