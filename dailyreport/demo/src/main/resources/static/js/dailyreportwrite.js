var cnt = 0;

let checking = "";

$(document).ready(function(){
	if($('#size').text() != null ){
	cnt = Number($('#size').text());
	}
	console.log(cnt);
	console.log($('#size').text());
	$('#startTime0').attr("disabled",true);
	$('input.timepicker').timepicker({
        timeFormat: 'HH:mm',
        interval: 15,
        startTime: '00:00',
        scrollbar: true
	});
	
	$('#addBtn').click(function(){		
		const endTime = $("#endTime"+cnt).val();	
		$.ajax({
			url:'/getCode',
			success:function(data){
				var check = checkvalidation();
				var check2 = lastTimeCheck();
				if(check && check2){
					$('#cautionText').text('');
					addRow(endTime,data);
				}

			}
		});
	});
	
	$('#daily-saveBtn').click(function(){	
		var check = checkvalidation();
		var check2 = feedbackCheck();
		if(check && check2){
			$('input').attr("disabled",false);
			const sa = $('#daily-form').serializeArray();
			const jsa = JSON.stringify(sa);
			checking = "save";
			senddata(jsa,checking);
		}
	});
	
	$('#daily-modifyBtn').click(function(){
		var check = checkvalidation();
		var check2 = feedbackCheck();
		if(check && check2){
			$('input').attr("disabled",false);
			const sa = $('#daily-form').serializeArray();
			const jsa = JSON.stringify(sa);
			checking = "modify";
			senddata(jsa,checking);
		}		
	});

})

function calculatorTime(){
	let startHours = Number($('#startTime'+(cnt-1)).val().split(':')[0]);
	let startMin = Number($('#startTime'+(cnt-1)).val().split(':')[1]);
	let endHours =Number($('#endTime'+(cnt-1)).val().split(':')[0]);
	let endMin = Number($('#endTime'+(cnt-1)).val().split(':')[1]);
	let start_time = startHours*60+startMin;
	let end_time = endHours*60+endMin;
	if(end_time === 0){
		end_time = 24*60;
	}
	let tiemInterval = end_time - start_time;
	console.log("start_time::"+start_time);
	console.log("end_time::"+end_time);
	console.log("tiemInterval::"+tiemInterval);
	
	
}

function senddata(jsa,checking){		
	const feedback = $('textarea[name="feedback"]').val();
	const uid = $('input[name="uid"]').val();
	const day = $('input[name="day"]').val();
	const id = $('input[name="reportId"]').val();
	console.log(id);
	$.ajax({
		url:'/dailyReportsubmit',
		data:{
			//'data':sa,
			'jsonString':jsa,
			'feedback' : feedback,
			'uid' : uid,
			'day' : day,
			'check' : checking,
			'id' : id
			},
		success:function(data){
			if(data == 'success'){
				alert("저장되었습니다.");
			}else if(data == 'dayoverwrite'){
				alert("이미 등록되어있는 날짜입니다.");
			}else if (data == "fail"){
				alert("날짜를 선택해주세요.")
			}
		}
	})
}	

function addRow (endTime,data){
	cnt ++;
	calculatorTime()
	var txt = 	'<tr>'+
					'<td class="hidden"><input value="0" name="id"> </td>'+
					'<td style="width:5%;"><input type = "text" name="start_time" id="startTime'+cnt+'" class="timepicker" value="'+endTime+'"></td>'+
					'<td style="width:5%;"><input type = "text" name="end_time" id="endTime'+cnt+'" class="timepicker" value="'+endTime+'"></td>'+
					'<td style="width:5%;" class="category">'+
						'<select name="catecode" id="category'+cnt+'">'+
						'</select>'+
					'</td>'+
					'<td>'+
					'<input name="contents" type="text" id="contents'+cnt+'">'+
					'</td>'+
					'<td>'+
						'<select name="immercode" id="immersion'+cnt+'">'+
							
						'</select>'+
					'</td>'+
				'</tr>';
	$('#daily_tbody').append(txt);
	addCategory(data);
	$('input.timepicker').timepicker({
        timeFormat: 'HH:mm',
        interval: 15,
        startTime: '00:00',
        scrollbar: true
	});
	
}	

function addCategory (data){
	var text = "";
	for(i=0; i < data.length; i++){
		text='<option value="'+data[i].detail_code+'">'+data[i].name+'</option>';
		$('#category'+cnt).append(text);
	}
	$.ajax({
		url:'/getimmersion',
		async: false,
		success:function(data){
			for(i=0; i < data.length; i++){
				var txt='<option value="'+data[i].detail_code+'">'+data[i].name+'</option>';
				$('#immersion'+cnt).append(txt);
			}
		}
	})
}	

function checkvalidation(){
	if($('#endTime'+cnt).val() === $('#startTime'+cnt).val() ){
		$('#cautionText').text('Check End Times please');
		$('#endTime'+cnt).focus();
		return false;
	}
	if($('#endTime'+cnt).val() < $('#startTime'+cnt).val()){
		if($('#endTime'+cnt).val() == '00:00'){
			return true;
		}
		$('#cautionText').text('Check End Times please');
		$('#endTime'+cnt).focus();
		return false;	
	}
	if($('#contents'+cnt).val() == ''){
		$('#cautionText').text('contents is empty');
		$('#contents'+cnt).focus();
		return false;	
	}
	return true;
	
};

function lastTimeCheck(){
	if($('#endTime'+cnt).val() < $('#startTime'+cnt).val()){
		if($('#endTime'+cnt).val() == '00:00'){
			alert("종료시간은 00:00이 마지막 시간입니다.")
			return false;
		}
	}
	return true;
}

function feedbackCheck(){
	console.log($('#endTime'+cnt).val());
	if($('textarea[name="feedback"]').val() == ""){
		$('#cautionText').text('하루평가를 작성해주세요.');
		$('textarea[name="feedback"]').focus();
		return false;
	}
	if($('#endTime'+cnt).val() > $('#startTime'+cnt).val()){
		if($('#endTime'+cnt).val() != '00:00'){
			alert("종료시간은 00:00이 되어여합니다.");
			return false;
		}else{
			return true;
		}
	}
	return true;
}


	