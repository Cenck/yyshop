package com.cengel.yyshop.user.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.user.entity.ShopUser;
import com.cengel.yyshop.user.service.ShopUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/uc/user")
public class ShopUserController extends BaseController<ShopUserService,ShopUser> {


    @RequestMapping("list")
    public String list(){
        return "/manage/user/shopUser-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/user/shopUser-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopUser",this.service.get(id));
        return "/manage/user/shopUser-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopUser entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
