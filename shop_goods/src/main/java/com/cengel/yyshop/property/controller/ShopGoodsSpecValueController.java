package com.cengel.yyshop.property.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.property.entity.ShopGoodsSpecValue;
import com.cengel.yyshop.property.service.ShopGoodsSpecValueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsSpecValue")
public class ShopGoodsSpecValueController extends BaseController<ShopGoodsSpecValueService,ShopGoodsSpecValue> {


    @RequestMapping("list")
    public String list(){
        return "/manage/property/shopGoodsSpecValue-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/property/shopGoodsSpecValue-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsSpecValue",this.service.get(id));
        return "/manage/property/shopGoodsSpecValue-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsSpecValue entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
