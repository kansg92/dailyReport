
function changeHabit(event){
	const target = event.target;
	const input = target.querySelector('input')
	
}

$(document).ready(function(){
	$('#habitAddBtn').click(function(){
		let num = document.getElementsByClassName("habitNum").length+1;
		let habit = $('input[name="habit"]').val();
		let valueCode = $('select[name="valueCode"]').val();
		let uid = $('#uidtxt').text();
		
		$.ajax({
			url:"addHabitCard",
			data:{
				num:num,
				habit:habit,
				valueCode: valueCode,
				uid : uid
			},
			success:function(data){
				console.log(data.habit);
				addHabitCard(data);
				$('input[name="habit"]').val("");
			}
		})
		
	});
	
});


function addHabitCard(data){
	if(data.valueCode == 3){
		var txt = 
			'<div class="col-xl-6 col-md-6 habitNum">'+
			'<div class="card bg-success text-white mb-4">'+
			'<div class="card-body" id="habit"'+data.num+'>'+data.habit+'</div>'+
			'<div class="card-footer d-flex align-items-center justify-content-between">'+
			'<span class="small text-white" >완료</span>'+
			'<div class="small text-white">'+
			'<input type="checkbox">'+
			'</div></div></div></div>';
	}else if (data.valueCode == 4){
		var txt = 
			'<div class="col-xl-6 col-md-6 habitNum">'+
			'<div class="card bg-danger text-white mb-4">'+
			'<div class="card-body" id="habit"'+data.num+'>'+data.habit+'</div>'+
			'<div class="card-footer d-flex align-items-center justify-content-between">'+
			'<span class="small text-white" >완료</span>'+
			'<div class="small text-white">'+
			'<input type="checkbox">'+
			'</div></div></div></div>';
	}

			
	$('#addHabit').before(txt);		
	
}