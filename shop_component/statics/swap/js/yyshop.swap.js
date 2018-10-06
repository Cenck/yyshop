var app = angular.module('thisAng', []);
app.controller('thisCtrl', function ($scope, $http) {
    SWAP.$http = $http;
    SWAP.$scope = $scope;
    SWAP.onReady($scope);
});

SWAP={
    $scope:{},
    $http: {},
    onReady:function () {
    }
}

if(typeof jQuery == "undefined") jQuery = {};
jQuery.http = function(url,param,callback){
    SWAP.$http.get(url)
        .then(function (response) {
            if (!response) {
                alert("网络异常")
                return
            }
            var retData = response.data;
            if (!retData) {
                alert("非api接口")
                return
            }
            if (retData.success){
                var finalData = retData.data;
                if (finalData && typeof finalData!="object") {
                    finalData = JSON.parse(retData.data);
                }
                callback(finalData,retData.message,retData.code);
            }else {
                alert(retData.message)
                if (retData.code===502){
                    location.href = '/swap/login.html'
                }
            }
        });
};


//常量区
//test秒杀
const URL_TEST_SECK_THREAD = "/app/seckill/test/thread";//多线程共抢
const URL_TEST_SECK_RESET="/app/seckill/test/reset"; //重置抢数据
const URL_TEST_SECK_START = "/app/seckill/start";
const URL_TEST_SECK_GET = "/app/seckill/test/getOne";

//主页
const URL_HOME_INDEX = "/app/home/index";
//用户
const URL_MEMBER_INFO="/app/member/info";