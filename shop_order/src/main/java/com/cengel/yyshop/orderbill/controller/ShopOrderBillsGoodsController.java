package com.cengel.yyshop.orderbill.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.orderbill.entity.ShopOrderBillsGoods;
import com.cengel.yyshop.orderbill.service.ShopOrderBillsGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/o/shopOrderBillsGoods")
public class ShopOrderBillsGoodsController extends BaseController<ShopOrderBillsGoodsService,ShopOrderBillsGoods> {


    @RequestMapping("list")
    public String list(){
        return "/manage/orderbill/shopOrderBillsGoods-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/orderbill/shopOrderBillsGoods-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopOrderBillsGoods",this.service.get(id));
        return "/manage/orderbill/shopOrderBillsGoods-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopOrderBillsGoods entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
