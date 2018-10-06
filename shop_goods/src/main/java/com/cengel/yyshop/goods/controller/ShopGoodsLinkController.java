package com.cengel.yyshop.goods.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.goods.entity.ShopGoodsLink;
import com.cengel.yyshop.goods.service.ShopGoodsLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsLink")
public class ShopGoodsLinkController extends BaseController<ShopGoodsLinkService,ShopGoodsLink> {


    @RequestMapping("list")
    public String list(){
        return "/manage/goods/shopGoodsLink-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/goods/shopGoodsLink-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsLink",this.service.get(id));
        return "/manage/goods/shopGoodsLink-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsLink entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
