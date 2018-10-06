package com.cengel.yyshop.orderbill.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.orderbill.entity.ShopOrderBills;
import com.cengel.yyshop.orderbill.service.ShopOrderBillsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/o/shopOrderBills")
public class ShopOrderBillsController extends BaseController<ShopOrderBillsService,ShopOrderBills> {


    @RequestMapping("list")
    public String list(){
        return "/manage/orderbill/shopOrderBills-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/orderbill/shopOrderBills-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopOrderBills",this.service.get(id));
        return "/manage/orderbill/shopOrderBills-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopOrderBills entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
