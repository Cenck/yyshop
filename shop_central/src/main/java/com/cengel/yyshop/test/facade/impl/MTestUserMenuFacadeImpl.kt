package com.cengel.yyshop.test.facade.impl

import com.cengel.hibernate.dao.BaseDao
import com.cengel.yyshop.test.facade.MTestUserMenuFacade
import com.cengel.yyshop.user.entity.ShopUserMenu
import com.cengel.yyshop.user.service.ShopUserMenuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class MTestUserMenuFacadeImpl : MTestUserMenuFacade {
    @Autowired
    open lateinit var baseDao: BaseDao
    @Autowired
    open lateinit var shopUserMenuService:ShopUserMenuService
    @Autowired
    open lateinit var userMenusFacade: MTestUserMenuFacade

    @Transactional
    override fun doTestTrans(){
        /**
         * 读写互斥 写写互斥
         * 读读不互斥
         */
        Thread(Runnable {
            userMenusFacade.doWriteLock(1)
        }).start()
//        Thread.sleep(300)
//        Thread(Runnable {
//            userMenusFacade.doWriteLock(1)
//        }).start()
//        Thread(Runnable {
//            userMenusFacade.doReadLock(1)
//        }).start()
    }

    @Transactional
    override fun doWriteLock(id:Int){
        //写锁
        println("---- 开始执行写锁")
       var record  =  baseDao.queryDTO<ShopUserMenu>("select * from  shop_user_menu where id=$id for update", ShopUserMenu::class.java)
        println("写锁打印 - :${record.permission}")
        Thread.sleep(5000)
        record.isDefault = "1"
        println("写锁事务结束 ")
    }

    @Transactional
    override fun doReadLock(id:Int){
        println("读锁进入----")
        val record = baseDao.queryDTO<ShopUserMenu>("select * from shop_user_menu where id=$id  lock in share mode ",ShopUserMenu::class.java)
        println("读锁打印 - :${record.permission}")
        Thread.sleep(5000)
        record.isDefault = "1"
        println("读锁事务结束 ")

    }

}