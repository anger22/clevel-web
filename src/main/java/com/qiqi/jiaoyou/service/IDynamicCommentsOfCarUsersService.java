package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.DynamicCommentsOfCarUsers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 车友动态评论表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IDynamicCommentsOfCarUsersService extends IService<DynamicCommentsOfCarUsers> {

    /**
     * 查询车友动态评论表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加车友动态评论表
     *
     * @param dynamicCommentsOfCarUsers 车友动态评论表
     * @return ResultUtils
     */
    ResultUtils add(DynamicCommentsOfCarUsers dynamicCommentsOfCarUsers);

    /**
     * 删除车友动态评论表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改车友动态评论表
     *
     * @param dynamicCommentsOfCarUsers 车友动态评论表
     * @return ResultUtils
     */
    ResultUtils updateData(DynamicCommentsOfCarUsers dynamicCommentsOfCarUsers);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}
