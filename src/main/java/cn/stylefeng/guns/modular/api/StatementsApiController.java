package cn.stylefeng.guns.modular.api;

import cn.stylefeng.guns.modular.money.entity.Category;
import cn.stylefeng.guns.modular.money.service.CategoryService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/statements")
public class StatementsApiController extends BaseController {

    @Autowired
    private CategoryService categoryService;

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

    /**
     * 首页上半部返回
     */
    @RequestMapping(value = "/categories", method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    @ResponseBody
    public Object categories(HttpServletRequest request, @RequestParam String type) {
        String appId=request.getHeader("X-WX-APP-ID");
        String weixinKey=request.getHeader("X-WX-Skey");
        JSONObject json=new JSONObject();
        List<Category> list=categoryService.list();
        for(Category category:list){
            category.setIconPath("https://www.orzjj.com"+category.getIconPath());
        }
        //type=expend
        if(type.equals("expend")){
            List<Category> frequentList=list;
            json.put("frequent",frequentList);//常用分类
            Category ext=new Category();
            ext.setName("测试总分类");
            ext.setChilds(list);
            List<Category> realList=new ArrayList<>();
            realList.add(ext);
            json.put("categories",realList);//所有分类
            json.put("last",null);//最后使用类别
            json.put("type","expend");
        }
        return json;
    }
}
