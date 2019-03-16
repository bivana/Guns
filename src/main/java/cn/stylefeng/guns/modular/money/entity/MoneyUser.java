package cn.stylefeng.guns.modular.money.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("money_user")
public class MoneyUser implements Serializable {

    /**
     * 用户id
     * */
    @TableId(value = "user_id", type = IdType.ID_WORKER)
    private Long userId;

    @TableField("name")
    private String name;

    @JSONField(name="bonus_points")
    @TableField("bonus_points")
    private Double bonusPoints;

    @JSONField( name="avatar_url")
    @TableField( "avatar_url")
    private String avatarUrl;

    @JSONField( name="already_login")
    private Boolean alreadyLogin;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(Double bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Boolean getAlreadyLogin() {
        return alreadyLogin;
    }

    public void setAlreadyLogin(Boolean alreadyLogin) {
        this.alreadyLogin = alreadyLogin;
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
}
