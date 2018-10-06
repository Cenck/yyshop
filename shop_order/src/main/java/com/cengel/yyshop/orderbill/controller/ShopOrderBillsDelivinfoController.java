package com.cengel.yyshop.orderbill.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.orderbill.entity.ShopOrderBillsDelivinfo;
import com.cengel.yyshop.orderbill.service.ShopOrderBillsDelivinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/o/shopOrderBillsDelivinfo")
public class ShopOrderBillsDelivinfoController extends BaseController<ShopOrderBillsDelivinfoService,ShopOrderBillsDelivinfo> {


    @RequestMapping("list")
    public String list(){
        return "/manage/orderbill/shopOrderBillsDelivinfo-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/orderbill/shopOrderBillsDelivinfo-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopOrderBillsDelivinfo",this.service.get(id));
        return "/manage/orderbill/shopOrderBillsDelivinfo-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopOrderBillsDelivinfo entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
