$(document).ready(function(){
	
})

function login(){
	$('#login-form').attr({
		action : "loginimpl",
		method : "post"
	})
	$('#login-form').submit();
}