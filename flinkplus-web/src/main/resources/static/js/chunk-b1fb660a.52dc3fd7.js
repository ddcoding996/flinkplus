(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b1fb660a"],{"14c3":function(t,e,n){var a=n("c6b6"),r=n("9263");t.exports=function(t,e){var n=t.exec;if("function"===typeof n){var o=n.call(t,e);if("object"!==typeof o)throw TypeError("RegExp exec method returned something other than an Object or null");return o}if("RegExp"!==a(t))throw TypeError("RegExp#exec called on incompatible receiver");return r.call(t,e)}},"1d0b":function(t,e,n){"use strict";var a=n("e423"),r="/mng/jobInstance/queryJobInstances/";function o(t){return Object(a["a"])(r,t)}e["a"]={queryJobInstances:o}},"38a0":function(t,e,n){"use strict";n("ac1f"),n("5319");var a=n("e423"),r="/mng/job/queryJob/",o="/mng/job/queryJobs",i="/mng/job/addJob",s="/mng/job/updateJob",c="/mng/job//deleteJob/{jobId}",u="/mng/job/deleteJobs",l="/mng/job/{jobId}/jarList",b="/mng/job/{jobId}/uploadJar",d="/mng/job/startJob/{jobId}",p="/mng/job/startJobs",f="/mng/job/reStartJob/{jobId}",g="/mng/job/reStartJobs",v="/mng/job/stopJob/{jobId}",j="/mng/job/stopJobs";function h(t){return Object(a["a"])(r+t.jobId)}function m(t){return Object(a["a"])(o,t)}function y(t){return Object(a["b"])(i,t)}function I(t){return Object(a["b"])(s,t)}function x(t){return Object(a["b"])(c.replace("{jobId}",t.jobId),t)}function _(t){return Object(a["b"])(u,t.idList)}function J(t){return Object(a["a"])(l.replace("{jobId}",t.jobId))}function k(t){return Object(a["a"])(d.replace("{jobId}",t.jobId))}function O(t){return Object(a["b"])(p,t.idList)}function C(t){return Object(a["a"])(f.replace("{jobId}",t.jobId))}function S(t){return Object(a["b"])(g,t.idList)}function w(t){return Object(a["a"])(v.replace("{jobId}",t.jobId))}function E(t){return Object(a["b"])(j,t.idList)}e["a"]={UPLOAD_JAR_URL:b,queryJob:h,queryJobs:m,addJob:y,updateJob:I,deleteJob:x,deleteJobs:_,jarList:J,startJob:k,startJobs:O,restartJob:C,restartJobs:S,stopJob:w,stopJobs:E}},"3e03":function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[1===t.type?n("div",[n("JobDetailCustom")],1):t._e()])},r=[],o=n("d4ec"),i=n("99de"),s=n("7e84"),c=n("262e"),u=n("9ab4"),l=n("60a3"),b=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("Tabs",[n("TabPane",{attrs:{label:"作业信息",name:"basic"}},[n("Divider",[t._v("基础信息")]),n("Row",{attrs:{gutter:10}},[n("Col",{attrs:{span:"12"}},[t._v("作业 ID : "+t._s(t.job.id))]),n("Col",{attrs:{span:"12"}},[t._v("作业名称 : "+t._s(t.job.name))])],1),n("Row",{attrs:{gutter:10}},[n("Col",{attrs:{span:"12"}},[t._v("作业类型 : "+t._s(t.job.typeDesc))]),n("Col",{attrs:{span:"12"}},[t._v("作业描述 : "+t._s(t.job.description))])],1),n("Row",{attrs:{gutter:10}},[n("Col",{attrs:{span:"12"}},[t._v("创建时间 : "+t._s(t._f("dateFormat")(t.job.createTime)))]),n("Col",{attrs:{span:"12"}},[t._v("更新时间 : "+t._s(t._f("dateFormat")(t.job.updateTime)))])],1),n("Row",{attrs:{gutter:10}},[n("Col",{attrs:{span:"12"}},[t._v("开始时间 : "+t._s(t._f("dateFormat")(t.job.lastStartTime)))]),n("Col",{attrs:{span:"12"}},[t._v("结束时间 : "+t._s(t._f("dateFormat")(t.job.lastStopTime)))])],1),n("Divider",[t._v("作业配置")]),n("Row",{attrs:{gutter:10}},[n("Col",{attrs:{span:"12"}},[t._v("客户端版本 : "+t._s(t.job.clientVersion))]),n("Col",{attrs:{span:"12"}},[t._v("执行文件 : "+t._s(t.job.config.jarName))])],1),n("Row",{attrs:{gutter:10}},[n("Col",{attrs:{span:"12"}},[t._v("MainClass : "+t._s(t.job.config.mainClass))]),n("Col",{attrs:{span:"12"}},[t._v("程序参数 : "+t._s(t.job.config.args))])],1),n("Divider",[t._v("运行参数")]),n("Row",{attrs:{gutter:10}},[n("Col",{attrs:{span:"12"}},[t._v("作业并行度 : "+t._s(t.job.config.parallelism))]),n("Col",{attrs:{span:"12"}})],1)],1),n("TabPane",{attrs:{label:"作业实例",name:"job"}},[n("div",[n("Table",{ref:"selection",attrs:{stripe:"",columns:t.jobInstanceListColumns,data:t.jobInstanceList},scopedSlots:t._u([{key:"status",fn:function(t){var e=t.row;return[n("ButtonJobStatus",{attrs:{size:"small",status:e.status,text:e.statusDesc}})]}}])},[n("template",{slot:"name"},[t._v(" "+t._s(t.job.name)+" ")])],2)],1),n("div",{staticStyle:{"margin-top":"10px",padding:"5px",background:"#f8f8f9"}},[n("Row",{attrs:{gutter:10}},[n("Col",{attrs:{align:"right"}},[n("Page",{attrs:{total:t.jobInstanceQueryCondition.total,current:t.jobInstanceQueryCondition.pageNum,"page-size":t.jobInstanceQueryCondition.pageSize,"page-size-opts":[5,10,20,50,100],"show-total":"","show-sizer":"","show-elevator":"",size:"small"},on:{"on-change":t.jobInstancePageChange,"on-page-size-change":t.jobInstancePageSizeChange}})],1)],1)],1)]),n("TabPane",{attrs:{label:"作业监控",name:"monitor",disabled:""}}),n("div",{staticStyle:{"margin-bottom":"10px",padding:"5px",background:"#f8f8f9"},attrs:{slot:"extra"},slot:"extra"},[n("Button",{staticStyle:{"margin-right":"10px"},attrs:{type:"success",size:"small",disabled:t.job.authMap&&!t.job.authMap.start},on:{click:t.clickStart}},[t._v("启动")]),n("Button",{staticStyle:{"margin-right":"10px"},attrs:{type:"warning",size:"small",disabled:t.job.authMap&&!t.job.authMap.restart},on:{click:t.clickRestart}},[t._v("重启")]),n("Button",{staticStyle:{"margin-right":"10px"},attrs:{type:"error",size:"small",disabled:t.job.authMap&&!t.job.authMap.stop},on:{click:t.clickStop}},[t._v("停止")]),n("Button",{staticStyle:{"margin-right":"10px"},attrs:{type:"error",size:"small",disabled:t.job.authMap&&!t.job.authMap.delete},on:{click:t.clickDelete}},[t._v("删除")]),n("Button",{staticStyle:{"margin-right":"10px"},attrs:{type:"info",size:"small",disabled:t.job.authMap&&!t.job.authMap.edit},on:{click:t.clickEdit}},[t._v("编辑")])],1)],1)],1)},d=[],p=(n("caad"),n("d3b7"),n("bee2")),f=n("38a0"),g=n("1d0b"),v=n("5eb3"),j=n("acdc"),h=function(t){function e(){var t;return Object(o["a"])(this,e),t=Object(i["a"])(this,Object(s["a"])(e).apply(this,arguments)),t.rt={jobId:""},t.job={config:{}},t.jobInstanceListColumns=[{title:"ID",key:"id",align:"center",minWidth:50},{title:"名称",key:"name",align:"center",minWidth:200,slot:"name"},{title:"类型",align:"center",minWidth:150,render:function(t,e){return t("div",e.row.job.typeDesc)}},{title:"创建时间",key:"createTime",align:"center",minWidth:166,render:function(t,e){return t("div",v["a"].dateFormat(e.row.createTime))}},{title:"开始时间",key:"startTime",align:"center",minWidth:166,render:function(t,e){return t("div",v["a"].dateFormat(e.row.startTime))}},{title:"结束时间",key:"stopTime",align:"center",minWidth:166,render:function(t,e){return t("div",v["a"].dateFormat(e.row.stopTime))}},{title:"Flink UI",key:"lastUiAddress",align:"center",minWidth:250,ellipsis:!0,render:function(e,n){return e("a",{on:{click:function(){t.handClickJobInstanceListColumnUiAddress(n.row)}}},n.row.appId)}},{title:"状态",key:"status",align:"center",minWidth:100,slot:"status",fixed:"right"}],t.jobInstanceList=[],t.jobInstanceQueryCondition={total:100,pageNum:1,pageSize:10},t.jobTimer=null,t}return Object(c["a"])(e,t),Object(p["a"])(e,[{key:"jobInstancePageChange",value:function(t){this.jobInstanceQueryCondition.pageNum=t,this.getJobInstanceList()}},{key:"jobInstancePageSizeChange",value:function(t){this.jobInstanceQueryCondition.pageSize=t,this.getJobInstanceList()}},{key:"clickStart",value:function(){var t=this;f["a"].startJob({jobId:this.rt.jobId}).then((function(e){t.$Notice.success({title:"启动作业成功"}),t.getJobInstanceList()})).catch((function(e){t.$Notice.warning({title:"启动作业失败",desc:e.msg})})).finally((function(){t.jobTimer=t.getJobTimer()}))}},{key:"handClickJobInstanceListColumnUiAddress",value:function(t){window.open(t.uiAddress,"_blank")}},{key:"clickRestart",value:function(){var t=this;f["a"].restartJob({jobId:this.rt.jobId}).then((function(e){t.$Notice.success({title:"重启作业成功"})})).catch((function(e){t.$Notice.warning({title:"重启作业失败",desc:e.msg})}))}},{key:"clickStop",value:function(){var t=this;f["a"].stopJob({jobId:this.rt.jobId}).then((function(e){t.$Notice.success({title:"停止作业成功"})})).catch((function(e){t.$Notice.warning({title:"停止作业失败",desc:e.msg})}))}},{key:"clickDelete",value:function(){var t=this;f["a"].deleteJob({jobId:this.rt.jobId}).then((function(e){t.$Notice.success({title:"删除作业成功"}),t.$router.push({path:"/page/job/list"})})).catch((function(e){t.$Notice.warning({title:"删除作业失败",desc:e.msg})}))}},{key:"clickEdit",value:function(){this.$router.push({path:"/page/job/edit",query:{id:this.rt.jobId}})}},{key:"getJob",value:function(){var t=this;f["a"].queryJob({jobId:this.rt.jobId}).then((function(e){t.job=e,[3,4,5,6,void 0].includes(t.job.lastStatus)&&t.clearJobTimer()})).catch((function(e){t.$Notice.error({title:e.msg})}))}},{key:"getJobTimer",value:function(){var t=this;return setInterval((function(){t.getJob(),t.getJobInstanceList()}),1e3)}},{key:"clearJobTimer",value:function(){clearInterval(this.jobTimer),this.jobTimer=null}},{key:"getJobInstanceList",value:function(){var t=this;g["a"].queryJobInstances({jobId:this.rt.jobId,pageNum:this.jobInstanceQueryCondition.pageNum,pageSize:this.jobInstanceQueryCondition.pageSize}).then((function(e){t.jobInstanceList=e.list,t.jobInstanceQueryCondition.total=e.total})).catch((function(e){t.$Notice.error({title:e.msg})}))}},{key:"parseRouter",value:function(){this.rt.jobId=this.$route.query.id}},{key:"mounted",value:function(){this.parseRouter(),this.getJob(),this.getJobInstanceList()}},{key:"beforeDestroy",value:function(){this.clearJobTimer()}}]),e}(l["c"]);h=u["a"]([Object(l["a"])({components:{ButtonJobStatus:j["a"]}})],h);var m=h,y=m,I=n("2877"),x=Object(I["a"])(y,b,d,!1,null,"7f7f8075",null),_=x.exports,J=function(t){function e(){var t;return Object(o["a"])(this,e),t=Object(i["a"])(this,Object(s["a"])(e).apply(this,arguments)),t.type=1,t}return Object(c["a"])(e,t),e}(l["c"]);J=u["a"]([Object(l["a"])({components:{JobDetailCustom:_}})],J);var k=J,O=k,C=Object(I["a"])(O,a,r,!1,null,"1249b8f4",null);e["default"]=C.exports},5319:function(t,e,n){"use strict";var a=n("d784"),r=n("825a"),o=n("7b0b"),i=n("50c4"),s=n("a691"),c=n("1d80"),u=n("8aa5"),l=n("14c3"),b=Math.max,d=Math.min,p=Math.floor,f=/\$([$&'`]|\d\d?|<[^>]*>)/g,g=/\$([$&'`]|\d\d?)/g,v=function(t){return void 0===t?t:String(t)};a("replace",2,(function(t,e,n,a){return[function(n,a){var r=c(this),o=void 0==n?void 0:n[t];return void 0!==o?o.call(n,r,a):e.call(String(r),n,a)},function(t,o){if(a.REPLACE_KEEPS_$0||"string"===typeof o&&-1===o.indexOf("$0")){var c=n(e,t,this,o);if(c.done)return c.value}var p=r(t),f=String(this),g="function"===typeof o;g||(o=String(o));var h=p.global;if(h){var m=p.unicode;p.lastIndex=0}var y=[];while(1){var I=l(p,f);if(null===I)break;if(y.push(I),!h)break;var x=String(I[0]);""===x&&(p.lastIndex=u(f,i(p.lastIndex),m))}for(var _="",J=0,k=0;k<y.length;k++){I=y[k];for(var O=String(I[0]),C=b(d(s(I.index),f.length),0),S=[],w=1;w<I.length;w++)S.push(v(I[w]));var E=I.groups;if(g){var T=[O].concat(S,C,f);void 0!==E&&T.push(E);var R=String(o.apply(void 0,T))}else R=j(O,f,C,S,E,o);C>=J&&(_+=f.slice(J,C)+R,J=C+O.length)}return _+f.slice(J)}];function j(t,n,a,r,i,s){var c=a+t.length,u=r.length,l=g;return void 0!==i&&(i=o(i),l=f),e.call(s,l,(function(e,o){var s;switch(o.charAt(0)){case"$":return"$";case"&":return t;case"`":return n.slice(0,a);case"'":return n.slice(c);case"<":s=i[o.slice(1,-1)];break;default:var l=+o;if(0===l)return e;if(l>u){var b=p(l/10);return 0===b?e:b<=u?void 0===r[b-1]?o.charAt(1):r[b-1]+o.charAt(1):e}s=r[l-1]}return void 0===s?"":s}))}}))},"5eb3":function(t,e,n){"use strict";var a=n("c1df"),r=n.n(a);function o(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"YYYY-MM-DD HH:mm:ss",n=r()(t).format(e);return"Invalid date"===n?"":n}e["a"]={dateFormat:o}},"8aa5":function(t,e,n){"use strict";var a=n("6547").charAt;t.exports=function(t,e,n){return e+(n?a(t,e).length:1)}},9263:function(t,e,n){"use strict";var a=n("ad6d"),r=n("9f7f"),o=RegExp.prototype.exec,i=String.prototype.replace,s=o,c=function(){var t=/a/,e=/b*/g;return o.call(t,"a"),o.call(e,"a"),0!==t.lastIndex||0!==e.lastIndex}(),u=r.UNSUPPORTED_Y||r.BROKEN_CARET,l=void 0!==/()??/.exec("")[1],b=c||l||u;b&&(s=function(t){var e,n,r,s,b=this,d=u&&b.sticky,p=a.call(b),f=b.source,g=0,v=t;return d&&(p=p.replace("y",""),-1===p.indexOf("g")&&(p+="g"),v=String(t).slice(b.lastIndex),b.lastIndex>0&&(!b.multiline||b.multiline&&"\n"!==t[b.lastIndex-1])&&(f="(?: "+f+")",v=" "+v,g++),n=new RegExp("^(?:"+f+")",p)),l&&(n=new RegExp("^"+f+"$(?!\\s)",p)),c&&(e=b.lastIndex),r=o.call(d?n:b,v),d?r?(r.input=r.input.slice(g),r[0]=r[0].slice(g),r.index=b.lastIndex,b.lastIndex+=r[0].length):b.lastIndex=0:c&&r&&(b.lastIndex=b.global?r.index+r[0].length:e),l&&r&&r.length>1&&i.call(r[0],n,(function(){for(s=1;s<arguments.length-2;s++)void 0===arguments[s]&&(r[s]=void 0)})),r}),t.exports=s},"9f7f":function(t,e,n){"use strict";var a=n("d039");function r(t,e){return RegExp(t,e)}e.UNSUPPORTED_Y=a((function(){var t=r("a","y");return t.lastIndex=2,null!=t.exec("abcd")})),e.BROKEN_CARET=a((function(){var t=r("^r","gy");return t.lastIndex=2,null!=t.exec("str")}))},ac1f:function(t,e,n){"use strict";var a=n("23e7"),r=n("9263");a({target:"RegExp",proto:!0,forced:/./.exec!==r},{exec:r})},acdc:function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("Button",{attrs:{type:t.statusToType,size:t.size},domProps:{textContent:t._s(t.text)}})],1)},r=[],o=n("d4ec"),i=n("bee2"),s=n("99de"),c=n("7e84"),u=n("262e"),l=n("9ab4"),b=n("60a3"),d=function(t){function e(){var t;return Object(o["a"])(this,e),t=Object(s["a"])(this,Object(c["a"])(e).apply(this,arguments)),t.jobInstanceEnumMap={0:{value:0,desc:"待启动",type:"info"},1:{value:0,desc:"启动中",type:"info"},2:{value:0,desc:"运行中",type:"success"},3:{value:0,desc:"启动失败",type:"error"},4:{value:0,desc:"运行失败",type:"error"},5:{value:0,desc:"已停止",type:"success"},6:{value:0,desc:"运行成功",type:"success"},"-1":{value:0,desc:"未知",type:"warning"}},t}return Object(u["a"])(e,t),Object(i["a"])(e,[{key:"statusToType",get:function(){var t=this.jobInstanceEnumMap[this.status];return void 0===t?"warning":t.type}}]),e}(b["c"]);l["a"]([Object(b["b"])({default:""})],d.prototype,"text",void 0),l["a"]([Object(b["b"])({default:"-1"})],d.prototype,"status",void 0),l["a"]([Object(b["b"])({default:"default"})],d.prototype,"size",void 0),d=l["a"]([b["a"]],d);var p=d,f=p,g=n("2877"),v=Object(g["a"])(f,a,r,!1,null,"a99f111a",null);e["a"]=v.exports},caad:function(t,e,n){"use strict";var a=n("23e7"),r=n("4d64").includes,o=n("44d2"),i=n("ae40"),s=i("indexOf",{ACCESSORS:!0,1:0});a({target:"Array",proto:!0,forced:!s},{includes:function(t){return r(this,t,arguments.length>1?arguments[1]:void 0)}}),o("includes")},d784:function(t,e,n){"use strict";n("ac1f");var a=n("6eeb"),r=n("d039"),o=n("b622"),i=n("9263"),s=n("9112"),c=o("species"),u=!r((function(){var t=/./;return t.exec=function(){var t=[];return t.groups={a:"7"},t},"7"!=="".replace(t,"$<a>")})),l=function(){return"$0"==="a".replace(/./,"$0")}(),b=!r((function(){var t=/(?:)/,e=t.exec;t.exec=function(){return e.apply(this,arguments)};var n="ab".split(t);return 2!==n.length||"a"!==n[0]||"b"!==n[1]}));t.exports=function(t,e,n,d){var p=o(t),f=!r((function(){var e={};return e[p]=function(){return 7},7!=""[t](e)})),g=f&&!r((function(){var e=!1,n=/a/;return"split"===t&&(n={},n.constructor={},n.constructor[c]=function(){return n},n.flags="",n[p]=/./[p]),n.exec=function(){return e=!0,null},n[p](""),!e}));if(!f||!g||"replace"===t&&(!u||!l)||"split"===t&&!b){var v=/./[p],j=n(p,""[t],(function(t,e,n,a,r){return e.exec===i?f&&!r?{done:!0,value:v.call(e,n,a)}:{done:!0,value:t.call(n,e,a)}:{done:!1}}),{REPLACE_KEEPS_$0:l}),h=j[0],m=j[1];a(String.prototype,t,h),a(RegExp.prototype,p,2==e?function(t,e){return m.call(t,this,e)}:function(t){return m.call(t,this)})}d&&s(RegExp.prototype[p],"sham",!0)}}}]);
//# sourceMappingURL=chunk-b1fb660a.52dc3fd7.js.map