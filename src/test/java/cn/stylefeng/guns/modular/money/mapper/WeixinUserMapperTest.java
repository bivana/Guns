package cn.stylefeng.guns.modular.money.mapper;

import cn.stylefeng.guns.base.BaseJunit;
import cn.stylefeng.guns.modular.money.entity.WeixinUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class WeixinUserMapperTest extends BaseJunit {

    @Autowired
    private WeixinUserMapper weixinUserMapper;

    @Test
    public void insert() {
        WeixinUser weixinUser=new WeixinUser();
        weixinUser.setNickName("dsfsdfsd");
        weixinUserMapper.insert(weixinUser);
    }
}