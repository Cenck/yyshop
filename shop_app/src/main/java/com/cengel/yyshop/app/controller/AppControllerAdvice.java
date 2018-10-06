package com.cengel.yyshop.app.controller;

import com.cengel.starbucks.enums.ResultCodeEnum;
import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.util.DateUtil;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/23 - 10:42
 * @Version V1.0
 **/
@ControllerAdvice
@RestController
public class AppControllerAdvice {
	@InitBinder
	public void DateBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat(DateUtil.yyyy_MM_dd_HH_mm_ss);
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, orderDateEditor);
	}

	@ExceptionHandler(value = RuntimeException.class)
	@ResponseBody
	public Response busE(RuntimeException ex, HttpServletRequest request) throws UnsupportedEncodingException {
		ex.printStackTrace();
		String msg = ex.getMessage();
		String match = "Exception:";
		String HibernateOptimisticLockingFailureException = "HibernateOptimisticLockingFailureException:";
		if (null == msg) msg = "";
		if (msg.contains("NullPointerException:")) {
			msg = ResultCodeEnum.NOT_EXISTED.getDescription();
		} else if (msg.contains(HibernateOptimisticLockingFailureException)) {
			msg = ResultCodeEnum.SYS_BUSY.getDescription();
		} else if (msg.contains(match) && msg.contains("\n")) {
			int lineIndex = msg.indexOf("\n");
			if (lineIndex < 1) {
				msg = msg.substring(msg.indexOf(match) + match.length());
			} else {
				msg = msg.substring(msg.indexOf(match) + match.length(), lineIndex);
			}
		} return Response.error(msg);
	}

}
