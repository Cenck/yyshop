package com.cengel.yyshop.property.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.property.entity.ShopGoodsAttrValue;
import com.cengel.yyshop.property.service.ShopGoodsAttrValueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsAttrValue")
public class ShopGoodsAttrValueController extends BaseController<ShopGoodsAttrValueService,ShopGoodsAttrValue> {


    @RequestMapping("list")
    public String list(){
        return "/manage/property/shopGoodsAttrValue-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/property/shopGoodsAttrValue-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsAttrValue",this.service.get(id));
        return "/manage/property/shopGoodsAttrValue-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsAttrValue entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
