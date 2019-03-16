package cn.stylefeng.guns.modular.cache;

import cn.stylefeng.guns.modular.book.keeping.model.User;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class BookKeepingUserCache {
    private static Cache<String,User> cahce=CacheBuilder.newBuilder()
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
    public static User getUser(String session){
        return cahce.getIfPresent(session);
    }

    public static void setUser(String session,User user){
        cahce.put(session,user);
    }
}
