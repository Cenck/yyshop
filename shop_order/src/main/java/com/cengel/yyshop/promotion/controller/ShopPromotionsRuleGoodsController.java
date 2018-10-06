package com.cengel.yyshop.promotion.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.promotion.entity.ShopPromotionsRuleGoods;
import com.cengel.yyshop.promotion.service.ShopPromotionsRuleGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/o/shopPromotionsRuleGoods")
public class ShopPromotionsRuleGoodsController extends BaseController<ShopPromotionsRuleGoodsService,ShopPromotionsRuleGoods> {


    @RequestMapping("list")
    public String list(){
        return "/manage/promotion/shopPromotionsRuleGoods-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/promotion/shopPromotionsRuleGoods-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopPromotionsRuleGoods",this.service.get(id));
        return "/manage/promotion/shopPromotionsRuleGoods-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopPromotionsRuleGoods entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
