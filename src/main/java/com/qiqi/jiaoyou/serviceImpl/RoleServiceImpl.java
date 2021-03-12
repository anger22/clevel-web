package com.qiqi.jiaoyou.serviceImpl;

import com.qiqi.jiaoyou.mapper.AccountMapper;
import com.qiqi.jiaoyou.mapper.MenuMapper;
import com.qiqi.jiaoyou.pojo.Account;
import com.qiqi.jiaoyou.pojo.Menu;
import com.qiqi.jiaoyou.pojo.Role;
import com.qiqi.jiaoyou.mapper.RoleMapper;
import com.qiqi.jiaoyou.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qiqi.jiaoyou.util.ResultUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private MenuMapper menuMapper;


    @Override
    public ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map){
        ResultUtils resultUtils = new ResultUtils();
        IPage<Role> wherePage = new Page<>(page, limit);
        QueryWrapper<Role> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key));
        }
            wrapper.orderByDesc("id");

        IPage<Role> list =   baseMapper.selectPage(wherePage, wrapper);
        List<Menu> menus = menuMapper.selectList(new QueryWrapper<Menu>());
        Map<Integer,String> map1 = new HashMap<>();
        for (Menu menu : menus){
            map1.put(menu.getfId(),menu.getfName());
        }
        List<Role> records = list.getRecords();
        for (Role role : records){
            String[] split = role.getMenus().split(",");
            String str = "";
            for (String s : split){
                str += map1.get(Integer.valueOf(s)) + ",";
            }
            role.setMenuStr(str);
        }
        resultUtils.setData(records);
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
    }

    @Override
    public ResultUtils add(Role role){
        ResultUtils resultUtils = new ResultUtils();
        role.setAddTime(new Timestamp(System.currentTimeMillis()));
        role.setDeleteState(2);
        role.setEnableState(1);
        Integer i =  baseMapper.insert(role);
        if(i > 0){
            resultUtils.setStatus(200);
            resultUtils.setMessage("添加成功");
        }else{
            resultUtils.setStatus(200);
            resultUtils.setMessage("添加失败");
        }
        return resultUtils;
    }

    @Override
    public ResultUtils delete(Long id){
        ResultUtils resultUtils = new ResultUtils();
        //删除角色之前 先判断有没有管理员是这个角色  如果是 就不能删除该角色
        List<Account> accounts = accountMapper.selectList(new QueryWrapper<Account>().eq("roleId", id).eq("deleteState", 2));
        if (accounts.size() > 0){
            resultUtils.setStatus(500);
            resultUtils.setMessage("该角色正在使用中,不可删除该角色");
        }else {
            Integer i = baseMapper.deleteById(id);
            if (i > 0) {
                resultUtils.setStatus(200);
                resultUtils.setMessage("删除成功");
            } else {
                resultUtils.setStatus(200);
                resultUtils.setMessage("删除失败");
            }
        }
        return resultUtils;
    }

    @Override
    public ResultUtils updateData(Role role){
        ResultUtils resultUtils = new ResultUtils();
        role.setEditTime(new Timestamp(System.currentTimeMillis()));
        Integer i =  baseMapper.updateById(role);
        if(i > 0){
            resultUtils.setStatus(200);
            resultUtils.setMessage("编辑成功");
        }else{
            resultUtils.setStatus(200);
            resultUtils.setMessage("编辑失败");
        }
        return resultUtils;
    }

    @Override
    public ResultUtils findById(Long id){
        ResultUtils resultUtils = new ResultUtils();
        Role obj = baseMapper.selectById(id);
        resultUtils.setData(obj);
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        return resultUtils;
    }

    /**
     * 查询所有可用角色，用于下拉框
     *
     * @return
     */
    @Override
    public ResultUtils selectAllRole() {
        ResultUtils resultUtils = new ResultUtils();
        List<Role> roles = baseMapper.selectList(new QueryWrapper<Role>().eq("enableState", 1).eq("deleteState", 2));
        resultUtils.setData(roles);
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        return resultUtils;
    }

    /**
     * 修改启用状态
     *
     * @param id
     * @param enableState
     */
    @Override
    public ResultUtils updateEnable(Integer id, Integer enableState) {
        ResultUtils resultUtils = new ResultUtils();
        Role role = new Role();
        role.setId(id);
        role.setEnableState(enableState);
        int i = baseMapper.updateById(role);
        if (i > 0){
            resultUtils.setMessage("修改成功");
            resultUtils.setStatus(200);
        }else {
            resultUtils.setMessage("修改失败");
            resultUtils.setStatus(500);
        }
        return resultUtils;
    }
}
