package com.cengel.yyshop.property.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.property.entity.ShopGoodsMark;
import com.cengel.yyshop.property.service.ShopGoodsMarkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsMark")
public class ShopGoodsMarkController extends BaseController<ShopGoodsMarkService,ShopGoodsMark> {


    @RequestMapping("list")
    public String list(){
        return "/manage/property/shopGoodsMark-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/property/shopGoodsMark-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsMark",this.service.get(id));
        return "/manage/property/shopGoodsMark-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsMark entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
