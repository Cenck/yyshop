package com.cengel.yyshop.goods.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.goods.entity.ShopGoodsArticleLink;
import com.cengel.yyshop.goods.service.ShopGoodsArticleLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequestMapping("/m/g/shopGoodsArticleLink")
public class ShopGoodsArticleLinkController extends BaseController<ShopGoodsArticleLinkService,ShopGoodsArticleLink> {


    @RequestMapping("list")
    public String list(){
        return "/manage/goods/shopGoodsArticleLink-list";
    }

    @RequestMapping("add")
    public String add(){
        return "/manage/goods/shopGoodsArticleLink-add";
    }

    @RequestMapping("edit")
    public String edit(Integer id,ModelMap modelMap){
        modelMap.put("shopGoodsArticleLink",this.service.get(id));
        return "/manage/goods/shopGoodsArticleLink-edit";
    }

    @RequestMapping("grid")
    @ResponseBody
    public Map<String, Object> grid(ShopGoodsArticleLink entity, Page page){
        return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity),Page.renderPage(page)));
    }


}
