package cn.stylefeng.guns.modular.money.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.ibatis.annotations.Options;

import java.util.Date;

/**
 * 微信小程序用户
 * */
@TableName("weixin_user")
public class WeixinUser {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 微信昵称
     * */
    @TableField("nick_name")
    private String nickName;

    /**
     * 性别 1：男 0：女
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 语言
     * */
    @TableField("language")
    private String language;

    /**
     * 城市
     * */
    @TableField("city")
    private String city;

    /**
     * 省份
     * */
    @TableField("province")
    private String province;

    /**
     * 头像url
     * */
    @TableField("avatar_url")
    private String avatarUrl;

    /**
     * 国家
     * */
    @TableField("country")
    private String country;
    /**
     * 状态
     * */
    @TableField("status")
    private String status;

    /**
     * 创建时间
     * */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     * */
    @TableField("modify_time")
    private Date modifyTime;

    /**
     * 乐观锁
     * */
    @TableField("version")
    private Long version;

    @TableField("weixin_key")
    private String weixinKey;

    /**
     * 记账用户id
     * */
    @TableField("money_user_id")
    private Long moneyUserId;

    public Long getMoneyUserId() {
        return moneyUserId;
    }

    public void setMoneyUserId(Long moneyUserId) {
        this.moneyUserId = moneyUserId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getWeixinKey() {
        return weixinKey;
    }

    public void setWeixinKey(String weixinKey) {
        this.weixinKey = weixinKey;
    }
}
