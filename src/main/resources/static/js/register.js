
// var curWwwPath=window.document.location.href;
// var pathName=window.document.location.pathname;
// var pos=curWwwPath.indexOf(pathName);
// var localhostPaht=curWwwPath.substring(0,pos);
// var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
// var realPath=localhostPaht+projectName;

/*验证表单*/
// $(function () {
//     $('.registerForm').bootstrapValidator({
//         message: 'This value is not valid',
//         feedbackIcons: {
//             valid: 'glyphicon glyphicon-ok',
//             invalid: 'glyphicon glyphicon-remove',
//             validating: 'glyphicon glyphicon-refresh'
//         },
//         fields: {
//             email: {
//                 validators: {
//                     notEmpty: {
//                         message: '邮箱不能为空'
//                     },
//                     emailAddress: {
//                         message: '邮箱地址格式有误'
//                     }
//                 }
//             },
//             password:{
//             	validators:{
//             		notEmpty:{
//             			message:'密码不为空'
//             		},
//             		 stringLength: {
//                         min: 6,
//                         max: 11,
//                         message: '密码长度必须在6到11位之间'
//                     },
//                     regexp: {
//                         regexp: /^[a-zA-Z0-9_]+$/,
//                         message: '用户名只能包含大写、小写、数字和下划线'
//                     }
//             	}
//             },
//             username:{
//             	validators:{
//             		notEmpty:{
//             			message:'姓名不为空'
//             		}
//             	}
//             }
//         }
//     });
// });

function checkType(){
	var email = $("#email").val();
	var password = $("#password").val();
	var username = $("#username").val();
	var phone = $("#phone").val();
	if (email==""||password==""||username==""||phone==""){
	    return false;
    }
    $.ajax({
        type:'post',
        url:"/user/registerUser",
        dataType:'json',
        data:{"email":email,"password":password,"name":name,"username":username,"phone":phone},
        // success:function(data){
        //     var data = eval(data);
        //     var status = data.status;
        //     if(data.status=="success"){
        //         alert("注册成功");
        //         window.location.href="index.html";
        //     }else{
        //         alert("用户ID或邮箱已经被注册了");
        //     }
        // }
        success:function (data) {
            alert(data.msg);
        }
    })
}