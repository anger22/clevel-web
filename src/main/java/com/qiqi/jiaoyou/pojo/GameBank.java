package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 答题游戏题库(GameBank)表实体类
 *
 * @author makejava
 * @since 2020-11-27 11:12:49
 */

@TableName("game_bank")
public class GameBank extends Model<GameBank> {

	private static final long serialVersionUID = 1L;
	 @TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	//题干（内容）
	@TableField("game_stem")
	private String gameStem;
	//选项游戏选项标签表的id（答题游戏视频或者其他）
	@TableField("game_select_id")
	private String gameSelectId;
	//正确答案
	@TableField("true_answer")
	private String trueAnswer;
	//排序值
	@TableField("game_sort")
	private String gameSort;
	//答题游戏标题

	@TableField("game_title")
	private String gameTitle;
	//标题图标
	@TableField("game_title_icon")
	private String gameTitleIcon;
	//创建时间

	@TableField("create_time")
	private Date createTime;
	//更新时间
	@TableField("update_time")
	private Date updateTime;

	@Override
	public String toString() {
		return "GameBank{" +
				"id=" + id +
				", gameStem='" + gameStem + '\'' +
				", gameSelectId='" + gameSelectId + '\'' +
				", trueAnswer='" + trueAnswer + '\'' +
				", gameSort='" + gameSort + '\'' +
				", gameTitle='" + gameTitle + '\'' +
				", gameTitleIcon='" + gameTitleIcon + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", gameSelectText='" + gameSelectText + '\'' +
				'}';
	}

	public String getGameSelectText() {
		return gameSelectText;
	}

	public void setGameSelectText(String gameSelectText) {
		this.gameSelectText = gameSelectText;
	}

	public String getGameSelectTitle() {
		return gameSelectText;
	}

	public void setGameSelectTitle(String gameSelectTitle) {
		this.gameSelectText = gameSelectTitle;
	}

	@TableField(exist = false)
	private String gameSelectText;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGameStem() {
		return gameStem;
	}

	public void setGameStem(String gameStem) {
		this.gameStem = gameStem;
	}

	public String getGameSelectId() {
		return gameSelectId;
	}

	public void setGameSelectId(String gameSelectId) {
		this.gameSelectId = gameSelectId;
	}

	public String getTrueAnswer() {
		return trueAnswer;
	}

	public void setTrueAnswer(String trueAnswer) {
		this.trueAnswer = trueAnswer;
	}

	public String getGameSort() {
		return gameSort;
	}

	public void setGameSort(String gameSort) {
		this.gameSort = gameSort;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public String getGameTitleIcon() {
		return gameTitleIcon;
	}

	public void setGameTitleIcon(String gameTitleIcon) {
		this.gameTitleIcon = gameTitleIcon;
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