package cn.stylefeng.guns.modular.money.service;

import cn.stylefeng.guns.base.BaseJunit;
import cn.stylefeng.guns.modular.money.entity.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CategoryServiceTest extends BaseJunit {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testList(){
        List<Category> list=categoryService.list();
        System.out.println("------------------");
        for(Category category:list){
            category.setIconPath("https://www.orzjj.com"+category.getIconPath());
        }
        for(Category category:list){
            System.out.println(category.getName());
            System.out.println(category.getIconPath());
        }
    }

}