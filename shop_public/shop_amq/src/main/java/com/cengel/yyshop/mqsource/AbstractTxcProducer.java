package com.cengel.yyshop.mqsource;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/23 - 13:22
 * @Version V1.0
 **/
public interface AbstractTxcProducer {

	void send(String xid, long branchId, String message);

	void rollback(String var1, long var2, String var4);

	void commit(String var1, long var2, String var4);

	void start();

	void shutdown();

	void error(org.springframework.messaging.Message<?> message);

}
