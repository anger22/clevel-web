package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * app会员表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@Data
@TableName("member")
public class Member extends Model<Member>
{

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 你猜怎么着，我并不打算写注释
	 */
	@TableField(exist = false)
	private Boolean userYes = false;

	/**
	 * 头像
	 */
	private String head;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 性别 1：男2：女
	 */
	private Integer sex;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 身份证号
	 */
	private String IDNumber;
	/**
	 * 所在省
	 */
	private String province;
	/**
	 * 所在市
	 */
	private String city;
	/**
	 * 所在区
	 */
	private String area;
	/**
	 * 注册时间
	 */
	private Date addTime;
	/**
	 * 1:是vip  2：不是vip
	 */
	private Integer isvip;
	/**
	 * 会员到期时间
	 */
	private Date memberExpirationDate;
	/**
	 * 启用状态 1：启用2：禁用
	 */
	private Integer enableSate;
	/**
	 * 人脸拍照照片
	 */
	private String facePhoto;
	/**
	 * 身份证正面照片
	 */
	private String positivePhotoOfIDCard;
	/**
	 * 用户等级
	 */
	private Integer level;
	/**
	 * 邀请码
	 */
	private String invitationCode;
	/**
	 * 1:审核通过 2：审核未过 3：审核中
	 */
	private Integer examineState;
	/**
	 * 1:颜值注册  2：车友注册
	 */
	private Integer registrationChannel;
	/**
	 * 原因
	 */
	private String reason;
	/**
	 * token
	 */
	private String token;

	private String todayLoginTime;


	/**
	 * 登录次数
	 */
	private Integer loginSize;


	//    private String nickName;
	//身份证号
//    private String IDNumber;
	//注册时间
//    private Date addTime;
	//会员到期时间
//    private Date memberExpirationDate;
	//启用状态 1：启用2：禁用
//    private Integer enableSate;
	//父级id
	private Integer pid;
	//直推人数
	private Integer recommended;
	//人脸拍照照片
//    private String facePhoto;
	//身份证正面照片
//    private String positivePhotoOfIDCard;
	//邀请码
//    private String invitationCode;
	//1:审核通过 2：审核未过 3：审核中
//    private Integer examineState;
	//1:颜值注册  2：车友注册3：黑卡注册
//    private Integer registrationChannel;
	//登录次数
//    private Integer loginSize;
	//背景图
	@TableField("backgroundImages")
	private String backgroundImages;
	//推送ID
	private String pushId;
	//车标图片
	private String carLable;
	//是否是客服  1是 2不是
	private Integer isCustomer;
	//经度
	private String longitude;
	//纬度
	private String latitude;
	//第一次登陆时间
	private Date loginTimeofOne;
	//最近一次的登录时间
//    private Date todayLoginTime;

	private Integer numberOfRemainingFriendsToAdd;


	//视频
	private String video;

	private Long activitySize;
	//删除状态 0:未删除，1：删除
	private String delUserStatus;
	//行驶证照片
	private String drivingLicensePhoto;
	//注册机型  1：苹果 2：安卓
	private Integer registrationModel;
	//车辆型号
	private String carModel;
	//0:不在线1：在线
	private String onLine;

	@TableField(exist = false)
	private Car car;

	@TableField(exist = false)
	private MemberAssets memberAssets;


}
