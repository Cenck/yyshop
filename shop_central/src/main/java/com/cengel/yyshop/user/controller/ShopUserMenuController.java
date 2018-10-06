package com.cengel.yyshop.user.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.starbucks.model.obj.Response;
import com.cengel.yyshop.user.entity.ShopUserMenu;
import com.cengel.yyshop.user.service.ShopUserMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/m/uc/userMenu")
public class ShopUserMenuController extends BaseController<ShopUserMenuService, ShopUserMenu> {

	@RequestMapping("tree")
	public String tree() {
		return "/manage/user/shopUserMenu-tree";
	}

	@RequestMapping("treeAjax")
	@ResponseBody
	public Response treeAjax() {
		return Response.success().addData(service.findAllMenus());
	}

	@RequestMapping("list")
	public String list() {
		return "/manage/user/shopUserMenu-list";
	}

	@RequestMapping("add")
	public String add() {
		return "/manage/user/shopUserMenu-add";
	}
	@RequestMapping("addDialog")
	public String addDialog(Integer parentId,ModelMap modelMap) {
		modelMap.put("parentId",parentId);
		return "/manage/user/shopUserMenu-add";
	}

	@RequestMapping("edit")
	public String edit(Integer id, ModelMap modelMap) {
		modelMap.put("shopUserMenu", this.service.get(id));
		return "/manage/user/shopUserMenu-edit";
	}

	@RequestMapping("grid")
	@ResponseBody
	public Map<String, Object> grid(ShopUserMenu entity, Page page) {
		return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity), Page.renderPage(page)));
	}

}
