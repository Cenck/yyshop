package com.cengel.yyshop.code;

import com.cengel.code.CodeStarter;
import com.cengel.code.model.config.DefaultConfig;
import com.cengel.starbucks.annotation.Description;

import java.io.File;

import static com.cengel.yyshop.code.TableNamesItf.GOODS;
import static com.cengel.yyshop.code.TableNamesItf.MEMBER;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/2 - 16:57
 * @Version V1.0
 **/
public class ShopCodeGen {
	@Description("启动类型，匹配yaml中summer.codefactory.project.??")
	private final static String START_TYPE = "templates";


	private final static String BASE_PACKAGE = "com.cengel.yyshop.member";

	private final static String TABLE_NAME = MEMBER;//Service

	private final static String WEB_PATH = "/manage/orderbill"; //ftl路径

	public static void main(String[] args) {
		/** 写入项目到根路径下 */
		File targetClassFile = new File(CodeStarter.class.getResource("/").getPath());
		String rootPath = targetClassFile.getParentFile().getParent() + File.separator + "_products";
		DefaultConfig.setBasePackage(BASE_PACKAGE);
		DefaultConfig.setTableName(TABLE_NAME);
		DefaultConfig.setOutPath(rootPath);
		DefaultConfig.setWebPath(WEB_PATH);
		DefaultConfig.setStartType(START_TYPE);
		CodeStarter.run();
	}
}
