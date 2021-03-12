package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.NewFriend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * .新朋友列表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface INewFriendService extends IService<NewFriend> {

    /**
     * 查询.新朋友列表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加.新朋友列表
     *
     * @param newFriend .新朋友列表
     * @return ResultUtils
     */
    ResultUtils add(NewFriend newFriend);

    /**
     * 删除.新朋友列表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改.新朋友列表
     *
     * @param newFriend .新朋友列表
     * @return ResultUtils
     */
    ResultUtils updateData(NewFriend newFriend);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
}
