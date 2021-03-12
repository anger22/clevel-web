package com.qiqi.jiaoyou.serviceImpl;

import com.qiqi.jiaoyou.pojo.Menu;
import com.qiqi.jiaoyou.mapper.MenuMapper;
import com.qiqi.jiaoyou.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qiqi.jiaoyou.util.ResultUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map){
        ResultUtils resultUtils = new ResultUtils();
        IPage<Menu> wherePage = new Page<>(page, limit);
        QueryWrapper<Menu> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            if (key.equals("f_weight")){
                wrapper.eq("f_weight",map.get("f_weight"));
                continue;
            }
            wrapper.like(key,map.get(key));
        }
            wrapper.orderByDesc("f_id");

        IPage<Menu> list =   baseMapper.selectPage(wherePage, wrapper);
        resultUtils.setData(list.getRecords());
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
    }

    @Override
    public ResultUtils add(Menu menu){
        ResultUtils resultUtils = new ResultUtils();
        Integer i =  baseMapper.insert(menu);
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
        Integer i =  baseMapper.deleteById(id);
        if(i > 0){
            resultUtils.setStatus(200);
            resultUtils.setMessage("删除成功");
        }else{
            resultUtils.setStatus(200);
            resultUtils.setMessage("删除失败");
        }
        return resultUtils;
    }

    @Override
    public ResultUtils updateData(Menu menu){
        ResultUtils resultUtils = new ResultUtils();
        System.out.println(menu.toString());
        Integer i =  baseMapper.updateById(menu);
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
        Menu obj = baseMapper.selectById(id);
        resultUtils.setData(obj);
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        return resultUtils;
    }

    /**
     * 查询所有一级菜单
     *
     * @return
     */
    @Override
    public ResultUtils selectLevelIsOne() {
        ResultUtils resultUtils = new ResultUtils();
        QueryWrapper<Menu> wrapper = Wrappers.query();
        wrapper.eq("f_clasid",1);
        List<Menu> menus = baseMapper.selectList(wrapper);
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setData(menus);
        return resultUtils;
    }

    /**
     * 根据一级菜单 查询二级菜单
     *
     * @param id
     * @return
     */
    @Override
    public ResultUtils selectLevelIsTwo(Long id) {
        ResultUtils resultUtils = new ResultUtils();
        QueryWrapper<Menu> wrapper = Wrappers.query();
        wrapper.eq("f_clasid",2);
        wrapper.eq("f_oid",id);
        List<Menu> menus = baseMapper.selectList(wrapper);
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setData(menus);
        return resultUtils;
    }

    /**
     * 查询所有一及以及二级
     *
     * @return
     */
    @Override
    public ResultUtils selectLevelIsOneAndTwo() {
        ResultUtils resultUtils = new ResultUtils();
        QueryWrapper<Menu> wrapper = Wrappers.query();
        wrapper.eq("f_clasid",1);
        List<Menu> menus = baseMapper.selectList(wrapper);
        //查询二级
        for (Menu menu : menus){
            QueryWrapper<Menu> wrapper1 = Wrappers.query();
            wrapper1.eq("f_clasid",2);
            wrapper1.eq("f_oid",menu.getfId());
            List<Menu> menus1 = baseMapper.selectList(wrapper1);
            for (Menu menu1 : menus1){
                QueryWrapper<Menu> wrapper2 = Wrappers.query();
                wrapper2.eq("f_clasid",3);
                wrapper2.eq("f_tid",menu1.getfId());
                List<Menu> menus2 = baseMapper.selectList(wrapper2);
                menu1.setList(menus2);
            }
            menu.setList(menus1);
        }
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setData(menus);
        return resultUtils;
    }
}
