package com.qiqi.jiaoyou.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Lable extends Model<Lable> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "label_id", type = IdType.AUTO)
    private Integer labelId;
    /**
     * 会员ID
     */
    @TableField("member_id")
    private Integer memberId;
    /**
     * 魅力默认
     */
    @TableField("label_charm_default")
    private String labelCharmDefault;
    /**
     * 魅力选中
     */
    @TableField("label_charm_select")
    private String labelCharmSelect;
    /**
     * 城市默认
     */
    @TableField("label_city_default")
    private String labelCityDefault;
    /**
     * 城市选中
     */
    @TableField("label_city_select")
    private String labelCitySelect;
    /**
     * 地方默认
     */
    @TableField("label_local_default")
    private String labelLocalDefault;
    /**
     * 地方选中
     */
    @TableField("label_local_select")
    private String labelLocalSelect;
    /**
     * 爱好默认
     */
    @TableField("label_hobby_default")
    private String labelHobbyDefault;
    /**
     * 爱好选中
     */
    @TableField("label_hobby_select")
    private String labelHobbySelect;
    /**
     * 学历默认
     */
    @TableField("label_education_default")
    private String labelEducationDefault;
    /**
     * 学历选中
     */
    @TableField("label_education_select")
    private String labelEducationSelect;
    /**
     * 状态默认
     */
    @TableField("lable_state_default")
    private String lableStateDefault;
    /**
     * 状态选中
     */
    @TableField("lable_state_select")
    private String lableStateSelect;
    /**
     * 年收入默认
     */
    @TableField("lable_annual_income_default")
    private String lableAnnualIncomeDefault;
    /**
     * 年收入选中
     */
    @TableField("lable_annual_income_select")
    private String lableAnnualIncomeSelect;
    /**
     * 车辆默认
     */
    @TableField("lable_car_size_default")
    private String lableCarSizeDefault;
    /**
     * 车辆选中
     */
    @TableField("lable_car_size_select")
    private String lableCarSizeSelect;
    /**
     * 形象默认
     */
    @TableField("lable_image_default")
    private String lableImageDefault;
    /**
     * 形象选中
     */
    @TableField("lable_image_select")
    private String lableImageSelect;
    /**
     * 性格默认
     */
    @TableField("lable_character_default")
    private String lableCharacterDefault;
    /**
     * 性格选中
     */
    @TableField("lable_character_select")
    private String lableCharacterSelect;
    /**
     * 行业默认
     */
    @TableField("lable_industry_default")
    private String lableIndustryDefault;
    /**
     * 行业选中
     */
    @TableField("lable_industry_select")
    private String lableIndustrySelect;
    /**
     * 身高
     */
    @TableField("lable_height")
    private String lableHeight;
    /**
     * 体重
     */
    @TableField("lable_weight")
    private String lableWeight;
    /**
     * 喝酒实力
     */
    @TableField("lable_drinking_power")
    private String lableDrinkingPower;
    /**
     * 我的宠物
     */
    @TableField("lable_pets")
    private String lablePets;
    /**
     * 自我介绍
     */
    @TableField("lable_introduce")
    private String lableIntroduce;
    /**
     * 抽烟习惯
     */
    @TableField("lable_smoking_status")
    private String lableSmokingStatus;
    /**
     * 职业
     */
    @TableField("lable_occupation")
    private String lableOccupation;


    public Integer getLabelId() {
        return labelId;
    }

    public Lable setLabelId(Integer labelId) {
        this.labelId = labelId;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Lable setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getLabelCharmDefault() {
        return labelCharmDefault;
    }

    public Lable setLabelCharmDefault(String labelCharmDefault) {
        this.labelCharmDefault = labelCharmDefault;
        return this;
    }

    public String getLabelCharmSelect() {
        return labelCharmSelect;
    }

    public Lable setLabelCharmSelect(String labelCharmSelect) {
        this.labelCharmSelect = labelCharmSelect;
        return this;
    }

    public String getLabelCityDefault() {
        return labelCityDefault;
    }

    public Lable setLabelCityDefault(String labelCityDefault) {
        this.labelCityDefault = labelCityDefault;
        return this;
    }

    public String getLabelCitySelect() {
        return labelCitySelect;
    }

    public Lable setLabelCitySelect(String labelCitySelect) {
        this.labelCitySelect = labelCitySelect;
        return this;
    }

    public String getLabelLocalDefault() {
        return labelLocalDefault;
    }

    public Lable setLabelLocalDefault(String labelLocalDefault) {
        this.labelLocalDefault = labelLocalDefault;
        return this;
    }

    public String getLabelLocalSelect() {
        return labelLocalSelect;
    }

    public Lable setLabelLocalSelect(String labelLocalSelect) {
        this.labelLocalSelect = labelLocalSelect;
        return this;
    }

    public String getLabelHobbyDefault() {
        return labelHobbyDefault;
    }

    public Lable setLabelHobbyDefault(String labelHobbyDefault) {
        this.labelHobbyDefault = labelHobbyDefault;
        return this;
    }

    public String getLabelHobbySelect() {
        return labelHobbySelect;
    }

    public Lable setLabelHobbySelect(String labelHobbySelect) {
        this.labelHobbySelect = labelHobbySelect;
        return this;
    }

    public String getLabelEducationDefault() {
        return labelEducationDefault;
    }

    public Lable setLabelEducationDefault(String labelEducationDefault) {
        this.labelEducationDefault = labelEducationDefault;
        return this;
    }

    public String getLabelEducationSelect() {
        return labelEducationSelect;
    }

    public Lable setLabelEducationSelect(String labelEducationSelect) {
        this.labelEducationSelect = labelEducationSelect;
        return this;
    }

    public String getLableStateDefault() {
        return lableStateDefault;
    }

    public Lable setLableStateDefault(String lableStateDefault) {
        this.lableStateDefault = lableStateDefault;
        return this;
    }

    public String getLableStateSelect() {
        return lableStateSelect;
    }

    public Lable setLableStateSelect(String lableStateSelect) {
        this.lableStateSelect = lableStateSelect;
        return this;
    }

    public String getLableAnnualIncomeDefault() {
        return lableAnnualIncomeDefault;
    }

    public Lable setLableAnnualIncomeDefault(String lableAnnualIncomeDefault) {
        this.lableAnnualIncomeDefault = lableAnnualIncomeDefault;
        return this;
    }

    public String getLableAnnualIncomeSelect() {
        return lableAnnualIncomeSelect;
    }

    public Lable setLableAnnualIncomeSelect(String lableAnnualIncomeSelect) {
        this.lableAnnualIncomeSelect = lableAnnualIncomeSelect;
        return this;
    }

    public String getLableCarSizeDefault() {
        return lableCarSizeDefault;
    }

    public Lable setLableCarSizeDefault(String lableCarSizeDefault) {
        this.lableCarSizeDefault = lableCarSizeDefault;
        return this;
    }

    public String getLableCarSizeSelect() {
        return lableCarSizeSelect;
    }

    public Lable setLableCarSizeSelect(String lableCarSizeSelect) {
        this.lableCarSizeSelect = lableCarSizeSelect;
        return this;
    }

    public String getLableImageDefault() {
        return lableImageDefault;
    }

    public Lable setLableImageDefault(String lableImageDefault) {
        this.lableImageDefault = lableImageDefault;
        return this;
    }

    public String getLableImageSelect() {
        return lableImageSelect;
    }

    public Lable setLableImageSelect(String lableImageSelect) {
        this.lableImageSelect = lableImageSelect;
        return this;
    }

    public String getLableCharacterDefault() {
        return lableCharacterDefault;
    }

    public Lable setLableCharacterDefault(String lableCharacterDefault) {
        this.lableCharacterDefault = lableCharacterDefault;
        return this;
    }

    public String getLableCharacterSelect() {
        return lableCharacterSelect;
    }

    public Lable setLableCharacterSelect(String lableCharacterSelect) {
        this.lableCharacterSelect = lableCharacterSelect;
        return this;
    }

    public String getLableIndustryDefault() {
        return lableIndustryDefault;
    }

    public Lable setLableIndustryDefault(String lableIndustryDefault) {
        this.lableIndustryDefault = lableIndustryDefault;
        return this;
    }

    public String getLableIndustrySelect() {
        return lableIndustrySelect;
    }

    public Lable setLableIndustrySelect(String lableIndustrySelect) {
        this.lableIndustrySelect = lableIndustrySelect;
        return this;
    }

    public String getLableHeight() {
        return lableHeight;
    }

    public Lable setLableHeight(String lableHeight) {
        this.lableHeight = lableHeight;
        return this;
    }

    public String getLableWeight() {
        return lableWeight;
    }

    public Lable setLableWeight(String lableWeight) {
        this.lableWeight = lableWeight;
        return this;
    }

    public String getLableDrinkingPower() {
        return lableDrinkingPower;
    }

    public Lable setLableDrinkingPower(String lableDrinkingPower) {
        this.lableDrinkingPower = lableDrinkingPower;
        return this;
    }

    public String getLablePets() {
        return lablePets;
    }

    public Lable setLablePets(String lablePets) {
        this.lablePets = lablePets;
        return this;
    }

    public String getLableIntroduce() {
        return lableIntroduce;
    }

    public Lable setLableIntroduce(String lableIntroduce) {
        this.lableIntroduce = lableIntroduce;
        return this;
    }

    public String getLableSmokingStatus() {
        return lableSmokingStatus;
    }

    public Lable setLableSmokingStatus(String lableSmokingStatus) {
        this.lableSmokingStatus = lableSmokingStatus;
        return this;
    }

    public String getLableOccupation() {
        return lableOccupation;
    }

    public Lable setLableOccupation(String lableOccupation) {
        this.lableOccupation = lableOccupation;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.labelId;
    }

    @Override
    public String toString() {
        return "Lable{" +
        "labelId=" + labelId +
        ", memberId=" + memberId +
        ", labelCharmDefault=" + labelCharmDefault +
        ", labelCharmSelect=" + labelCharmSelect +
        ", labelCityDefault=" + labelCityDefault +
        ", labelCitySelect=" + labelCitySelect +
        ", labelLocalDefault=" + labelLocalDefault +
        ", labelLocalSelect=" + labelLocalSelect +
        ", labelHobbyDefault=" + labelHobbyDefault +
        ", labelHobbySelect=" + labelHobbySelect +
        ", labelEducationDefault=" + labelEducationDefault +
        ", labelEducationSelect=" + labelEducationSelect +
        ", lableStateDefault=" + lableStateDefault +
        ", lableStateSelect=" + lableStateSelect +
        ", lableAnnualIncomeDefault=" + lableAnnualIncomeDefault +
        ", lableAnnualIncomeSelect=" + lableAnnualIncomeSelect +
        ", lableCarSizeDefault=" + lableCarSizeDefault +
        ", lableCarSizeSelect=" + lableCarSizeSelect +
        ", lableImageDefault=" + lableImageDefault +
        ", lableImageSelect=" + lableImageSelect +
        ", lableCharacterDefault=" + lableCharacterDefault +
        ", lableCharacterSelect=" + lableCharacterSelect +
        ", lableIndustryDefault=" + lableIndustryDefault +
        ", lableIndustrySelect=" + lableIndustrySelect +
        ", lableHeight=" + lableHeight +
        ", lableWeight=" + lableWeight +
        ", lableDrinkingPower=" + lableDrinkingPower +
        ", lablePets=" + lablePets +
        ", lableIntroduce=" + lableIntroduce +
        ", lableSmokingStatus=" + lableSmokingStatus +
        ", lableOccupation=" + lableOccupation +
        "}";
    }
}
