package com.cengel.yyshop.property.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.property.entity.ShopGoodsStock;
import com.cengel.yyshop.property.service.ShopGoodsStockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsStock")
public class ShopGoodsStockController extends BaseController<ShopGoodsStockService,ShopGoodsStock> {


    @RequestMapping("list")
    public String list(){
        return "/manage/property/shopGoodsStock-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/property/shopGoodsStock-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsStock",this.service.get(id));
        return "/manage/property/shopGoodsStock-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsStock entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
