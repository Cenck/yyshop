package com.cengel.yyshop.user.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.user.entity.ShopMenu;
import com.cengel.yyshop.user.service.ShopMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/uc/menu")
public class ShopMenuController extends BaseController<ShopMenuService,ShopMenu> {


    @RequestMapping("list")
    public String list(ModelMap modelMap){
        return "/manage/user/shopMenu-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/user/shopMenu-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopMenu",this.service.get(id));
        return "/manage/user/shopMenu-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopMenu entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
