package com.cengel.yyshop.category.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.category.entity.ShopGoodsType;
import com.cengel.yyshop.category.service.ShopGoodsTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsType")
public class ShopGoodsTypeController extends BaseController<ShopGoodsTypeService,ShopGoodsType> {


    @RequestMapping("list")
    public String list(){
        return "/manage/category/shopGoodsType-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/category/shopGoodsType-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsType",this.service.get(id));
        return "/manage/category/shopGoodsType-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsType entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
