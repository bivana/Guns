package cn.stylefeng.guns.modular.money.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.util.List;

/**
 * 记账分类
 * */
@TableName("category")
public class Category {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类名称
     * */
    @TableField("name")
    private String name;

    /**
     * 图标地址
     */
    @TableField("icon_path")
    @JSONField(name = "icon_path")
    private String iconPath;

    /**
     * 类别：expand
     * */
    @TableField("type")
    private String type;

    /**
     * 父分类id
     * */
    @TableField("parent_id")
    @JSONField(name = "parent_id")
    private Long parentId;


    /**
     * 状态
     * */
    @TableField("status")
    private String status;

    /**
     * 创建时间
     * */
    @TableField("create_time")
    @JSONField(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     * */
    @JSONField(name = "modify_time")
    @TableField("modify_time")
    private Date modifyTime;

    /**
     * 乐观锁
     * */
    @TableField("version")
    private Long version;

    /**
     * 用户id
     * */
    @TableField("user_id")
    private Long userId;

    /**子分类*/
    @TableField(select = false)
    private List<Category> childs;

    public List<Category> getChilds() {
        return childs;
    }

    public void setChilds(List<Category> childs) {
        this.childs = childs;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
