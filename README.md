# yyshop

#### 重要说明 
本项目依赖以下项目**cg-frame**  
cg-frame: https://gitee.com/cengel/cg-frame
请先在本地仓库安装 cg-frame  
安装顺序：先装cg-prarent 然后cg-frame
 
#### 项目介绍
yy商城项目

#### 软件架构
软件架构说明

#### maven编辑顺序

```
//先编辑通用变量包
cd $base_path/shop_public/shop_frame_api
mvn clean install -Dmaven.test.skip=true
//再编辑持久层
cd $base_path/shop_api
mvn clean install -Dmaven.test.skip=true
//最后整体编辑(亦可根据个人需求定向编辑)
cd $base_path
mvn clean install -Dmaven.test.skip=true
```

#### 项目启动顺序

1. provider
2. goods order 
3. app mgr


#### 使用说明

1. xxxx
2. xxxx
3. xxxx

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


#### 码云特技

1. 使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2. 码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3. 你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4. [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5. 码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6. 码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)