package com.cengel.yyshop.promotion.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.promotion.entity.ShopOrderPromotions;
import com.cengel.yyshop.promotion.service.ShopOrderPromotionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/o/shopOrderPromotions")
public class ShopOrderPromotionsController extends BaseController<ShopOrderPromotionsService,ShopOrderPromotions> {


    @RequestMapping("list")
    public String list(){
        return "/manage/promotion/shopOrderPromotions-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/promotion/shopOrderPromotions-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopOrderPromotions",this.service.get(id));
        return "/manage/promotion/shopOrderPromotions-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopOrderPromotions entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
