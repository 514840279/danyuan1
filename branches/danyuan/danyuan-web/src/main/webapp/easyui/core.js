(function () {
    $.USER = {};
//阻止退格键回到上一页面
    $(document).keydown(function (e) {
        var target = e.target;
        var tag = e.target.tagName.toUpperCase();
        if (e.keyCode == 8) {
            if ((tag == 'INPUT' && !$(target).attr("readonly")) || (tag == 'TEXTAREA' && !$(target).attr("readonly"))) {
                if ((target.type.toUpperCase() == "RADIO") || (target.type.toUpperCase() == "CHECKBOX")) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    });


    $.fn.serializeJson = function () {
        var serializeObj = {};
        $(this.serializeArray()).each(function () {
            serializeObj[this.name] = $.trim(this.value);
        });
        return serializeObj;
    };

    /**
     * 执行指令，需要通过$(id)调用。
     *    1.如果被调用对象是个form则会将form中的所有数据转为json发送到服务器
     *  2.如果被调用对象是个grid则会将选中行以对象的数组形式发送到服务器。
     *  3.参数：(以下是默认值){
			method:"post",
			url:"",
			callback:function(op){},//在http请求成功时调用
			param:{},//对象形式的传参，如果使用form/grid发送，冲突的属性会用这里的进行覆盖,没冲突的就合并后发送。
			onBefore:function(smdata){},//在请求之前调用,会把当前的调用对象对应的dom引用传递过去，方便进行其他操作。
			onAfter:function(smdata){},//在请求返回之后调用，可能是失败。,会把当前的调用对象对应的dom引用传递过去，方便进行其他操作。
		    onError:function(){}
		}
     */
    $.fn.call = function (opt) {

        var thisPointer = this;
        if (opt && typeof(opt) != "object") {
            $.messager.show({
                title: '错误',
                msg: "call 方法参数错误，需要通过对象的方式传递."
            });
        }
        //默认参数
        this.options = $.extend({
            method: "post",
            url: "",
            enableMask: true,//是否启用遮罩
            disableEl: "",//禁用的元素
            timeout: 300000,
            callback: function (op) {
            },
            param: {},
            onBefore: function (senddata, sdata) {
                //$.showMask();
            },
            onAfter: function (senddata, sdata) {
                //$.hideMask();
            },
            onError: function () {
            }
        }, opt);

        var met = "post";

        var smdata = this.options.param;

        if (this.options.enableMask) {
            CommonPerson.Base.LoadingPic.FullScreenShow();
        }
        if ($(this).is("form")) {
            //校验form
            if (!$(this).form("validate") && met !== 'delete') {
                //$.progress("close");
                CommonPerson.Base.LoadingPic.FullScreenHide();
                return false;
            }
        }

        var isGrid = false;
        var dgObj;
        if ($(this).attr("class") == "easyui-datagrid") {
            isGrid = true;
            dgObj = $(this);
        }
        //发送前事件触发
        if (thisPointer.options.onBefore && typeof(thisPointer.options.onBefore) == "function") {
            var ret = thisPointer.options.onBefore.call(thisPointer, smdata);
            if (ret === false && typeof(ret) !== "undefined") {
                //如果返回false或者什么都不返回，则直接终止提交
                //$.progress("close");
                CommonPerson.Base.LoadingPic.FullScreenHide();
                return;
            } else if (typeof(ret) === "object") {
                //如果返回了新的参数，则将新的参数与即将要提交的参数合并。
                smdata = $.extend(smdata, ret);
            }
        }

        var url = this.options.url;
        if (isGrid) {
            url = $(dgObj).attr("uniteUrl");
            var searchForm = $(dgObj).attr("uniteSearchForm");
            smdata = $.extend(smdata, $(searchForm).serializeJson());
        }
        //执行ajax调用
        $.ajax({
            headers: $.uniteToken(true),
            type: met,
            timeout: this.options.timeout,
            url: url,
            dataType: "json",
            data: smdata,
            error: function () {
                //$.progress('close');
                CommonPerson.Base.LoadingPic.FullScreenHide();
            },
            beforeSend: function (senddata, sdata) {

            },
            complete: function (senddata, sdata) {

            },
            success: function (data, textStatus, resp) {

                setTimeout(function () {
                    CommonPerson.Base.LoadingPic.FullScreenHide();
                }, 300);

//                var __k__ = resp.getResponseHeader("__k__");
//                var __token__ = resp.getResponseHeader("__token__");
//
//                //alert("after :" + __k__);
//                if (url != "json/checkLogin.action") {
//                    $.USER["COOKIE_K"] = __k__;
//                    $.USER["COOKIE_TOKEN"] = __token__;
//                }


                switch (textStatus) {
                    case "timeout":
                        $.messager.show({
                            title: '提示',
                            msg: "抱歉，请求超时，请稍后再次尝试."
                        });
                        break;
                    case "error":
                        $.messager.show({
                            title: '提示',
                            msg: "抱歉，请求错误，请稍后再次尝试."
                        });
                        break;
                    case "success":
                        if (data && data.logout) {
                            top.$.uniteReLogin();
                            CommonPerson.Base.LoadingPic.FullScreenHide();
                            return false;
                        }
                        // grid 处理自动填充数据
                        if (isGrid) {
                            $(dgObj).datagrid('loadData', data);
                        }

                        if (thisPointer.options.callback && typeof(thisPointer.options.callback) == "function") {
                            thisPointer.options.callback(data, thisPointer);
                        }

                        break;
                    default :
                        $.messager.show({
                            title: '提示',
                            msg: "未知错误，请尝试刷新页面或者重新登陆."
                        });
                }
                //发送后事件触发
                if (thisPointer.options.onAfter && typeof(thisPointer.options.onAfter) == "function") {
                    thisPointer.options.onAfter(smdata, thisPointer);
                }
            }
        });
    };

    /**
     * datagrid初始化方法
     * @param obj
     */
    $.fn.datagridInit = function (obj) {
        var thisGrid = this;
        if (obj && typeof(obj) != "object") {
            $.messager.show({
                title: '错误',
                msg: "datagridInit 方法参数错误，需要通过对象的方式传递."
            });
        }
        setTimeout(function () {

            var p = $(thisGrid).datagrid('getPager');
            var url = $(thisGrid).attr("uniteUrl");
            var pageSize = $(p).pagination('options').pageSize;
            var pageNumber = $(p).pagination('options').pageNumber;

            //默认参数
            var searchForm = $(thisGrid).attr("uniteSearchForm");

            var defParam = $.extend({page: pageNumber, rows: pageSize}, $(searchForm).serializeJson());
            var autoLoad = true;
            if (obj && obj.autoLoad == false) {
                autoLoad = false;
            }
            var enableMask = true;
            if (obj && obj.enableMask == false) {
                enableMask = false;
            }

            // 绑定上一页下一页及刷新事件
            $(p).pagination({
                onSelectPage: function (pageNumber, pageSize) {

                    $(p).pagination('loading');

                    var curtotal = $(p).pagination('options').total;

                    var curParam = $.extend({page: pageNumber, rows: pageSize}, $(searchForm).serializeJson());

                    if (!enableMask) {
                        $(thisGrid).call({
                            url: url,
                            param: curParam,
                            enableMask: false
                        });
                    }
                    $(thisGrid).call({
                        url: url,
                        param: curParam
                    });

                    $(p).pagination('loaded');
                }
            });

            // 自动加载
            if (autoLoad) {
                if (!enableMask) {
                    $(thisGrid).call({
                        url: url,
                        param: defParam,
                        enableMask: false
                    });
                } else {
                    $(thisGrid).call({
                        url: url,
                        param: defParam
                    });
                }

            }
        }, 200);
    };

    /**
     * combobox初始化刷新
     * @param obj
     */
    $.fn.comboboxLoad = function () {
        var thisCombobox = this;
        $(thisCombobox).combobox({    
            valueField:'id',    
            textField:'text'   
        });  
        var url =url = "json/uniteDic.action";
       var dicid = $(thisCombobox).attr("uniteDicid");
       var showType = $(thisCombobox).attr("showType");
       setTimeout(function(){
    	   $(this).call({
               url: url,
               param:{"dicid":dicid,"showType":showType},
               enableMask: true,
               callback: function (data) {
                   $(thisCombobox).combobox('loadData', data.object);
                   var resData = $(thisCombobox).combobox('getData');
                   if (resData.length > 0) {
                       $(thisCombobox).combobox('select', resData[0].id);
                   }
               }
           });
       },200);
    };
    
    /**
     * 用户添加combo
     * @param obj
     */
    $.fn.comboboxLoadUser = function () {
        var thisCombobox = this;
        var url = $(thisCombobox).attr("uniteUrl");
        $(thisCombobox).call({
            url: url,
            callback: function (data) {
                $(thisCombobox).combobox('loadData', data);
                var resData = $(thisCombobox).combobox('getData');
                if (resData.length > 0) {
                    $(thisCombobox).combobox('select', data[0].valueField);
                }
            }
        });
    };

    // easyui扩展
    $.extend($.fn.tabs.methods, {
        //显示遮罩
        loading: function (jq, msg) {
            return jq.each(function () {
                var panel = $(this).tabs("getSelected");
                if (msg == undefined) {
                    msg = "正在加载数据，请稍候...";
                }
                $("<div class=\"datagrid-mask\"></div>").css({
                    display: "block",
                    width: panel.width(),
                    height: panel.height()
                }).appendTo(panel);
                $("<div class=\"datagrid-mask-msg\"></div>").html(msg).appendTo(panel).css({
                    display: "block",
                    left: (panel.width() - $("div.datagrid-mask-msg", panel).outerWidth()) / 2,
                    top: (panel.height() - $("div.datagrid-mask-msg", panel).outerHeight()) / 2
                });
            });
        }
        ,
        //隐藏遮罩
        loaded: function (jq) {
            return jq.each(function () {
                var panel = $(this).tabs("getSelected");
                panel.find("div.datagrid-mask-msg").remove();
                panel.find("div.datagrid-mask").remove();
            });
        }
    });


    //扩展jquery方法
    $.extend({
        /**
         * 执行事件
         */
        bindEvent: function (inst, eventName, args) {
            if (inst.events && inst.events[eventName] && inst.events[eventName].length > 0) {
                $.each(inst.events[eventName], function (key, value) {
                    if (value && typeof(value) === "function") {
                        value.apply(inst, args);
                    }
                });
            }
        },
//        uniteToken: function (isObj) {
//            var __k__ = $.USER["COOKIE_K"];
//            //alert("befor: " + __k__);
//            var __token__ = $.USER["COOKIE_TOKEN"];
//            if (!isObj) {
//                return "?__k__=" + __k__ + "&__token__=" + __token__;
//            } else {
//                var headers = {};
//                headers["__k__"] = __k__;
//                headers["__token__"] = __token__;
//
//                return headers;
//            }
//        },
        /**
         * 弹出重新登陆
         */
        uniteReLogin: function () {
            $.messager.alert("提示", "当前用户在其他地方登陆或登陆超时，请重新登录！", "info", function () {
                location.href = "/unite/login.jsp";
            });
        },
        closeAllTabs: function () {
            var tabs = $('#main-tabs').tabs('tabs');
            $.each(tabs, function (key, val) {
                $('#main-tabs').tabs('close', 1);
            });
        },
        addTabs: function (url, title) {
            var exist_tab = $('#main-tabs').tabs('getTab', title);
            if (exist_tab) {
                $('#main-tabs').tabs('select', title);
            } else {
                $('#main-tabs').tabs('add', {
                    'id': 'tab',
                    title: title,
                    fit: true,
//				content : content,
                    href: url,
                    closable: true,
/*                    onLoad:function(title,index){
                    	$(".combo-text").attr("readonly","readonly");
                    }*/
                });
            }
        },
        closeTabs: function (title) {
            var exist_tab = $('#main-tabs').tabs('getTab', title);
            if (exist_tab) {
                $('#main-tabs').tabs('close', title);
            }
        }
    });
})(jQuery);

// validatebox 扩展
$.extend($.fn.validatebox.defaults.rules, {

    minLength: { // 判断最小长度

        validator: function (value, param) {

            return value.length >= param[0];

        },

        message: "最少输入 {0} 个字符。"

    },

    length: {
        validator: function (value, param) {

            var len = $.trim(value).length;

            return len >= param[0] && len <= param[1];

        },

        message: "输入内容长度必须介于{0}和{1}之间."

    },

    phone: {// 验证电话号码

        validator: function (value) {

            return /^(((d{2,3}))|(d{3}-))?((0d{2,3})|0d{2,3}-)?[1-9]d{6,7}(-d{1,4})?$/i.test(value);

        },

        message: "格式不正确,请使用下面格式:020-88888888"

    },

    mobile: {// 验证手机号码

        validator: function (value) {

            return /^(13|15|18)d{9}$/i.test(value);

        },

        message: "手机号码格式不正确"

    },

    idcard: {// 验证身份证

        validator: function (value) {

            return /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/i.test(value);

        },

        message: "身份证号码格式不正确"

    },

    intOrFloat: {// 验证整数或小数

        validator: function (value) {

            return /^d+(.d+)?$/i.test(value);

        },

        message: "请输入数字，并确保格式正确"

    },

    currency: {// 验证货币

        validator: function (value) {

            return /^d+(.d+)?$/i.test(value);

        },

        message: "货币格式不正确"

    },

    qq: {// 验证QQ,从10000开始

        validator: function (value) {

            return /^[1-9]d{4,9}$/i.test(value);

        },

        message: "QQ号码格式不正确"

    },

    integer: {// 验证整数

        validator: function (value) {

            return /^[+]?[1-9]+d*$/i.test(value);

        },

        message: "请输入整数"

    },

    chinese: {// 验证中文

        validator: function (value) {

            return /^[u0391-uFFE5]+$/i.test(value);

        },

        message: "请输入中文"

    },

    english: {// 验证英语

        validator: function (value) {

            return /^[A-Za-z]+$/i.test(value);

        },

        message: "请输入英文"

    },

    unnormal: {// 验证是否包含空格和非法字符

        validator: function (value) {

            return /.+/i.test(value);

        },

        message: "输入值不能为空和包含其他非法字符"

    },

    username: {// 验证用户名

        validator: function (value) {

            return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);

        },

        message: "用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）"

    },

    faxno: {// 验证传真

        validator: function (value) {

//            return /^[+]{0,1}(d){1,3}[ ]?([-]?((d)|[ ]){1,12})+$/i.test(value);

            return /^(((d{2,3}))|(d{3}-))?((0d{2,3})|0d{2,3}-)?[1-9]d{6,7}(-d{1,4})?$/i.test(value);

        },

        message: "传真号码不正确"

    },

    zip: {// 验证邮政编码

        validator: function (value) {

            return /^[1-9]d{5}$/i.test(value);

        },

        message: "邮政编码格式不正确"

    },

    ip: {// 验证IP地址

        validator: function (value) {

            return /d+.d+.d+.d+/i.test(value);

        },

        message: "IP地址格式不正确"

    },

    name: {// 验证姓名，可以是中文或英文

        validator: function (value) {

            return /^[u0391-uFFE5]+$/i.test(value) | /^w+[ws]+w+$/i.test(value);

        },

        message: "请输入姓名"

    },

    carNo: {

        validator: function (value) {

            return /^[u4E00-u9FA5][da-zA-Z]{6}$/.test(value);

        },

        message: "车牌号码无效（例：粤J12350）"

    },

    carenergin: {

        validator: function (value) {

            return /^[a-zA-Z0-9]{16}$/.test(value);

        },

        message: "发动机型号无效(例：FG6H012345654584)"

    },

    email: {

        validator: function (value) {

            return /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(value);

        },

        message: "请输入有效的电子邮件账号(例：abc@126.com)"

    },

    msn: {

        validator: function (value) {

            return /^w+([-+.]w+)*@w+([-.]w+)*.w+([-.]w+)*$/.test(value);

        },

        message: "请输入有效的msn账号(例：abc@hotnail(msn/live).com)"

    }, same: {

        validator: function (value, param) {

            if ($("#" + param[0]).val() != "" && value != "") {

                return $("#" + param[0]).val() == value;

            } else {

                return true;

            }

        },

        message: "两次输入的密码不一致！"

    },
    /*必须和某个字段相等*/
    equalTo: {
        validator: function (value, param) {
            return value == $(param[0]).val();
        },
        message: '两次输入的字符不一至'
    },
    /* 验证项目经验的期间 */
    workDate: {
        validator: function (value) {
            return /^[0-9]{4}\.[0-9]{2}-(至今|[0-9]{4}\.[0-9]{2})$/.test(value);
        },
        message: '期間格式不正确，请填写如：2014.01-2014.06 或 2014.01-至今 格式'
    },
    /* 验证 言語＆関連ソフト */
    languageDB: {
        validator: function (value) {
            return /^[A-Za-z0-9_. #]+&\w*$/.test(value);
        },
        message: '言語＆関連ソフト格式不正确，请填写如：java&oracle 格式'
    }
});

/**
 * 字符串集合
 */
$.arrayStrToJSON = function (array, objName) {

    var params = "";

    $.each(array, function (index, value) {
        params += ',"' + objName + '[' + index + ']":"' + value + '"';
        //alert(params);
    });

    params = params.substr(1);
    params = "{" + params + "}";

    params = JSON.parse(params);

    return params;
};

/**
 * 实体bean集合
 * @param array
 * @param objName
 * @returns {string}
 */
$.arrayObjToJSON = function (array, objName) {

    var params = "";

    for (var i = 0; i < array.length; i++) {
        for (var key in array[i]) {
            //alert("key：" + key + ",value：" + array[i][key]);

            params += ',"' + objName + '[' + i + '].' + key + '":"' + array[i][key] + '"';
        }
    }
    params = params.substr(1);
    params = "{" + params + "}";
    params = JSON.parse(params);

    return params;

};

$.objToJSON = function (array, objName) {
    var params = "";

    $.each(array, function (index, value) {
        params += ',"' + objName + '.' + index + '":"' + value + '"';
    });

    params = params.substr(1);
    params = "{" + params + "}";

    params = JSON.parse(params);

    return params;
};


////兼容火狐、IE8
////显示遮罩层
//$.showMask = function () {
//    $("#mask").css("height", $(document).height());
//    $("#mask").css("width", $(document).width());
//    $("#mask").show();
//};
////隐藏遮罩层
//$.hideMask = function () {
//    $("#mask").hide();
//};


function Map() {
    this.container = new Object();
}


Map.prototype.put = function (key, value) {
    this.container[key] = value;
};


Map.prototype.get = function (key) {
    return this.container[key];
};


Map.prototype.keySet = function () {
    var keyset = new Array();
    var count = 0;
    for (var key in this.container) {
// 跳过object的extend函数
        if (key == 'extend') {
            continue;
        }
        keyset[count] = key;
        count++;
    }
    return keyset;
};


Map.prototype.size = function () {
    var count = 0;
    for (var key in this.container) {
// 跳过object的extend函数
        if (key == 'extend') {
            continue;
        }
        count++;
    }
    return count;
};


Map.prototype.remove = function (key) {
    delete this.container[key];
};


Map.prototype.toString = function () {
    var str = "";
    for (var i = 0, keys = this.keySet(), len = keys.length; i < len; i++) {
        str = str + keys[i] + "=" + this.container[keys[i]] + ";\n";
    }
    return str;
};

$.initCalendarMap = function (data) {
    var map = new Map();

    if (data) {
        map.put("month", data.month);
        map.put("1", data.one.substr(1));
        map.put("2", data.two.substr(1));
        map.put("3", data.three.substr(1));
        map.put("4", data.four.substr(1));
        map.put("5", data.five.substr(1));
        map.put("6", data.six.substr(1));
        map.put("7", data.seven.substr(1));
        map.put("8", data.eight.substr(1));
        map.put("9", data.nine.substr(1));
        map.put("10", data.ten.substr(1));
        map.put("11", data.eleven.substr(1));
        map.put("12", data.twelve.substr(1));
        map.put("13", data.thirteen.substr(1));
        map.put("14", data.fourteen.substr(1));
        map.put("15", data.fifteen.substr(1));
        map.put("16", data.sixteen.substr(1));
        map.put("17", data.seventeen.substr(1));
        map.put("18", data.eighteen.substr(1));
        map.put("19", data.nineteen.substr(1));
        map.put("20", data.twenty.substr(1));
        map.put("21", data.twentyone.substr(1));
        map.put("22", data.twentytwo.substr(1));
        map.put("23", data.twentythree.substr(1));
        map.put("24", data.twentyfour.substr(1));
        map.put("25", data.twentyfive.substr(1));
        map.put("26", data.twentysix.substr(1));
        map.put("27", data.twentyseven.substr(1));
        map.put("28", data.twentyeight.substr(1));
        map.put("29", data.twentynine.substr(1));
        map.put("30", data.thirty.substr(1));
        map.put("31", data.thirtyone.substr(1));
    }
    return map;
};

/**
 * 时间对象的格式化;
 */
Date.prototype.format = function(format){
    /*
     * eg:format="YYYY-MM-dd hh:mm:ss";
     */
    var o = {
        "M+" :  this.getMonth()+1,  //month
        "d+" :  this.getDate(),     //day
        "h+" :  this.getHours(),    //hour
        "m+" :  this.getMinutes(),  //minute
        "s+" :  this.getSeconds(), //second
        "q+" :  Math.floor((this.getMonth()+3)/3),  //quarter
        "S"  :  this.getMilliseconds() //millisecond
    };

    if(/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }

    for(var k in o) {
        if(new RegExp("("+ k +")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
        }
    }
    return format;
};


/*
 * 获得时间差,时间格式为 年-月-日 小时:分钟:秒 或者 年/月/日 小时：分钟：秒
 * 其中，年月日为全格式，例如 ： 2010-10-12 01:00:00
 * 返回精度为：秒，分，小时，天
 */
$.getDateDiff = function(startTime, endTime, diffType) {
    //将xxxx-xx-xx的时间格式，转换为 xxxx/xx/xx的格式
    startTime = startTime.replace(/\-/g, "/");
    endTime = endTime.replace(/\-/g, "/");
    //将计算间隔类性字符转换为小写
    diffType = diffType.toLowerCase();
    var sTime = new Date(startTime);      //开始时间
    var eTime = new Date(endTime);  //结束时间
    //作为除数的数字
    var divNum = 1;
    switch (diffType) {
        case "second":
            divNum = 1000;
            break;
        case "minute":
            divNum = 1000 * 60;
            break;
        case "hour":
            divNum = 1000 * 3600;
            break;
        case "day":
            divNum = 1000 * 3600 * 24;
            break;
        default:
            break;
    }
    return parseInt((eTime.getTime() - sTime.getTime()) / parseInt(divNum));
};
