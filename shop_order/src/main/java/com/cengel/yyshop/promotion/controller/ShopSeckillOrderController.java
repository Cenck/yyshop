package com.cengel.yyshop.promotion.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.promotion.entity.ShopSeckillOrder;
import com.cengel.yyshop.promotion.service.ShopSeckillOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/o/shopSeckillOrder")
public class ShopSeckillOrderController extends BaseController<ShopSeckillOrderService,ShopSeckillOrder> {


    @RequestMapping("list")
    public String list(){
        return "/manage/promotion/shopSeckillOrder-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/promotion/shopSeckillOrder-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopSeckillOrder",this.service.get(id));
        return "/manage/promotion/shopSeckillOrder-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopSeckillOrder entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
