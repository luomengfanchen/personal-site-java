(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-75322c28"],{"2cfd":function(t,e,a){"use strict";a("e314")},"73cf":function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"register-container"},[a("transition",{attrs:{appear:""}},[a("div",{staticClass:"register-card"},[a("h2",{staticClass:"register-title"},[t._v("欢迎注册")]),a("form",[a("div",{staticClass:"register-input"},[a("label",{attrs:{for:"account"}},[t._v("邮箱")]),a("input",{directives:[{name:"model",rawName:"v-model",value:t.email,expression:"email"}],attrs:{type:"text"},domProps:{value:t.email},on:{input:function(e){e.target.composing||(t.email=e.target.value)}}})]),a("div",{staticClass:"register-input"},[a("label",{attrs:{for:"nickname"}},[t._v("昵称")]),a("input",{directives:[{name:"model",rawName:"v-model",value:t.nickname,expression:"nickname"}],attrs:{type:"text"},domProps:{value:t.nickname},on:{input:function(e){e.target.composing||(t.nickname=e.target.value)}}})]),a("div",{staticClass:"register-input"},[a("label",{attrs:{for:"password"}},[t._v("密码")]),a("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],attrs:{type:"password"},domProps:{value:t.password},on:{input:function(e){e.target.composing||(t.password=e.target.value)}}})]),a("div",{staticClass:"register-button"},[a("input",{attrs:{type:"button",value:"注册"},on:{click:t.register}})])])])])],1)},i=[],n={name:"Register",data:function(){return{nickname:"",email:"",password:""}},methods:{register:function(){var t=this;this.axios.post("/api/register",{email:this.email,name:this.nickname,password:this.password}).then((function(){alert("注册成功，将跳转到登录界面"),t.$router.push("/login")})).catch((function(){alert("注册失败!")}))}}},r=n,o=(a("2cfd"),a("2877")),c=Object(o["a"])(r,s,i,!1,null,null,null);e["default"]=c.exports},e314:function(t,e,a){}}]);
//# sourceMappingURL=chunk-75322c28.b8795462.js.map