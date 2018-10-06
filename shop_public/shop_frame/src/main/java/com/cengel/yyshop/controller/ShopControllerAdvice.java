package com.cengel.yyshop.controller;

import com.cengel.starbucks.exception.BusinessException;
import com.cengel.starbucks.model.obj.BaseContext;
import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.util.DateUtil;
import com.cengel.starbucks.web.util.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/1 - 19:15
 * @Version V1.0
 **/
@ControllerAdvice
public class ShopControllerAdvice {

	@Autowired
	private BaseContext baseContext;

	@InitBinder
	public void DateBinder (WebDataBinder binder){
		DateFormat dateFormat = new SimpleDateFormat(DateUtil.yyyy_MM_dd_HH_mm_ss);
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, orderDateEditor);
	}

	@ModelAttribute
	public void modelput(HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("ip", IpUtils.getIpAddr(request));
		modelMap.put("uri", request.getRequestURI());
		modelMap.put("baseContext", baseContext);
	}

	@ExceptionHandler(value = BusinessException.class)
	public String busE(BusinessException ex, HttpServletRequest request) throws UnsupportedEncodingException {
		ex.printStackTrace();
		int code = ex.getCode();
		String message = ex.getMessage();
		if (request.getContentType() != null && request.getContentType().contains("application/x-www-form-urlencoded; charset=UTF-8")) {
			return "forward:/common/errorJson?port=" + code + "&message=" + URLEncoder.encode(message, "utf-8");
		}
		return "forward:/common/error?port=" + code + "&message=" + URLEncoder.encode(message, "utf-8");
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Response busE(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		String contentType = request.getContentType();
		ex.printStackTrace();
		return Response.error(ex.getMessage()).add("port", 305);
	}

}
