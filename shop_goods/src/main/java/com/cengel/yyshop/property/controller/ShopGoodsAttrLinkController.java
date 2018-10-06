package com.cengel.yyshop.property.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.property.entity.ShopGoodsAttrLink;
import com.cengel.yyshop.property.service.ShopGoodsAttrLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsAttrLink")
public class ShopGoodsAttrLinkController extends BaseController<ShopGoodsAttrLinkService,ShopGoodsAttrLink> {


    @RequestMapping("list")
    public String list(){
        return "/manage/property/shopGoodsAttrLink-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/property/shopGoodsAttrLink-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsAttrLink",this.service.get(id));
        return "/manage/property/shopGoodsAttrLink-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsAttrLink entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
