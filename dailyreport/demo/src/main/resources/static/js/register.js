

function registerAccount() {
	const FORM = '#register-form';
	if(registerCheck()){
		$(FORM).attr({
			'method' : 'post',
			'action' : 'registerimpl'
		})
		$(FORM).submit();
	}
}

function registerCheck(){
	const inputId = $('#inputId').val();
	const inputFirstName = $('#inputFirstName').val();
	const inputLastName = $('#inputLastName').val();
	const inputEmail = $('#inputEmail').val();
	const inputPassword = $('#inputPassword').val();
	const inputPasswordConfirm = $('#inputPasswordConfirm').val();
	const korean = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	const regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
	
	function idCheck(){
		let isTrue;
		$.ajax({
			url : "idCheck",
			async: false,
			data : {id:inputId},
			success : function(data){
				isTrue = data;	
			}
		})
		return isTrue;
		
	}
	if(idCheck() === false){
		$('#inputId').focus();
		$('label[for="inputId"]').html('중복된 ID 입니다.');
		return false;
	}
	if(inputId == null || inputId == ""){
		$('#inputId').focus();
		return false;
	}
	if(korean.test(inputId) || inputId.length < 5){
		$('#inputId').focus();
		$('label[for="inputId"]').html('5자리이상 영문과 숫자조합으로 입력해주세요.');
		return false;
	}
	if(inputFirstName == null || inputFirstName == "" ){
		$('#inputFirstName').focus();
		return false;
	}
	if(inputLastName == null || inputLastName == "" ){
		$('#inputLastName').focus();
		return false;
	}
	if(inputEmail == null || inputEmail == "" ){
		$('#inputEmail').focus();
		return false;
	}
	if(regEmail.test(inputEmail) === false){
		$('label[for="inputEmail"]').html('Email양식이 아닙니다.');
		return false;
	}
	if(inputPassword == null || inputPassword == "" || inputPassword.length < 6){
		$('#inputPassword').focus();
		$('label[for="inputPassword"]').html('6자리 이상 입력해주세요.');
		return false;
	}
	if(inputPasswordConfirm == null || inputPasswordConfirm == "" || inputPassword != inputPasswordConfirm){
		$('label[for="inputPasswordConfirm"]').html('비밀번호가 다릅니다. 다시확인해주세요.');
		$('#inputPasswordConfirm').focus();
		return false;
	}
	return true;
}
