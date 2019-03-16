package cn.stylefeng.guns.modular.money.model;

/**
 * 微信小程序用户
 * */
public class WeixinUser {

    /**
     * 微信昵称
     * */
    private String nickName;

    /**
     * 性别 1：男 0：女
     */
    private Integer gender;

    /**
     * 语言
     * */
    private String language;

    /**
     * 城市
     * */
    private String city;

    /**
     * 省份
     * */
    private String province;

    /**
     * 头像url
     * */
    private String avatarUrl;

    /**
     * 国家
     * */
    private String country;

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
}
