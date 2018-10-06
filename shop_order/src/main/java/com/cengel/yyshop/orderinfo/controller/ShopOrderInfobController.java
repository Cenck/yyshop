package com.cengel.yyshop.orderinfo.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.orderinfo.entity.ShopOrderInfob;
import com.cengel.yyshop.orderinfo.service.ShopOrderInfobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/m/o/shopOrderInfob")
public class ShopOrderInfobController extends BaseController<ShopOrderInfobService,ShopOrderInfob> {


    @RequestMapping("list")
    public String list(){
        return "/manage/orderinfo/shopOrderInfob-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/orderinfo/shopOrderInfob-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopOrderInfob",this.service.get(id));
        return "/manage/orderinfo/shopOrderInfob-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopOrderInfob entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
