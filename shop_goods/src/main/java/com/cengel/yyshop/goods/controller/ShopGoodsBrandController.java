package com.cengel.yyshop.goods.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.goods.entity.ShopGoodsBrand;
import com.cengel.yyshop.goods.service.ShopGoodsBrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsBrand")
public class ShopGoodsBrandController extends BaseController<ShopGoodsBrandService,ShopGoodsBrand> {


    @RequestMapping("list")
    public String list(){
        return "/manage/goods/shopGoodsBrand-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/goods/shopGoodsBrand-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsBrand",this.service.get(id));
        return "/manage/goods/shopGoodsBrand-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsBrand entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
