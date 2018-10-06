package com.cengel.yyshop.category.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.category.entity.ShopGoodsTypeSpec;
import com.cengel.yyshop.category.service.ShopGoodsTypeSpecService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsTypeSpec")
public class ShopGoodsTypeSpecController extends BaseController<ShopGoodsTypeSpecService,ShopGoodsTypeSpec> {


    @RequestMapping("list")
    public String list(){
        return "/manage/category/shopGoodsTypeSpec-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/category/shopGoodsTypeSpec-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsTypeSpec",this.service.get(id));
        return "/manage/category/shopGoodsTypeSpec-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsTypeSpec entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
