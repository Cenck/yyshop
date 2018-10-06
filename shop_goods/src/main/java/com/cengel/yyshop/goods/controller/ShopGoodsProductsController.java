package com.cengel.yyshop.goods.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.goods.entity.ShopGoodsProducts;
import com.cengel.yyshop.goods.service.ShopGoodsProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsProducts")
public class ShopGoodsProductsController extends BaseController<ShopGoodsProductsService,ShopGoodsProducts> {


    @RequestMapping("list")
    public String list(){
        return "/manage/goods/shopGoodsProducts-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/goods/shopGoodsProducts-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsProducts",this.service.get(id));
        return "/manage/goods/shopGoodsProducts-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsProducts entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
