package com.cengel.yyshop.server;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cengel.starbucks.util.ThreadUtilKt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.Field;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/23 - 9:33
 * @Version V1.0
 **/
@Slf4j
public abstract class AbstractServerFactory implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		Class c = this.getClass();
		for (Field field : c.getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Reference.class) && field.getAnnotation(Reference.class).check() && null==field.get(this) ) {
				//非懒依赖的服务，如果找不到，则抛出异常，系统退出
				log.error("服务: {} 不可用，请检查服务提供者是否提供此服务。", field.getType().getName());
				new Thread(()->{
					ThreadUtilKt.sleep(300);
					System.exit(0);
				}).start();
				throw new IllegalStateException("服务:" +field.getType().getName() +"不可用");
			}
			field.setAccessible(false);
		}
	}
}
