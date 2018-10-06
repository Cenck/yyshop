package com.cengel.yyshop.category.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.category.entity.ShopGoodsTypeAttr;
import com.cengel.yyshop.category.service.ShopGoodsTypeAttrService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsTypeAttr")
public class ShopGoodsTypeAttrController extends BaseController<ShopGoodsTypeAttrService,ShopGoodsTypeAttr> {


    @RequestMapping("list")
    public String list(){
        return "/manage/category/shopGoodsTypeAttr-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/category/shopGoodsTypeAttr-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsTypeAttr",this.service.get(id));
        return "/manage/category/shopGoodsTypeAttr-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsTypeAttr entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
