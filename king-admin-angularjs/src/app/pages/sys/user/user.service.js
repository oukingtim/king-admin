(function () {
    'use strict';

    angular.module('KingAdmin.pages.sys.user')
        .factory('UserService', UserService);

    /** @ngInject */
    function UserService($resource,toastr,CommonService) {

        var rest = $resource('sys/users/:id', {}, {
            'create': {method: 'POST'},
            'update': {method: 'PUT'},
        });
        
        function getSmartData(param,callback) {
            $resource('sys/users/getSmartData', {}, {
                'query': {method: 'POST'}
            }).query(param,
                function (data,hears) {
                    console.log(data);
                    if(angular.isFunction(callback)) callback(data);callback(data)
                }, function (error) {
                    toastr.error(error, "提示", {"progressBar": true,});
                });
        }
        function del(param,callback) {
            CommonService.danger('确定删除?', function () {
                rest.delete(param,
                    function (data) {
                        if (data.code == 0) {
                            toastr.success("删除成功！", "提示", {"progressBar": true,});
                        } else {
                            toastr.warning("删除失败！", "提示", {"progressBar": true,});
                        }
                        if(angular.isFunction(callback)) callback(data);
                    }, function (error) {
                        toastr.error(error, "提示", {"progressBar": true,});
                    })
            })
        }
        function save(param,callback) {
            CommonService.info('确定保存?',function () {
                if(angular.isDefined(param.id)&&param.id!=null){
                    rest.update(param,
                        function (data) {
                            console.log(data);
                            toastr.success("保存成功","提示",{"progressBar": true,});
                            if(angular.isFunction(callback)) callback(data);
                        }, function (error) {
                            toastr.error(error,"提示",{"progressBar": true,});
                        })
                }else{
                    rest.create(param,
                        function (data) {
                            console.log(data);
                            toastr.success("保存成功","提示",{"progressBar": true,});
                            if(angular.isFunction(callback)) callback(data);
                        }, function (error) {
                            toastr.error(error,"提示",{"progressBar": true,});
                        })
                }
            });
        }
        function getInfo(param,callback) {
            rest.get(param,
                function (data) {
                    console.log(data);
                    if(angular.isFunction(callback)) callback(data);
                }, function (error) {
                    toastr.error(error,"提示",{"progressBar": true,});
                })
        }
        function login(param,callback) {
            $resource('api/login',{},{'login': {method: 'POST'}}).login(param,
                function (data,hears) {
                    if(data.code=='0'){
                        if(angular.isFunction(callback)) callback(data);
                    }else{
                        toastr.error(data.msg, "提示", {"progressBar": true,});
                    }
                    console.log(data);
                }, function (error) {
                    toastr.error(error, "提示", {"progressBar": true,});
                });
        }
        function signout(param,callback) {
            $resource('api/signout',{},{'signout': {method: 'GET'}}).signout(param,
                function (data,hears) {
                    if(data.code=='0'){
                        toastr.success("保存成功","提示",{"progressBar": true,});
                        if(angular.isFunction(callback)) callback(data);
                    }else{
                        toastr.error(data.msg, "提示", {"progressBar": true,});
                    }
                }, function (error) {
                    toastr.error(error, "提示", {"progressBar": true,});
                });
        }
        function isLogin(callback) {
            $resource('api/isLogin',{},{'isLogin': {method: 'GET'}}).isLogin({},
                function (data,hears) {
                    if(angular.isFunction(callback)) callback(data);
                }, function (error) {
                    toastr.error(error, "提示", {"progressBar": true,});
                });
        }
        function password(param,callback) {
            CommonService.info('确定保存?',function () {
                $resource('api/password', {}, {'password': {method: 'PUT'}}).password(param,
                    function (data, hears) {
                        if(data.code=='0'){
                            toastr.success("保存成功","提示",{"progressBar": true,});
                            if(angular.isFunction(callback)) callback(data);
                        }else{
                            toastr.error(data.msg, "提示", {"progressBar": true,});
                        }
                    }, function (error) {
                        toastr.error(error, "提示", {"progressBar": true,});
                    });
            });
        }
        return {
            getSmartData:getSmartData,
            del:del,
            save:save,
            getInfo:getInfo,
            login:login,
            signout:signout,
            isLogin:isLogin,
            password:password
        };

    }

})();
