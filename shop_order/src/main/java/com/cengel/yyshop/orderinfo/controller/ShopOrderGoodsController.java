package com.cengel.yyshop.orderinfo.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.orderinfo.entity.ShopOrderGoods;
import com.cengel.yyshop.orderinfo.service.ShopOrderGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/m/o/shopOrderGoods")
public class ShopOrderGoodsController extends BaseController<ShopOrderGoodsService,ShopOrderGoods> {


    @RequestMapping("list")
    public String list(){
        return "/manage/orderinfo/shopOrderGoods-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/orderinfo/shopOrderGoods-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopOrderGoods",this.service.get(id));
        return "/manage/orderinfo/shopOrderGoods-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopOrderGoods entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
