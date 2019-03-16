/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.stylefeng.guns.modular.api;

import cn.stylefeng.guns.modular.money.entity.MoneyUser;
import cn.stylefeng.guns.modular.money.factory.SessionFactory;
import cn.stylefeng.guns.modular.money.model.MoneyUserDto;
import cn.stylefeng.guns.modular.cache.MoneyUserCache;
import cn.stylefeng.guns.modular.money.entity.WeixinUser;
import cn.stylefeng.guns.modular.money.service.MoneyUserService;
import cn.stylefeng.guns.modular.money.service.WeixinUserService;
import cn.stylefeng.guns.modular.system.mapper.UserMapper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.reqres.response.SuccessResponseData;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * 接口控制器提供
 *
 * @author stylefeng
 * @Date 2018/7/20 23:39
 */
@RestController
@RequestMapping("/api")
public class ApiController extends BaseController {


    @Autowired
    private MoneyUserService moneyUserService;

    @Autowired
    private WeixinUserService weixinUserService;

    private static final String extra="bivana is genus";

    /**
     * 用户设置借口
     */
    @RequestMapping(value = "/settings", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object settings(HttpServletRequest request) {
        String session=SessionFactory.buildSession(request);
        MoneyUserDto moneyUserDto=MoneyUserCache.getUser(session);
        String weixinKey=request.getHeader("X-WX-Skey");
        //如果缓存中不存在，从数据库中查询
        if(moneyUserDto==null){
            MoneyUser moneyUser=moneyUserService.getByWeixinKey(weixinKey);
            moneyUserDto=new MoneyUserDto();
            BeanUtils.copyProperties(moneyUser,moneyUserDto);
            moneyUserDto.setAlreadyLogin(true);
            MoneyUserCache.setUser(session,moneyUserDto);
        }else{
            moneyUserDto=new MoneyUserDto();
            moneyUserDto.setAlreadyLogin(false);
            moneyUserDto.setName("访客");
            moneyUserDto.setAvatarUrl("../public/images/no_login_avatar.png");
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("user",moneyUserDto);
        jsonObject.put("versin",moneyUserDto.getVersion());
        return jsonObject;
    }

    /**
     * 获取sessionId
     */
    @RequestMapping(value = "/check_openid", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object checkOpenId(HttpServletRequest request) {
        String code=request.getHeader("X-WX-Code");
        String appId=request.getHeader("X-WX-APP-ID");
        JSONObject jsonObject=new JSONObject();
        String session=SessionFactory.buildSession(appId,code);
        jsonObject.put("session",session);
        return jsonObject;
    }

    /**
     * 用户设置借口
     */
    @RequestMapping(value = "/users/update_user", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public Object updateUser(HttpServletRequest request, @RequestBody WeixinUser weixinUser) {
        String appId=request.getHeader("X-WX-APP-ID");
        String weixinKey=request.getHeader("X-WX-Skey");
        if(weixinUser!=null){
            weixinUser.setWeixinKey(weixinKey);
            weixinUserService.addOrUpdate(weixinUser);
        }
        SuccessResponseData successResponseData=new SuccessResponseData();
        return successResponseData;
    }


    /**
     * 首页上半部返回
     */
    @RequestMapping(value = "/header", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public Object header(HttpServletRequest request) {
        String appId=request.getHeader("X-WX-APP-ID");
        String weixinKey=request.getHeader("X-WX-Skey");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("bg_avatar","https://www.orzjj.com/jiezhang/images/header.jpg");
        jsonObject.put("position_1_human_name","今日支出：20.00");
        jsonObject.put("position_2_human_name","本月支出：100.00");
        jsonObject.put("position_3_human_name","预算剩余：3.00");
        jsonObject.put("show_notice_bar",false);//是否显示通知信息
        jsonObject.put("notice_bar_path","#");//通知跳转rul
        jsonObject.put("notice_text","notice_text");//通知信息
        return jsonObject;
    }

    /**
     * 首页上半部返回
     */
    @RequestMapping(value = "/index", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public Object index(HttpServletRequest request) {
        String appId=request.getHeader("X-WX-APP-ID");
        String weixinKey=request.getHeader("X-WX-Skey");
        JSONArray jsonArray=new JSONArray();
        return jsonArray;
    }

    /**
     * 首页上半部返回
     */
    @RequestMapping(value = "/icons/categories", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public Object iconCategory(HttpServletRequest request) {
        String appId=request.getHeader("X-WX-APP-ID");
        String weixinKey=request.getHeader("X-WX-Skey");
        JSONArray jsonArray=new JSONArray();
        List<String> list=new ArrayList<>();
        list.add("菜.png");
        list.add("shopping.png");
        jsonArray.add(list);
        return jsonArray;
    }

    /**
     * 首页上半部返回
     */
    @RequestMapping(value = "/icons/assets", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public Object iconAssets(HttpServletRequest request) {
        String appId=request.getHeader("X-WX-APP-ID");
        String weixinKey=request.getHeader("X-WX-Skey");
        JSONArray jsonArray=new JSONArray();
        List<String> list=new ArrayList<>();
        list.add("菜.png");
        list.add("shopping.png");
        jsonArray.add(list);
        return jsonArray;
    }


}

