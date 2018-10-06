package com.cengel.yyshop.promotion.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.promotion.entity.ShopSeckill;
import com.cengel.yyshop.promotion.service.ShopSeckillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/o/shopSeckill")
public class ShopSeckillController extends BaseController<ShopSeckillService,ShopSeckill> {





    @RequestMapping("list")
    public String list(){
        return "/manage/promotion/shopSeckill-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/promotion/shopSeckill-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopSeckill",this.service.get(id));
        return "/manage/promotion/shopSeckill-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopSeckill entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
