package com.cengel.yyshop.user.controller;

import com.cengel.hibernate.controller.BaseController;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.yyshop.user.entity.ShopRole;
import com.cengel.yyshop.user.service.ShopRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/m/uc/role")
public class ShopRoleController extends BaseController<ShopRoleService, ShopRole> {

	@RequestMapping("list")
	public String list() {
		return "/manage/user/shopRole-list";
	}

	@RequestMapping("add")
	public String add() {
		return "/manage/user/shopRole-add";
	}

	@RequestMapping("edit")
	public String edit(Integer id, ModelMap modelMap) {
		modelMap.put("shopRole", this.service.get(id));
		return "/manage/user/shopRole-edit";
	}

	@RequestMapping("grid")
	@ResponseBody
	public Map<String, Object> grid(ShopRole entity, Page page) {
		return DataGrid.renderDataGrid(this.service.pageLike(Params.create().addEntity(entity), Page.renderPage(page)));
	}

}
