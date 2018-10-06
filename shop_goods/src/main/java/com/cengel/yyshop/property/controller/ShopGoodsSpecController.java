package com.cengel.yyshop.property.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.property.entity.ShopGoodsSpec;
import com.cengel.yyshop.property.service.ShopGoodsSpecService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsSpec")
public class ShopGoodsSpecController extends BaseController<ShopGoodsSpecService,ShopGoodsSpec> {


    @RequestMapping("list")
    public String list(){
        return "/manage/property/shopGoodsSpec-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/property/shopGoodsSpec-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsSpec",this.service.get(id));
        return "/manage/property/shopGoodsSpec-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsSpec entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
