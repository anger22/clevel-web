package com.qiqi.jiaoyou.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 平台参数设置
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@TableName("platform_parameter_setting")
public class PlatformParameterSetting extends Model<PlatformParameterSetting> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * app端启用页图片
     */
    private String launchPage;
    /**
     * login登陆背景图
     */
    private String loginImage;
    /**
     * 用户收到的礼物平台抽成比例
     */
    private BigDecimal drawInProportion;
    /**
     * 客服电话
     */
    private String telephone;
    /**
     * 设置一级分销返佣比例
     */
    private BigDecimal proportionOfReturnedServants;

    /**
     * 设置二级分佣比例
     */
    private BigDecimal proportionOfReturnedServantsTwo;
    /**
     * 设置通过他人分享注册的用户，自身提现比例提高XX%
     */
    private BigDecimal selfWithdrawal;
    /**
     * 发送礼物获得对应钻石价值比例的经验值数量
     */
    private BigDecimal giftExperienceRatio;
    /**
     * 发起赴约获得对应钻石价值比例的经验值数量
     */
    private BigDecimal proportionOfExperience;
    /**
     * 设置小喇叭单价
     */
    private Integer unitPriceOfLoudspeaker;
    /**
     * 设置银钻兑换金钻手续费比例
     */
    private BigDecimal exchangeRateOfGoldDiamond;
    /**
     * 设置银钻兑换黑钻手续费比例
     */
    private BigDecimal exchangeRateForBlackDiamonds;
    /**
     * 设置黑钻兑换余额比例
     */
    private BigDecimal proportionOfExchangeBalance;
    /**
     * 设置六个可兑换金钻的选项
     */
    private String sixGoldSize;
    /**
     * 设置六个可兑换黑钻的数量
     */
    private String sixBlackSize;
    /**
     * 设置每元钻石数
     */
    private Integer goldDiamondsPerYuan;
    /**
     * 版本号
     */
    private BigDecimal version;
    /**
     * 新版本描述
     */
    private String description;
    /**
     * ios下载地址
     */
    private String applePackageDownloadUrl;
    /**
     * android 下载地址
     */
    private String androidPackageDownloadUrl;

    private String appleVersion;


    private Integer faceSimilarity;

    private Integer memberUsageTime;

    @Override
    public String toString() {
        return "PlatformParameterSetting{" +
                "id=" + id +
                ", launchPage='" + launchPage + '\'' +
                ", loginImage='" + loginImage + '\'' +
                ", drawInProportion=" + drawInProportion +
                ", telephone='" + telephone + '\'' +
                ", proportionOfReturnedServants=" + proportionOfReturnedServants +
                ", proportionOfReturnedServantsTwo=" + proportionOfReturnedServantsTwo +
                ", selfWithdrawal=" + selfWithdrawal +
                ", giftExperienceRatio=" + giftExperienceRatio +
                ", proportionOfExperience=" + proportionOfExperience +
                ", unitPriceOfLoudspeaker=" + unitPriceOfLoudspeaker +
                ", exchangeRateOfGoldDiamond=" + exchangeRateOfGoldDiamond +
                ", exchangeRateForBlackDiamonds=" + exchangeRateForBlackDiamonds +
                ", proportionOfExchangeBalance=" + proportionOfExchangeBalance +
                ", sixGoldSize='" + sixGoldSize + '\'' +
                ", sixBlackSize='" + sixBlackSize + '\'' +
                ", goldDiamondsPerYuan=" + goldDiamondsPerYuan +
                ", version=" + version +
                ", description='" + description + '\'' +
                ", applePackageDownloadUrl='" + applePackageDownloadUrl + '\'' +
                ", androidPackageDownloadUrl='" + androidPackageDownloadUrl + '\'' +
                ", appleVersion='" + appleVersion + '\'' +
                ", faceSimilarity=" + faceSimilarity +
                ", memberUsageTime=" + memberUsageTime +
                ", worldSpeakGlod=" + worldSpeakGlod +
                '}';
    }

    public Integer getWorldSpeakGlod() {
        return worldSpeakGlod;
    }

    public void setWorldSpeakGlod(Integer worldSpeakGlod) {
        this.worldSpeakGlod = worldSpeakGlod;
    }

    /*在世界之窗发布消息需要的金钻数*/
    private Integer worldSpeakGlod;

    public String getAppleVersion() {
        return appleVersion;
    }

    public void setAppleVersion(String appleVersion) {
        this.appleVersion = appleVersion;
    }

    public Integer getMemberUsageTime() {
        return memberUsageTime;
    }

    public void setMemberUsageTime(Integer memberUsageTime) {
        this.memberUsageTime = memberUsageTime;
    }

    public Integer getGoldDiamondsPerYuan() {
        return goldDiamondsPerYuan;
    }

    public void setGoldDiamondsPerYuan(Integer goldDiamondsPerYuan) {
        this.goldDiamondsPerYuan = goldDiamondsPerYuan;
    }

    public Integer getId() {
        return id;
    }

    public PlatformParameterSetting setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLaunchPage() {
        return launchPage;
    }

    public PlatformParameterSetting setLaunchPage(String launchPage) {
        this.launchPage = launchPage;
        return this;
    }

    public BigDecimal getProportionOfReturnedServantsTwo() {
        return proportionOfReturnedServantsTwo;
    }

    public void setProportionOfReturnedServantsTwo(BigDecimal proportionOfReturnedServantsTwo) {
        this.proportionOfReturnedServantsTwo = proportionOfReturnedServantsTwo;
    }

    public BigDecimal getDrawInProportion() {
        return drawInProportion;
    }

    public PlatformParameterSetting setDrawInProportion(BigDecimal drawInProportion) {
        this.drawInProportion = drawInProportion;
        return this;
    }

    public String getLoginImage() {
        return loginImage;
    }

    public void setLoginImage(String loginImage) {
        this.loginImage = loginImage;
    }

    public String getTelephone() {
        return telephone;
    }

    public PlatformParameterSetting setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public BigDecimal getProportionOfReturnedServants() {
        return proportionOfReturnedServants;
    }

    public PlatformParameterSetting setProportionOfReturnedServants(BigDecimal proportionOfReturnedServants) {
        this.proportionOfReturnedServants = proportionOfReturnedServants;
        return this;
    }

    public BigDecimal getSelfWithdrawal() {
        return selfWithdrawal;
    }

    public PlatformParameterSetting setSelfWithdrawal(BigDecimal selfWithdrawal) {
        this.selfWithdrawal = selfWithdrawal;
        return this;
    }

    public BigDecimal getGiftExperienceRatio() {
        return giftExperienceRatio;
    }

    public PlatformParameterSetting setGiftExperienceRatio(BigDecimal giftExperienceRatio) {
        this.giftExperienceRatio = giftExperienceRatio;
        return this;
    }

    public BigDecimal getProportionOfExperience() {
        return proportionOfExperience;
    }

    public PlatformParameterSetting setProportionOfExperience(BigDecimal proportionOfExperience) {
        this.proportionOfExperience = proportionOfExperience;
        return this;
    }

    public Integer getUnitPriceOfLoudspeaker() {
        return unitPriceOfLoudspeaker;
    }

    public PlatformParameterSetting setUnitPriceOfLoudspeaker(Integer unitPriceOfLoudspeaker) {
        this.unitPriceOfLoudspeaker = unitPriceOfLoudspeaker;
        return this;
    }

    public BigDecimal getExchangeRateOfGoldDiamond() {
        return exchangeRateOfGoldDiamond;
    }

    public PlatformParameterSetting setExchangeRateOfGoldDiamond(BigDecimal exchangeRateOfGoldDiamond) {
        this.exchangeRateOfGoldDiamond = exchangeRateOfGoldDiamond;
        return this;
    }

    public BigDecimal getExchangeRateForBlackDiamonds() {
        return exchangeRateForBlackDiamonds;
    }

    public PlatformParameterSetting setExchangeRateForBlackDiamonds(BigDecimal exchangeRateForBlackDiamonds) {
        this.exchangeRateForBlackDiamonds = exchangeRateForBlackDiamonds;
        return this;
    }


    public BigDecimal getProportionOfExchangeBalance() {
        return proportionOfExchangeBalance;
    }

    public PlatformParameterSetting setProportionOfExchangeBalance(BigDecimal proportionOfExchangeBalance) {
        this.proportionOfExchangeBalance = proportionOfExchangeBalance;
        return this;
    }

    public String getSixGoldSize() {
        return sixGoldSize;
    }

    public PlatformParameterSetting setSixGoldSize(String sixGoldSize) {
        this.sixGoldSize = sixGoldSize;
        return this;
    }

    public String getSixBlackSize() {
        return sixBlackSize;
    }

    public PlatformParameterSetting setSixBlackSize(String sixBlackSize) {
        this.sixBlackSize = sixBlackSize;
        return this;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplePackageDownloadUrl() {
        return applePackageDownloadUrl;
    }

    public void setApplePackageDownloadUrl(String applePackageDownloadUrl) {
        this.applePackageDownloadUrl = applePackageDownloadUrl;
    }

    public String getAndroidPackageDownloadUrl() {
        return androidPackageDownloadUrl;
    }

    public void setAndroidPackageDownloadUrl(String androidPackageDownloadUrl) {
        this.androidPackageDownloadUrl = androidPackageDownloadUrl;
    }


    public Integer getFaceSimilarity() {
        return faceSimilarity;
    }

    public void setFaceSimilarity(Integer faceSimilarity) {
        this.faceSimilarity = faceSimilarity;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
