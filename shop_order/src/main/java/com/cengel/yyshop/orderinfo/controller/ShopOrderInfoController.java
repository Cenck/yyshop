package com.cengel.yyshop.orderinfo.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.orderinfo.entity.ShopOrderInfo;
import com.cengel.yyshop.orderinfo.service.ShopOrderInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/m/o/shopOrderInfo")
public class ShopOrderInfoController extends BaseController<ShopOrderInfoService,ShopOrderInfo> {


    @RequestMapping("list")
    public String list(){
        return "/manage/orderinfo/shopOrderInfo-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/orderinfo/shopOrderInfo-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopOrderInfo",this.service.get(id));
        return "/manage/orderinfo/shopOrderInfo-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopOrderInfo entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
