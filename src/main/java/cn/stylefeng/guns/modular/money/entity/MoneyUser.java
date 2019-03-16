package cn.stylefeng.guns.modular.money.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class MoneyUser {

    /**
     * 用户id
     * */
    private Long userId;
    
    private String name;

    @JSONField(name = "bonus_points")
    private Double bonusPoints;

    @JSONField(name = "avatar_url")
    private String avatarUrl;

    @JSONField(name = "already_login")
    private Boolean alreadyLogin;

    /**
     * 状态
     * */
    private String status;

    /**
     * 创建时间
     * */
    private Date createTime;

    /**
     * 更新时间
     * */
    private Date modifyTime;

    /**
     * 乐观锁
     * */
    private Long version;
}
