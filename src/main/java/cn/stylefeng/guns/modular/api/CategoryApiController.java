package cn.stylefeng.guns.modular.api;

import cn.stylefeng.roses.core.base.controller.BaseController;
import com.alibaba.fastjson.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/statements")
public class StatementsApiController extends BaseController {
    /**
     * 首页上半部返回
     */
    @RequestMapping(value = "/category_frequent", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public Object index(HttpServletRequest request) {
        String appId=request.getHeader("X-WX-APP-ID");
        String weixinKey=request.getHeader("X-WX-Skey");
        JSONArray jsonArray=new JSONArray();
        return jsonArray;
    }
}
