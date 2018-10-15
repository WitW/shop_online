
function checkType(){
	var email = $("#email").val();
	var password = $("#password").val();
	if (email==""||password==""){
		return false;
	}
    $.ajax({
        type:'post',
        url:"/user/loginUser",
        dataType:'json',
        data:{'email':email,"password":password},
        success:function(data){
            alert(data.msg);
        }
    })
}
