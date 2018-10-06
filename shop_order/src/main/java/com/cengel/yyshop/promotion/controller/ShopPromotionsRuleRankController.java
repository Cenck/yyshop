package com.cengel.yyshop.promotion.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.promotion.entity.ShopPromotionsRuleRank;
import com.cengel.yyshop.promotion.service.ShopPromotionsRuleRankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/o/shopPromotionsRuleRank")
public class ShopPromotionsRuleRankController extends BaseController<ShopPromotionsRuleRankService,ShopPromotionsRuleRank> {


    @RequestMapping("list")
    public String list(){
        return "/manage/promotion/shopPromotionsRuleRank-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/promotion/shopPromotionsRuleRank-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopPromotionsRuleRank",this.service.get(id));
        return "/manage/promotion/shopPromotionsRuleRank-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopPromotionsRuleRank entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
