package cn.stylefeng.guns.modular.api;

import cn.stylefeng.guns.core.common.constant.state.ManagerStatus;
import cn.stylefeng.guns.modular.cache.MoneyUserCache;
import cn.stylefeng.guns.modular.money.entity.Category;
import cn.stylefeng.guns.modular.money.entity.MoneyUser;
import cn.stylefeng.guns.modular.money.service.CategoryService;
import cn.stylefeng.guns.modular.system.entity.User;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/api/categories")
public class CategoryApiController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取顶级分类
     */
    @RequestMapping(value = "/parent", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public Object parent(HttpServletRequest request, @RequestParam String type) {
        String appId=request.getHeader("X-WX-APP-ID");
        String weixinKey=request.getHeader("X-WX-Skey");
        JSONArray jsonArray=new JSONArray();
        return jsonArray;
    }

    /**
     * 添加分类
     */
    @RequestMapping(value = "", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public Object index(HttpServletRequest request, @RequestBody Category category) {
        String appId=request.getHeader("X-WX-APP-ID");
        String weixinKey=request.getHeader("X-WX-Skey");
        JSONObject jsonObject=new JSONObject();
        MoneyUser user=MoneyUserCache.getUser(request);
        if(user==null){
            jsonObject.put("status",400);
            jsonObject.put("msg","用户未登录");
        }else{
            category.setUserId(user.getUserId());
            if(category.getId()!=null&&category.getId()==0){
                category.setId(null);
            }
            if(category.getParentId()!=null&&category.getParentId()==0){
                category.setParentId(null);
            }
            category.setCreateTime(new Date());
            category.setStatus(ManagerStatus.OK.toString());
            categoryService.save(category);
            jsonObject.put("status",200);
            jsonObject.put("data",category);
        }
        return jsonObject;
    }
}
