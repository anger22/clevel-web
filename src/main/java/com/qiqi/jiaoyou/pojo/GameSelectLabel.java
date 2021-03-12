package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 答题游戏库选项标签(GameSelectLabel)表实体类
 *
 * @author makejava
 * @since 2020-11-27 11:25:35
 */

@TableName("game_select_label")
public class GameSelectLabel extends Model<GameSelectLabel> {

	private static final long serialVersionUID = 1L;
@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	//选项标题
	@TableField("game_select_title")
	private String gameSelectTitle;
	//排序值
	//创建时间
	@TableField("game_select_sort")
	private Integer gameSelectSort;

	@Override
	public String toString() {
		return "GameSelectLabel{" +
				"id=" + id +
				", gameSelectTitle='" + gameSelectTitle + '\'' +
				", gameSelectSort=" + gameSelectSort +
				", gameSelectTitleIcon='" + gameSelectTitleIcon + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}

	public String getGameSelectTitleIcon() {
		return gameSelectTitleIcon;
	}

	public void setGameSelectTitleIcon(String gameSelectTitleIcon) {
		this.gameSelectTitleIcon = gameSelectTitleIcon;
	}

	@TableField("game_select_title_icon")
	private String gameSelectTitleIcon;
	@TableField("create_time")
	private Date createTime;
	//更新时间
	@TableField("update_time")
	private Date updateTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGameSelectTitle() {
		return gameSelectTitle;
	}

	public void setGameSelectTitle(String gameSelectTitle) {
		this.gameSelectTitle = gameSelectTitle;
	}

	public Integer getGameSelectSort() {
		return gameSelectSort;
	}

	public void setGameSelectSort(Integer gameSelectSort) {
		this.gameSelectSort = gameSelectSort;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取主键值
	 *
	 * @return 主键值
	 */
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}