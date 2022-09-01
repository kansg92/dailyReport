var cnt = 0;

$(document).ready(function(){
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
				if(check){
					$('#cautionText').text('');
					$("#endTime"+cnt).attr('disabled',true);
					addRow(endTime,data);
				}

			}
		});
	});
	
	$('#daily-saveBtn').click(function(){	
		var check = checkvalidation();
		if(check){		
			$('.timepicker').attr('disabled',false);
			const sa = $('#daily-form').serializeArray();
			const jsa = JSON.stringify(sa);
			senddata(sa,jsa);
		}
	});
	
	console.log(typeof($('#endTime0').val()))
	
})


function senddata(sa,jsa){		
	const feedback = $('textarea[name="feedback"]').val();
	const uid = $('input[name="uid"]').val();
	const day = $('input[name="day"]').val();
	$.ajax({
		url:'/dailyReportsubmit',
		data:{
			//'data':sa,
			'jsonString':jsa,
			'feedback' : feedback,
			'uid' : uid,
			'day' : day
			},
		success:function(data){
			if(data == 'success'){
				alert("저장되었습니다.");
			}else if(data == 'dayoverwrite'){
				alert("해당날짜는 이미 등록되어있습니다.");
			}
		}
	})
}	

function addRow (endTime,data){
	cnt ++;
	var txt = 	'<tr>'+
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
		return false;
	}
	if($('#endTime'+cnt).val() < $('#startTime'+cnt).val()){
		if($('#endTime'+cnt).val() == '00:00'){
			return true;
		}
		$('#cautionText').text('Check End Times please');
		return false;	
	}
	if($('#cate'+cnt).val() == ''){
		$('#cautionText').text('category is empty');
		return false;	
	}
	if($('#immersion'+cnt).val() == ''){
		$('#cautionText').text('immersion is empty');
		return false;	
	}
	if($('#contents'+cnt).val() == ''){
		$('#cautionText').text('contents is empty');
		$('#contents'+cnt).focus();
		return false;	
	}
	return true;
	
};




	