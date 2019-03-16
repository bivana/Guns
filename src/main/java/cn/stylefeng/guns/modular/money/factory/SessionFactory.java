package cn.stylefeng.guns.modular.book.keeping.factory;

import cn.stylefeng.roses.core.util.MD5Util;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

public class SessionFactory {

    private static final String extra="bivana is genus";

    /**生成session*/
    public static String buildSession(String appId,String code){
        if(StringUtils.isEmpty(appId)||StringUtils.isEmpty(code)){
            return "";
        }
        String baseCode=appId+extra+code;
        return MD5Util.encrypt(Base64.getEncoder().encodeToString(baseCode.getBytes()));
    }

    /**生成session*/
    public static String buildSession(HttpServletRequest request){
        String code=request.getHeader("X-WX-Code");
        String appId=request.getHeader("X-WX-APP-ID");
        return buildSession(appId,code);
    }
}
