package com.qiqi.jiaoyou.serviceImpl;

import com.qiqi.jiaoyou.mapper.RoleMapper;
import com.qiqi.jiaoyou.pojo.Account;
import com.qiqi.jiaoyou.mapper.AccountMapper;
import com.qiqi.jiaoyou.pojo.Role;
import com.qiqi.jiaoyou.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.util.MD5;
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
 * 后台管理员表 服务实现类 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map){
        ResultUtils resultUtils = new ResultUtils();
        IPage<Account> wherePage = new Page<>(page, limit);
        QueryWrapper<Account> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key));
        }
            wrapper.orderByDesc("id");

        IPage<Account> list =   baseMapper.selectPage(wherePage, wrapper);

        List<Account> records = list.getRecords();
        List<Role> roles = roleMapper.selectList(new QueryWrapper<Role>());
        Map<Integer,String> map1 = new HashMap<>();
        for (Role role : roles){
            map1.put(role.getId(),role.getName());
        }
        for (Account account : records){
            account.setRoleName(map1.get(account.getRoleId()));
        }
        resultUtils.setData(records);
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
    }

    @Override
    public ResultUtils add(Account account){
        ResultUtils resultUtils = new ResultUtils();
        //查询账号有没有使用
        List<Account> account1 = baseMapper.selectList(new QueryWrapper<Account>().eq("account", account.getAccount()));
        if (account1.size() > 0){
            resultUtils.setStatus(500);
            resultUtils.setMessage("该账号已被使用");
            return resultUtils;
        }
        account.setAddTime(new Timestamp(System.currentTimeMillis()));
        account.setDeleteState(2);
        account.setEnableState(1);
        account.setPassword(MD5.GetMD5Code(account.getPassword()));
        Integer i =  baseMapper.insert(account);
        if(i > 0){
            resultUtils.setStatus(200);
            resultUtils.setMessage("添加成功");
        }else{
            resultUtils.setStatus(500);
            resultUtils.setMessage("添加失败");
        }
        return resultUtils;
    }

    @Override
    public ResultUtils delete(Long id){
        ResultUtils resultUtils = new ResultUtils();
        Integer i =  baseMapper.deleteById(id);
        if(i > 0){
            resultUtils.setStatus(200);
            resultUtils.setMessage("删除成功");
        }else{
            resultUtils.setStatus(500);
            resultUtils.setMessage("删除失败");
        }
        return resultUtils;
    }

    @Override
    public ResultUtils updateData(Account account){
        ResultUtils resultUtils = new ResultUtils();
        //查询账号有没有使用
        List<Account> account1 = baseMapper.selectList(new QueryWrapper<Account>().eq("account", account.getAccount()));
        if (account1.size() > 0){
            resultUtils.setStatus(500);
            resultUtils.setMessage("该账号已被使用");
            return resultUtils;
        }
        Integer i =  baseMapper.updateById(account);
        if(i > 0){
            resultUtils.setStatus(200);
            resultUtils.setMessage("编辑成功");
        }else{
            resultUtils.setStatus(500);
            resultUtils.setMessage("编辑失败");
        }
        return resultUtils;
    }

    @Override
    public ResultUtils findById(Long id){
        ResultUtils resultUtils = new ResultUtils();
        Account obj = baseMapper.selectById(id);
        resultUtils.setData(obj);
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        return resultUtils;
    }

    /**
     * 修改启用状态
     *
     * @param id
     * @param enableState
     * @return
     */
    @Override
    public ResultUtils updateEnable(Integer id, Integer enableState) {
        ResultUtils resultUtils = new ResultUtils();
        Account account = new Account();
        account.setId(id);
        account.setEnableState(enableState);
        int i = baseMapper.updateById(account);
        if (i > 0){
            resultUtils.setMessage("修改成功");
            resultUtils.setStatus(200);
        }else {
            resultUtils.setMessage("修改失败");
            resultUtils.setStatus(500);
        }
        return resultUtils;
    }

    /**
     * 登录
     *
     * @param account
     * @return
     */
    @Override
    public ResultUtils login(Account account) {
        ResultUtils resultUtils = new ResultUtils();
        String account1 = account.getAccount();
        List<Account> accounts = baseMapper.selectList(new QueryWrapper<Account>().eq("account", account1).eq("deleteState",2));
        List<Account> accounts1 = baseMapper.selectList(new QueryWrapper<Account>().eq("phone", account1).eq("deleteState",2));
        accounts.addAll(accounts1);
        if (accounts.size() > 0){
            Account account2 = accounts.get(0);
            if (account2.getEnableState() == 2){
                resultUtils.setStatus(500);
                resultUtils.setMessage("该账号已被禁用，请联系管理员");
                resultUtils.setCode(0);
                return resultUtils;
            }else {
                if (MD5.GetMD5Code(account.getPassword()).equals(account2.getPassword())){
                    //更新TOKREN
                    String s = account.getPassword() + System.currentTimeMillis();
                    String md5String = MD5.GetMD5Code(s);
                    account2.setToken(s);
                    int i = baseMapper.updateById(account2);
                    if (i > 0){
                        resultUtils.setStatus(200);
                        resultUtils.setMessage("登录成功");
                        resultUtils.setData(account2);
                        resultUtils.setCode(0);
                        return resultUtils;
                    }else {
                        resultUtils.setStatus(500);
                        resultUtils.setMessage("登录失败");
                        resultUtils.setCode(0);
                        return resultUtils;
                    }
                }else {
                    resultUtils.setStatus(500);
                    resultUtils.setMessage("账户名或密码错误");
                    resultUtils.setCode(0);
                    return resultUtils;
                }
            }
        }else {
            resultUtils.setStatus(500);
            resultUtils.setMessage("账户名或密码错误");
            resultUtils.setCode(0);
            return resultUtils;
        }
    }

    /**
     * 解锁
     *
     * @param account
     * @return
     */
    @Override
    public ResultUtils unLock(Account account) {
        ResultUtils resultUtils = new ResultUtils();
        Account account1 = baseMapper.selectById(account.getId());
        if (MD5.GetMD5Code(account.getPassword()).equals(account1.getPassword())){
            resultUtils.setMessage("解锁成功");
            resultUtils.setStatus(200);
        }else {
            resultUtils.setMessage("密码不正确");
            resultUtils.setStatus(500);
        }
        return resultUtils;
    }

    /**
     * 修改密码
     *
     * @param account
     */
    @Override
    public ResultUtils updatePwd(Account account) {
        ResultUtils resultUtils = new ResultUtils();
        Account account1 = baseMapper.selectById(account.getId());
        if (MD5.GetMD5Code(account.getOldPassword()).equals(account1.getPassword())){
            //旧密码正确
            account1.setPassword(MD5.GetMD5Code(account.getPassword()));
            //修改token  防止特殊方法进入后台
            account1.setToken("0");
            int i = baseMapper.updateById(account1);
            if (i > 0){
                resultUtils.setStatus(200);
                resultUtils.setMessage("密码修改成功");
            }else {
                resultUtils.setStatus(500);
                resultUtils.setMessage("密码修改失败");
            }
        }else {
            resultUtils.setStatus(500);
            resultUtils.setMessage("原始密码错误");
        }
        return resultUtils;
    }
}
