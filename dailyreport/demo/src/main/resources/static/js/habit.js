
function changeHabit(event){
	const target = event.target;
	const input = target.querySelector('input')
	
}

$(document).ready(function(){
	$('#habitAddBtn').click(function(){
		let habit = $('input[name="habit"]').val();
		let valueCode = $('select[name="valueCode"]').val();
		let uid = $('#uidtxt').text();
		
		$.ajax({
			url:"addHabitCard",
			data:{
				habit:habit,
				valueCode: valueCode,
				uid : uid
			},
			success:function(data){
				console.log(data.id);
				addHabitCard(data);
				$('input[name="habit"]').val("");
			}
		})
		
	});
	
});


function addHabitCard(data){
	if(data.valueCode == 3){
		var txt = 
			'<div class="col-xl-6 col-md-6 habitNum" id="habitCard'+data.id+'">'+
			'<div class="card bg-success text-white mb-4">'+
			'<div class="card-body" id="habit"'+data.num+'>'+data.habit+'<i class="bi bi-x delIcon" onClick="deleteCard('+data.id+')"></i></div>'+
			'<div class="card-footer d-flex align-items-center justify-content-between">'+
			'<span class="small text-white" >완료</span>'+
			'<div class="small text-white">'+
			'<input type="checkbox">'+
			'</div></div></div></div>';
	}else if (data.valueCode == 4){
		var txt = 
			'<div class="col-xl-6 col-md-6 habitNum" id="habitCard'+data.id+'">'+
			'<div class="card bg-danger text-white mb-4">'+
			'<div class="card-body" id="habit"'+data.num+'>'+data.habit+'<i class="bi bi-x delIcon" onClick="deleteCard('+data.id+')"></i></div>'+
			'<div class="card-footer d-flex align-items-center justify-content-between">'+
			'<span class="small text-white" >완료</span>'+
			'<div class="small text-white">'+
			'<input type="checkbox">'+
			'</div></div></div></div>';
	}

			
	$('#addHabit').before(txt);		
	
}


function deleteCard(id){
	if(window.confirm("해당 습관을 삭제하시겠습니까?")){
		$.ajax({
		url:"deleteHabitCard",
		data:{"id":id},
		success:function(){
			$('#habitCard'+id).remove();
		}
	})
	}

	
}