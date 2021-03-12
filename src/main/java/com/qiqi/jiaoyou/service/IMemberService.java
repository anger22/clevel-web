package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.Member;
import com.qiqi.jiaoyou.util.ResultUtils;
import com.qiqi.jiaoyou.vo.MemberVo;

import java.util.Map;

/**
 * <p>
 * app会员表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IMemberService extends IService<Member> {

    /**
     * 更新审核的状态信息
     * @param member
     * @return
     */
    ResultUtils updateShitInfo(Member member);


    /**
     * 查询app会员表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);
    ResultUtils findListByPageRes(Integer page, Integer limit,Map<String,String>map);

    ResultUtils update(Integer id);
    /**
     * 批量删除
     * @param array
     * @return
     */
   ResultUtils delMore(String array);

    /**
     * 添加app会员表
     *
     * @param member app会员表
     * @return ResultUtils
     */
    ResultUtils add(Member member);


    ResultUtils updateGold(Integer userid, Integer gold, Integer silver, String  endTime);

    /**
     * 删除app会员表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Integer id);

    /**
     * 修改app会员表
     *
     * @param member app会员表
     * @return ResultUtils
     */
    ResultUtils updateDataA(Member member);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);

    Member findByMember(Long id);
    /**
     * 查询用户的钻石和
     * @param id
     * @return
     */
   MemberVo findUserInfo(Long id);


    /**
     * 修改启用状态
     */
    ResultUtils updateEnable(Integer id, Integer enableState);

    ResultUtils updateIsCustomer(Integer id, Integer isCustomer);
}
