package cn.stylefeng.guns.modular.cache;

import cn.stylefeng.guns.modular.money.factory.SessionFactory;
import cn.stylefeng.guns.modular.money.model.MoneyUserDto;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

public class MoneyUserCache {
    private static Cache<String,MoneyUserDto> cahce=CacheBuilder.newBuilder()
        //设置cache的初始大小为10，要合理设置该值  
        .initialCapacity(10)
        //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作  
        .concurrencyLevel(10)
        //设置cache中的数据在写入之后的存活时间为10天 
        .expireAfterAccess(10,TimeUnit.DAYS)
        //构建cache实例  
        .build();

    /**
     * 根据session获取user
     * */
    public static MoneyUserDto getUser(String session){
        return cahce.getIfPresent(session);
    }

    /**
     * 根据request获取user
     * */
    public static MoneyUserDto getUser(HttpServletRequest request){
        String session=SessionFactory.buildSession(request);
        return cahce.getIfPresent(session);
    }

    public static void setUser(String session,MoneyUserDto user){
        cahce.put(session,user);
    }
}
