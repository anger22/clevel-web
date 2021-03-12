package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.GoodFriend;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;

/**
 * <p>
 * 好友列表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IGoodFriendService extends IService<GoodFriend> {

    /**
     * 查询好友列表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加好友列表
     *
     * @param goodFriend 好友列表
     * @return ResultUtils
     */
    ResultUtils add(GoodFriend goodFriend);

    /**
     * 删除好友列表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改好友列表
     *
     * @param goodFriend 好友列表
     * @return ResultUtils
     */
    ResultUtils updateData(GoodFriend goodFriend);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);


    /**
     * 删除用户的好友信息
     * @param memberId
     * @return
     */
    Boolean deleteMemberInfo(String memberId);
}
