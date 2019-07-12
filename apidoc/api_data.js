define({
    "api": [
        {
            "type": "Delete",
            "url": "api/v1/admin/delPermsAndOperating",
            "title": "逻辑删除 权限/关联的权限操作/关联的角色",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>通过权限id去删除</p>",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "List",
                            "optional": false,
                            "field": "idDelList",
                            "description": "<p>删除的 权限 id</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"idDelList\":[1,2,3,4,5,n]\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "DeleteApiV1AdminDelpermsandoperating"
        },
        {
            "type": "Delete",
            "url": "api/v1/admin/delUserInfo",
            "title": "逻辑删除 用户/角色信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>通过用户id删除下面的角色信息</p>",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "List",
                            "optional": false,
                            "field": "idDelList",
                            "description": "<p>删除的 用户 id</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"idDelList\":[1,2,3,4,5,n]\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "DeleteApiV1AdminDeluserinfo"
        },
        {
            "type": "Delete",
            "url": "api/v1/admin/dleRole",
            "title": "逻辑删除 角色/关联权限/关联用户/关联的菜单",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>通过角色id 去删除</p>",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "List",
                            "optional": false,
                            "field": "idDelList",
                            "description": "<p>删除的 角色 id</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"idDelList\":[1,2,3,4,5,n]\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "DeleteApiV1AdminDlerole"
        },
        {
            "type": "GET",
            "url": "api/v1/admin/findByRoleQueryPermission",
            "title": "查询 通过角色获得权限列表",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于权限列表</p>",
            "parameter": {
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n不需要参数\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "GetApiV1AdminFindbyrolequerypermission"
        },
        {
            "type": "get",
            "url": "api/v1/admin/getByRoleList",
            "title": "查询所有角色信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于获得所有角色信息</p>",
            "parameter": {
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n不需要参数\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "GetApiV1AdminGetbyrolelist"
        },
        {
            "type": "GET",
            "url": "/api/v1/super-admin/selPermission",
            "title": "超级管理员查询租户权限列表进行配置",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于权限列表</p>",
            "parameter": {
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n不需要参数\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/tenant/TenantController.java",
            "groupTitle": "Admin",
            "name": "GetApiV1SuperAdminSelpermission"
        },
        {
            "type": "POST",
            "url": "api/v1/admin/getByUserInfoList",
            "title": "查询用户信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于查询用户信息</p>",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": true,
                            "field": "name",
                            "description": "<p>名称</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": true,
                            "field": "rName",
                            "description": "<p>角色名称</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": true,
                            "field": "accountStatus",
                            "description": "<p>状态信息</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "List",
                            "optional": true,
                            "field": "createDates",
                            "description": "<p>创建时间</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"name\":\"陈恩惠\",\n\"userName\":\"tt\",\n\"accountStatus\":0,\n\"rName\":\"超级管理员\",\n\"createDates\":[11111,111111]\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "PostApiV1AdminGetbyuserinfolist"
        },
        {
            "type": "POST",
            "url": "api/v1/admin/getPermissionAndOperating",
            "title": "查询权限组里面的操作信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于查询权限组里面的操作信息</p>",
            "parameter": {
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n传空对象 这里还没有设置条件查询\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "PostApiV1AdminGetpermissionandoperating"
        },
        {
            "type": "POST",
            "url": "api/v1/admin/getRoleAndPerm",
            "title": "查询角色对应的权限",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于查询角色对应的权限</p>",
            "parameter": {
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n传空对象 这里还没有设置条件查询\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "PostApiV1AdminGetroleandperm"
        },
        {
            "type": "Post",
            "url": "api/v1/admin/insertUserInfo",
            "title": "新增用户信息以及下面的角色信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于新增用户信息以及下面的角色信息</p>",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "userName",
                            "description": "<p>用户名</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "pwd",
                            "description": "<p>密码</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "rids",
                            "description": "<p>需要添加的角色 rdis</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"userName\":\"eeee\",\n\"pwd\":\"123456\",\n\"rids\":\"7,8,9,10\"\nxxxxx 一些页面可以添加的数据\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "PostApiV1AdminInsertuserinfo"
        },
        {
            "type": "POST",
            "url": "api/v1/admin/savePermissionOperating",
            "title": "新增操作权限下面的 增删改信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "pId",
                            "description": "<p>权限id</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "apiUrl",
                            "description": "<p>对应的请求url</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "poName",
                            "description": "<p>对应的请求方式</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\"pName\":\"查看\",\n\"permsOperatingList\":[{\"apiUrl\":\"/index/api\",\"poName\":\"GET\"},{\"apiUrl\":\"/index/api1\",\"poName\":\"POST\"}]\n}",
                        "type": "json"
                    }
                ]
            },
            "description": "<p>用于新增操作权限下面的 增删改信息</p>",
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "PostApiV1AdminSavepermissionoperating"
        },
        {
            "type": "POST",
            "url": "api/v1/admin/saveRoleAndMenu",
            "title": "新增角色跟菜单查看权限",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于新增角色跟菜单查看权限</p>",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "rName",
                            "description": "<p>角色 名称</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "List",
                            "optional": false,
                            "field": "menus",
                            "description": "<p>菜单 id 集合</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"rName\":1,\n\"menus\":[6,9,0,9,10]\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "PostApiV1AdminSaveroleandmenu"
        },
        {
            "type": "POST",
            "url": "api/v1/admin/saveRoleAndPerms",
            "title": "新增角色跟权限",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于新增角色跟权限</p>",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "rName",
                            "description": "<p>角色 名称</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "List",
                            "optional": false,
                            "field": "perms",
                            "description": "<p>权限 id 集合</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"rName\":\"仓库\",\n\"perms\":[1,2,34]\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "PostApiV1AdminSaveroleandperms"
        },
        {
            "type": "POST",
            "url": "api/v1/admin/upPermsAndOperating",
            "title": "修改权限下面的权限操作信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "pId",
                            "description": "<p>权限id</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "pName",
                            "description": "<p>修改的权限名称</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "version",
                            "description": "<p>版本  注 如果要修改权限名称 必须传版本</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "apiUrl",
                            "description": "<p>对应的请求url</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "poName",
                            "description": "<p>对应的请求方式</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\"pId\":9,\n\"pName\":\"测试\",\n\"version\":10,\n\"permsOperatingList\":[{\"apiUrl\":\"/index/api\",\"poName\":\"GET\"},{\"apiUrl\":\"/index/api1\",\"poName\":\"POST\"}]\n}",
                        "type": "json"
                    }
                ]
            },
            "description": "<p>用于修改权限下面的权限操作信息</p>",
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "PostApiV1AdminUppermsandoperating"
        },
        {
            "type": "Post",
            "url": "api/v1/super-admin/insertTenant",
            "title": "新增创建租户信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于新增用户信息以及下面的角色信息</p>",
            "parameter": {
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"dbPwd\":\"root\",\n\"tenantName\":\"浙江创业3\",\n\"dbName\":\"root\",\n\"dbUrl\":\"192.168.1.230:3306/db3\",\n\"tenant\":\"tenant3\"\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/tenant/TenantController.java",
            "groupTitle": "Admin",
            "name": "PostApiV1SuperAdminInserttenant"
        },
        {
            "type": "PUT",
            "url": "api/v1/admin/saveRoleAndMenu",
            "title": "修改角色/菜单查看权限",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用角色id 去修改菜单信息</p>",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "rId",
                            "description": "<p>角色名称</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "version",
                            "optional": false,
                            "field": "version",
                            "description": "<p>版本 注 如果你想修改角色名称 必须传版本信息</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "rName",
                            "description": "<p>角色id</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "List",
                            "optional": false,
                            "field": "menus",
                            "description": "<p>菜单 id 集合</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"rid\":10,\n\"rName\":\"测试\",\n\"version\":0,\n\"menus\":[7,8,9]\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "PutApiV1AdminSaveroleandmenu"
        },
        {
            "type": "PUT",
            "url": "api/v1/admin/upAndDelRoleAndPerms",
            "title": "修改角色配置权限",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于角色配置权限修改跟删除</p>",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "rId",
                            "description": "<p>角色 id</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "List",
                            "optional": false,
                            "field": "perms",
                            "description": "<p>权限 id 集合</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"rId\":2,\n\"perms\":[1,4,6,10]\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "PutApiV1AdminUpanddelroleandperms"
        },
        {
            "type": "PUT",
            "url": "api/v1/admin/upUserAndRole",
            "title": "修改用户下面的角色信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于修改用户下面的角色信息</p>",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "uid",
                            "description": "<p>更新id</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "rids",
                            "description": "<p>角色 ids</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"uid\":1,\n\"rids\":\"1,2,3\"\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "PutApiV1AdminUpuserandrole"
        },
        {
            "type": "PUT",
            "url": "api/v1/admin/upUserInfo",
            "title": "修改用户信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Admin",
            "version": "0.0.1",
            "description": "<p>用于更新用户信息</p>",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "uid",
                            "description": "<p>更新id</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "version",
                            "description": "<p>更新版本号</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"uid\":1,\n\"version\":10\nxxxx  其余的修改对象   userName 是不给更新的不能传过来\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/user/AdminController.java",
            "groupTitle": "Admin",
            "name": "PutApiV1AdminUpuserinfo"
        },
        {
            "success": {
                "fields": {
                    "Success 200": [
                        {
                            "group": "Success 200",
                            "optional": false,
                            "field": "varname1",
                            "description": "<p>No type.</p>"
                        },
                        {
                            "group": "Success 200",
                            "type": "String",
                            "optional": false,
                            "field": "varname2",
                            "description": "<p>With type.</p>"
                        }
                    ]
                }
            },
            "type": "",
            "url": "",
            "version": "0.0.0",
            "filename": "./apidoc/main.js",
            "group": "E__dev3_wh_web_gitlab_apidoc_main_js",
            "groupTitle": "E__dev3_wh_web_gitlab_apidoc_main_js",
            "name": ""
        },
        {
            "type": "POST",
            "url": "api/v1/wh-fba-stocking/findByFbaAndEntry",
            "title": "查询fba备货信息和箱号信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "FBA_Stocking",
            "version": "0.0.1",
            "description": "<p>用于查询fba备货信息 And 箱号信息</p>",
            "parameter": {
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/out/library/fba/WhFbaStockingController.java",
            "groupTitle": "FBA_Stocking",
            "name": "PostApiV1WhFbaStockingFindbyfbaandentry"
        },
        {
            "type": "POST",
            "url": "api/v1/wh-fba-stocking/saveFbaAndEntry",
            "title": "新增fba备货信息和箱号信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "FBA_Stocking",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "sku",
                            "description": "<p>sku</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "site",
                            "description": "<p>站点</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "shipMethods",
                            "description": "<p>物流方式/跟踪号</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "dInformation",
                            "description": "<p>收货信息</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "quantity",
                            "description": "<p>数量</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "account",
                            "description": "<p>账号</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "nOfBoxes",
                            "description": "<p>包装箱数量</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\"entry\":[{\n\"fnSku\":\"1122KK\",\n\"fseName\":\"测试name\",\n\"quantity\":80,\n\"sku\":\"cccccc\"\n},{\n\"fnSku\":\"1122K2\",\n\"fseName\":\"测试name2\",\n\"quantity\":802,\n\"sku\":\"cccccc2\"\n}],\n\"site\":\"UA\",\n\"shipMethods\":\"测试\",\n\"dInformation\":\"测试1\",\n\"account\":\"cc\",\n\"nOfBoxes\":5\n}",
                        "type": "json"
                    }
                ]
            },
            "version": "0.0.1",
            "description": "<p>用于新增fba备货信息和箱号信息</p>",
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/out/library/fba/WhFbaStockingController.java",
            "groupTitle": "FBA_Stocking",
            "name": "PostApiV1WhFbaStockingSavefbaandentry"
        },
        {
            "type": "PUT",
            "url": "api/v1/wh-fba-stocking-entry/upOrDelFbaStockingEntry",
            "title": "修改/删除 fba备货装箱信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "FBA_Stocking",
            "version": "0.0.1",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "List",
                            "optional": false,
                            "field": "delIds",
                            "description": "<p>传要删除的id集合</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "List",
                            "optional": false,
                            "field": "stockingEntry",
                            "description": "<p>传需要更新的List对象集合</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"delIds\":[1,2,3],\n\"stockingEntry\":[{\"fnSku\":\"测试\",\"id\":4,\"version\":0 必须填},{\"fnSku\":\"策划\",\"id\":5,\"version\":0}]\n}",
                        "type": "json"
                    }
                ]
            },
            "description": "<p>用于修改/删除 fba备货装箱信息</p>",
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/out/library/fba/WhFbaStockingEntryController.java",
            "groupTitle": "FBA_Stocking",
            "name": "PutApiV1WhFbaStockingEntryUpordelfbastockingentry"
        },
        {
            "type": "PUT",
            "url": "api/v1/wh-fba-stocking/upFbaStocking",
            "title": "修改fba备货信息",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "FBA_Stocking",
            "version": "0.0.1",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "id",
                            "description": "<p>更新id</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "version",
                            "description": "<p>更新版本</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"id\":1, 必须有\n\"version\":0, 必须有\n\"aNumber\":\"修改测试\"\n}",
                        "type": "json"
                    }
                ]
            },
            "description": "<p>用于修改fba备货信息</p>",
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/out/library/fba/WhFbaStockingController.java",
            "groupTitle": "FBA_Stocking",
            "name": "PutApiV1WhFbaStockingUpfbastocking"
        },
        {
            "type": "POST",
            "url": "api/v1/file/fileDealWith",
            "title": "xlsx 表处理数据处理接口",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"sso_token\":\"用户令牌\"\n\"ide_token\":\"接口幂等令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "File",
            "version": "0.0.1",
            "description": "<p>用于xlsx 表处理数据处理接口</p>",
            "parameter": {
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "需要上传成功后的文件对象\n{\"uploadSuccessList\": [\n{\n\"remark\": \"上传成功\",\n\"createDate\": 1561974431274,\n\"createUser\": \"eeee\",\n\"modifyDate\": null,\n\"modifyUser\": null,\n\"delOrNot\": null,\n\"currentPage\": null,\n\"pageSize\": null,\n\"createDates\": null,\n\"version\": null,\n\"id\": 4,\n\"uid\": 406,\n\"uuidName\": \"01e57f3d94ee49cf86d6b37826b96d6b.xlsx\",\n\"name\": \"新建 Microsoft Excel 工作表.xlsx\",\n\"filePath\": \"E:/file/\",\n\"uStatus\": 0,\n\"deStatus\": null,\n\"url\": null,\n\"uploadSuccessList\": null\n}\n]\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/file/FileDealWithController.java",
            "groupTitle": "File",
            "name": "PostApiV1FileFiledealwith"
        },
        {
            "type": "POST",
            "url": "api/v1/wh-transfer-out-library/delTransferInfo",
            "title": "删除调拨出库跟条目",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"sso-token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Transfer",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "tNumber",
                            "description": "<p>主表单 id</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "List",
                            "optional": false,
                            "field": "eIds",
                            "description": "<p>子表单集合</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\"tNumber\":\"DB6543380444191129600\",\n\"eIds\":[1,2,3,4]\n注: 如果你只传一个tNumber 这里会帮你你全部删除以及下面字表信息\n如果你传了tNumber 跟 eIds[] 只会删除 字表里面的数据\n}",
                        "type": "json"
                    }
                ]
            },
            "version": "0.0.1",
            "description": "<p>用于删除调拨出库跟条目</p>",
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/out/library/transfer/WhTransferOutLibraryController.java",
            "groupTitle": "Transfer",
            "name": "PostApiV1WhTransferOutLibraryDeltransferinfo"
        },
        {
            "type": "POST",
            "url": "api/v1/wh-transfer-out-library/findByTransferInfo",
            "title": "查询调拨出库跟条目",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Transfer",
            "version": "0.0.1",
            "description": "<p>用于查询调拨出库跟条目</p>",
            "parameter": {
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"tNumber\": \"DB6543380444191129600\"\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/out/library/transfer/WhTransferOutLibraryController.java",
            "groupTitle": "Transfer",
            "name": "PostApiV1WhTransferOutLibraryFindbytransferinfo"
        },
        {
            "type": "POST",
            "url": "api/v1/wh-transfer-out-library/saveTransferInfo",
            "title": "新增调拨出库跟条目",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"sso-token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Transfer",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "wayNumber",
                            "description": "<p>运单号</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "mIWarId",
                            "description": "<p>移入仓 id</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "rWarId",
                            "description": "<p>移出仓 id</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"wayNumber\":\"运单号\",\n\"rWarId\":22,\n\"mIWarId\":2\t,\n\"entry\":[{\"sku\":\"BOFGDMHB30\",\"quantity\":80,\"position\":\"A仓\"}..以及一些属性]\n}",
                        "type": "json"
                    }
                ]
            },
            "version": "0.0.1",
            "description": "<p>用于新增调拨出库跟条目</p>",
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/out/library/transfer/WhTransferOutLibraryController.java",
            "groupTitle": "Transfer",
            "name": "PostApiV1WhTransferOutLibrarySavetransferinfo"
        },
        {
            "type": "POST",
            "url": "api/v1/wh-transfer-out-library/upTransferState",
            "title": "更新标记发货",
            "header": {
                "examples": [
                    {
                        "title": "请求头Header",
                        "content": "{\n\"sso-token\":\"用户令牌\"\n}",
                        "type": "json"
                    }
                ]
            },
            "group": "Transfer",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "String",
                            "optional": false,
                            "field": "tNumber",
                            "description": "<p>更新单号</p>"
                        },
                        {
                            "group": "Parameter",
                            "type": "Integer",
                            "optional": false,
                            "field": "version",
                            "description": "<p>版本</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求样例：",
                        "content": "{\n\"tNumber\":\"DB6544000455125499904\",\n\"version\":0 必传\n}",
                        "type": "json"
                    }
                ]
            },
            "version": "0.0.1",
            "description": "<p>用于更新标记发货</p>",
            "success": {
                "fields": {
                    "success": [
                        {
                            "group": "success",
                            "type": "Object",
                            "optional": false,
                            "field": "data",
                            "description": "<p>请求的数据</p>"
                        },
                        {
                            "group": "success",
                            "type": "String",
                            "optional": false,
                            "field": "msg",
                            "description": "<p>信息</p>"
                        },
                        {
                            "group": "success",
                            "type": "int",
                            "optional": false,
                            "field": "code",
                            "description": "<p>-1 代表错误 200代表请求成功</p>"
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "成功返回样列:",
                        "content": "{\"code\":\"200\",\"msg\":\"success\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "error": {
                "examples": [
                    {
                        "title": "失败返回样例子:",
                        "content": "{\"code\":\"-1\",\"msg\":\"error\",\"data\":\"{}\"}",
                        "type": "json"
                    }
                ]
            },
            "filename": "./wh_projects/src/main/java/com/wh/controller/out/library/transfer/WhTransferOutLibraryController.java",
            "groupTitle": "Transfer",
            "name": "PostApiV1WhTransferOutLibraryUptransferstate"
        }
    ]
});
