package com.qiqi.jiaoyou.mapper;

import com.qiqi.jiaoyou.pojo.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * app会员表 Mapper 接口
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */

public interface MemberMapper extends BaseMapper<Member> {

    Integer updateMember(Member member);

}
