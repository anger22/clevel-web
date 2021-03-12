package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IRoleService extends IService<Role> {

    /**
     * 查询角色表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加角色表
     *
     * @param role 角色表
     * @return ResultUtils
     */
    ResultUtils add(Role role);

    /**
     * 删除角色表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改角色表
     *
     * @param role 角色表
     * @return ResultUtils
     */
    ResultUtils updateData(Role role);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);

    /**
     * 查询所有可用角色，用于下拉框
     * @return
     */
    ResultUtils selectAllRole();

    /**
     * 修改启用状态
     */
    ResultUtils updateEnable(Integer id, Integer enableState);
}
