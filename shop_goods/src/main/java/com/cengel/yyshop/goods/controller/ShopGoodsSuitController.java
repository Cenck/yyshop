package com.cengel.yyshop.goods.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.goods.entity.ShopGoodsSuit;
import com.cengel.yyshop.goods.service.ShopGoodsSuitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsSuit")
public class ShopGoodsSuitController extends BaseController<ShopGoodsSuitService,ShopGoodsSuit> {


    @RequestMapping("list")
    public String list(){
        return "/manage/goods/shopGoodsSuit-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/goods/shopGoodsSuit-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsSuit",this.service.get(id));
        return "/manage/goods/shopGoodsSuit-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsSuit entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
