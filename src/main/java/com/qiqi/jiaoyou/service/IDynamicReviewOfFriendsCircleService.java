package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.DynamicReviewOfFriendsCircle;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;

/**
 * <p>
 * 朋友圈动态评论表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IDynamicReviewOfFriendsCircleService extends IService<DynamicReviewOfFriendsCircle> {

    /**
     * 查询朋友圈动态评论表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);
  /**
     * s用来信息记录
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPageS(Integer page, Integer limit,Map<String,String>map);
    /**
     * 添加朋友圈动态评论表
     *
     * @param dynamicReviewOfFriendsCircle 朋友圈动态评论表
     * @return ResultUtils
     */
    ResultUtils add(DynamicReviewOfFriendsCircle dynamicReviewOfFriendsCircle);

    /**
     * 删除朋友圈动态评论表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改朋友圈动态评论表
     *
     * @param dynamicReviewOfFriendsCircle 朋友圈动态评论表
     * @return ResultUtils
     */
    ResultUtils updateData(DynamicReviewOfFriendsCircle dynamicReviewOfFriendsCircle);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);

    Boolean deleteInfo(String memberId);
}
