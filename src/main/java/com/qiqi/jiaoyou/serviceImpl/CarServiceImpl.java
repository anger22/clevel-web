package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.CarCopyDao;
import com.qiqi.jiaoyou.mapper.CarMapper;
import com.qiqi.jiaoyou.mapper.MemberMapper;
import com.qiqi.jiaoyou.pojo.Car;
import com.qiqi.jiaoyou.pojo.Member;
import com.qiqi.jiaoyou.service.CarCopyService;
import com.qiqi.jiaoyou.service.ICarService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 车辆表 服务实现类 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService
{

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private CarCopyDao carCopyDao;
	@Autowired
	private CarCopyService carCopyService;

	/**
	 * 修改日期 202013223
	 * author:nan
	 * 因为。。。。
	 * 查询的时候，查询附表
	 * 审核通过（不通过没有这个操作）的时候，需要把附表的数据移动到主表，删除状态改为未删除，已通过状态
	 * 删除的时候，直接删除附表数据，不是状态删除
	 */
	@Override
	public ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map)
	{
		ResultUtils resultUtils = new ResultUtils();

		IPage<Car> wherePage = new Page<>(page, limit);
		QueryWrapper<Car> wrapper = Wrappers.query();

		if (!map.isEmpty())
		{
			for (String key : map.keySet())
			{
				wrapper.like(key != null && !key.equals(""), key, map.get(key));
			}
		}
		wrapper.orderByDesc("id");

//        IPage<Car> list =   baseMapper.selectPage(wherePage, wrapper);
		/*IPage<CarCopy> wherePage = new Page<>(page, limit);
		QueryWrapper<CarCopy> wrapper = Wrappers.query();
		if (!map.isEmpty())
		{
			for (String key : map.keySet())
			{
				wrapper.like(key != null && !key.equals(""), key, map.get(key));
			}
		}
		*/

		wrapper.eq("deledeState", 2);
		wrapper.orderByDesc("addTime");
		IPage<Car> list = baseMapper.selectPage(wherePage, wrapper);

		System.out.println(list.getRecords());
		resultUtils.setData(list.getRecords());
		resultUtils.setMessage("查询成功");
		resultUtils.setStatus(200);
		resultUtils.setCode(0);
		resultUtils.setCount((int) list.getTotal());
		return resultUtils;
	}

	@Override
	public ResultUtils add(Car car)
	{
		ResultUtils resultUtils = new ResultUtils();
		Integer i = baseMapper.insert(car);
		if (i > 0)
		{
			resultUtils.setStatus(200);
			resultUtils.setMessage("添加成功");
		}
		else
		{
			resultUtils.setStatus(200);
			resultUtils.setMessage("添加失败");
		}
		return resultUtils;
	}

	@Override
	public ResultUtils delete(Long id)
	{
		ResultUtils resultUtils = new ResultUtils();
		Integer i = baseMapper.deleteById(id);
		if (i > 0)
		{
			resultUtils.setStatus(200);
			resultUtils.setMessage("编辑成功");
		}
		else
		{
			resultUtils.setStatus(200);
			resultUtils.setMessage("编辑失败");
		}
		return resultUtils;
	}

	/*更新车辆审核的状态值，用户审核通过*/
	@Override
	public ResultUtils updateData(Car car)
	{
		ResultUtils resultUtils = new ResultUtils();
		resultUtils.setStatus(200);
		resultUtils.setMessage("编辑成功");


		//审核不通过的流程
		Car car1 = baseMapper.selectById(car.getId());
		String carLable = car.getCarLable();
		Integer memberId = car1.getMemberId();
		Member member = new Member();
		member.setId(memberId);
		member.setCarLable(carLable);
		int i1 = memberMapper.updateById(member);
		int i = baseMapper.updateById(car);
		if (i > 0)
			return resultUtils;
		resultUtils.setStatus(200);
		resultUtils.setMessage("编辑失败");
		return resultUtils;

		//首先，判断管理员是不是通过了这个信息的审核，通过的话执行通过逻辑。不通过的话直接更新状态，不做其他操作
		//1:待審核  2：審核通過 3：審核未通過
		// if (car.getAuditState() == 3)
		// {
//            Car car1 = baseMapper.selectById(car.getId()) ;
//            car1.setCarLable(car.getCarLable());
//            car.setAuditState(car.getAuditState());
//            car.setReason(car.getReason());
//
//            Integer i =  baseMapper.updateById(car);

		// CarCopy car1 = carCopyDao.selectById(car.getId());
//            car1.setCarLable(car.getCarLable());
// 			car1.setAuditState(3);
// 			car1.setReason(car.getReason());
// 			Integer i = carCopyDao.updateById(car1);

		// 	if (i > 0)
		// 	{
		// 		String carLable = car.getCarLable();
		// 		Integer memberId = car1.getMemberId();
		// 		Member member = new Member();
		// 		member.setId(memberId);
		// 		member.setCarLable(carLable);
		// 		int i1 = memberMapper.updateById(member);
		// 		if (i1 <= 0)
		// 		{
		// 			resultUtils.setStatus(200);
		// 			resultUtils.setMessage("编辑失败");
		// 			return resultUtils;
		// 		}
		// 		resultUtils.setStatus(200);
		// 		resultUtils.setMessage("编辑成功");
		// 	}
		// 	else
		// 	{
		// 		resultUtils.setStatus(200);
		// 		resultUtils.setMessage("编辑失败");
		// 	}
		// }
		//审核通过的流程
		/*if (car.getAuditState() == 2)
		{

			//首先更新附表的数据，更新成功之后，附表的这条数据更新主表的那条数据，主表数据更新成功之后，删除附表的这条数据
			CarCopy carCopy = carCopyDao.selectById(car.getId());
			carCopy.setAuditState(2);
			carCopy.setDeledeState(2);
			carCopy.setReason(car.getReason());
			int ia = carCopyDao.updateById(carCopy);
			//状态更新成功之后
			if (ia > 0)
			{
				//获取附表的更新后的数据
				CarCopy carCopy1 = carCopyDao.selectById(car.getId());
				//获取主表的这条数据
				Car car2 = baseMapper.selectById(car.getId());
				car2.setAuditState(carCopy1.getAuditState());
				car2.setDeledeState(carCopy1.getDeledeState());
				car2.setReason(carCopy1.getReason());

				int iws = baseMapper.updateById(car2);
				if (iws > 0)
				{
					int isw = carCopyDao.deleteById(car.getId());
					if (isw > 0)
					{
						resultUtils.setStatus(200);
						resultUtils.setMessage("编辑成功");
						return resultUtils;
					}
					else
					{
						resultUtils.setStatus(200);
						resultUtils.setMessage("编辑失败");
						return resultUtils;
					}
				}
				else
				{
					resultUtils.setStatus(200);
					resultUtils.setMessage("编辑失败");
					return resultUtils;
				}
			}

		}*/
	}

	@Override
	public ResultUtils findById(Long id)
	{
		ResultUtils resultUtils = new ResultUtils();
		Car obj = baseMapper.selectById(id);
		resultUtils.setData(obj);
		resultUtils.setStatus(200);
		resultUtils.setMessage("查询成功");
		return resultUtils;
	}
}
