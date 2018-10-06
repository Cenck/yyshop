package com.cengel.yyshop.category.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.category.entity.ShopGoodsCategory;
import com.cengel.yyshop.category.service.ShopGoodsCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsCategory")
public class ShopGoodsCategoryController extends BaseController<ShopGoodsCategoryService,ShopGoodsCategory> {


    @RequestMapping("list")
    public String list(){
        return "/manage/category/shopGoodsCategory-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/category/shopGoodsCategory-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsCategory",this.service.get(id));
        return "/manage/category/shopGoodsCategory-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsCategory entity, Page page){
        page.setSort("sortOrder");
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
