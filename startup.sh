#!/usr/bin/env bash
#!/usr/bin/env bash
:||{
....@Author: zhz
....@Time: 2018年7月31日14:34:14
....多选注释: 参数列表
    $1: 项目名称, 如ncis,yc,manage,central等
    $2: 操作类型: compile start
}

#startup.sh所有系统目录
base_path="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
#jar包输出路径
pdt_path=/d/application/springcloud/shop


#函数定义
copy_jar(){
    cd $base_path
    cp -rf $1/target/*.jar  $pdt_path
}
render_before(){
	cd $base_path/shop_public/shop_frame_api/src/main/resources
	pwd
	cp -rf DubboProtocolConstant ../java/com/cengel/yyshop/constant/DubboProtocolConstant.java
}
render_after(){
	cd $base_path/shop_public/shop_frame_api/src/main/resources
	pwd
	cp -rf DubboProtocolConstant-dev ../java/com/cengel/yyshop/constant/DubboProtocolConstant.java
}

# 第一步 ： svn 更新
cd $base_path
git pull

# 第二步：编辑前处理
render_before

##定向编辑各个项目
case $1 in
	'none')
   ;;
	'push')
	cd $base_path
	git add .
	git commit -m $2
	git push
   ;;
 *)
    echo 编辑所有
	cd $base_path/shop_public/shop_frame_api
	mvn clean install -Dmaven.test.skip=true
	cd $base_path/shop_api
    mvn clean install -Dmaven.test.skip=true
    cd $base_path
    mvn clean install -Dmaven.test.skip=true


    echo 复制所有
	copy_jar shop_app
	copy_jar shop_goods
	copy_jar shop_order
	copy_jar shop_provider

  ;;
 esac

 #返回
 render_after



