package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 后台管理员表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IAccountService extends IService<Account> {

    /**
     * 查询后台管理员表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加后台管理员表
     *
     * @param account 后台管理员表
     * @return ResultUtils
     */
    ResultUtils add(Account account);

    /**
     * 删除后台管理员表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改后台管理员表
     *
     * @param account 后台管理员表
     * @return ResultUtils
     */
    ResultUtils updateData(Account account);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);

    /**
     * 修改启用状态
     * @param id
     * @param enableState
     * @return
     */
    ResultUtils updateEnable(Integer id, Integer enableState);

    /**
     * 登录
     * @param account
     * @return
     */
    ResultUtils login(Account account);

    /**
     * 解锁
     * @param account
     * @return
     */
    ResultUtils unLock(Account account);

    /**
     * 修改密码
     */
    ResultUtils updatePwd(Account account);
}
