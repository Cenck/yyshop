package com.cengel.yyshop.test.facade;

public interface MTestUserMenuFacade {

	void doTestTrans();
	void doWriteLock(int id);
	void doReadLock(int id);
}
