package com.cengel.yyshop.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.cengel.starbucks.model.user.OnlineUser;
import com.cengel.starbucks.model.user.UserHolder;
import lombok.extern.slf4j.Slf4j;

/**
 * TraceFilter
 *
 * @author galaxy
 */
@Slf4j
@Activate(group = Constants.PROVIDER)
public class DubboOnlineUserProviderFilter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		Object[] arguments = invocation.getArguments();
		if (arguments.length > 0) {
			for (Object argument : arguments) {
				if (argument instanceof OnlineUser) {
					UserHolder.setUser((OnlineUser) argument);
				}
			}
		}
		try {
			return invoker.invoke(invocation);
		} finally {
			UserHolder.clear();
		}
	}

}