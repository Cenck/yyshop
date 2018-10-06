package com.cengel.yyshop.property.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.property.entity.ShopGoodsSpecLink;
import com.cengel.yyshop.property.service.ShopGoodsSpecLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsSpecLink")
public class ShopGoodsSpecLinkController extends BaseController<ShopGoodsSpecLinkService,ShopGoodsSpecLink> {


    @RequestMapping("list")
    public String list(){
        return "/manage/property/shopGoodsSpecLink-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/property/shopGoodsSpecLink-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsSpecLink",this.service.get(id));
        return "/manage/property/shopGoodsSpecLink-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsSpecLink entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
