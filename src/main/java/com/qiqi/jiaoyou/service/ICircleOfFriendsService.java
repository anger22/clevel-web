package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.CircleOfFriends;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;

/**
 * <p>
 * 朋友圈动态 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface ICircleOfFriendsService extends IService<CircleOfFriends> {

    /**
     * 查询朋友圈动态分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加朋友圈动态
     *
     * @param circleOfFriends 朋友圈动态
     * @return ResultUtils
     */
    ResultUtils add(CircleOfFriends circleOfFriends);

    /**
     * 删除朋友圈动态
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改朋友圈动态
     *
     * @param circleOfFriends 朋友圈动态
     * @return ResultUtils
     */
    ResultUtils updateData(CircleOfFriends circleOfFriends);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);

    Boolean deleteMemberInfo(String memberId);
}
