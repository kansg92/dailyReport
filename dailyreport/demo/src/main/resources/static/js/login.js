$(document).ready(function(){
	
})

function login(){
	$('#login-form').attr({
		action : "loginimpl",
		method : "post"
	})
	$('#login-form').submit();
}

function logout(){
	var check = confirm("로그아웃 하시겠습니까??");
	if(check){
		location.href = "/logout";
	}
	
	
	
}