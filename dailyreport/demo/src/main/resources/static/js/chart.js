
$(document).ready(function() {
	
	$('input[name="day"]').change(function(){
		var day = $(this).val()
		var uid = $('#uid').val();
		$.ajax({
			url : "/changeDailyChart",
			data : {
				"day" : day,
				"uid" : uid 
			},
			success: function(data){
				$('#daily_tbody').empty();
				addRow(data);
				getData()
			}
		})
	})


});


function qscoreToQuailty(){
	const qscore = Number($('#quality').text());
	if(qscore >= 45){
		$('#quality').text("s")
	}else if (qscore < 45 && qscore >=40){
		$('#quality').text("A+")
	}else if (qscore < 40 && qscore >=37){
		$('#quality').text("A") 
	}else if (qscore < 40 && qscore >=35){
		$('#quality').text("B+")
	}else if (qscore < 35 && qscore >=30){
		$('#quality').text("B")
	}else if (qscore < 30 && qscore >=25){
		$('#quality').text("C")
	}else if (qscore < 25 && qscore >=20){
		$('#quality').text("C")
	}else{
		$('#quality').text("F")
	}
};

function getData(){
	var day = $('input[name="day"]').val()
	var uid = $('#uid').val();
	$.ajax({
		
		url : "/getDailyChart",
		data : {
			"day" : day,
			"uid" : uid 
		},
		success : function(data){
			paintingChart(data);
			console.log(data)
		}
		
	})
	
}

function sumScore(){
	var sumscore = 0;
	for (i = 0; i < 14; i++) {
		var score = Number($('#score'+i).text());
		sumscore += score; 
	}
	$('#sumScore').text(sumscore);
}

function addRow(data){
	var cnt = 0;
	var qscore = 0; 
	var txt2 = '<tr><td>총 점수</td><td colspan="3" id="sumScore">0</td></tr><tr><td>퀄리티 등급</td><td colspan="3" id="quality">0</td></tr>	'
	for(i=13; i >= 0;i--){
		qscore += data[i].qscore;
		if(data[i].spendtime == null){
			data[i].spendtime = 0;
		}
		var txt = '<tr><td>'+data[i].category+'</td>' +
				'<td>'+data[i].spendtime+'</td>'+
				'<td id="score'+cnt+'">'+data[i].score+'</td></tr>';
		cnt++;
		$('#daily_tbody').prepend(txt);	
	}
	$('#daily_tbody').append(txt2);
	
	$('#quality').text(qscore)
	sumScore();	
	qscoreToQuailty();			
	
}

function paintingChart(data){
	Highcharts.chart('container', {
	    chart: {
	        type: 'pie',
	        options3d: {
	            enabled: true,
	            alpha: 45,
	            beta: 0
	        }
	    },
	    title: {
	        text: $('input[name="day"]').val()
	    },
	    subtitle: {
	        text: '분류 종합 테이블 차트' 
	    },
	    accessibility: {
	        point: {
	            valueSuffix: '%'
	        }
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            depth: 50,
	            dataLabels: {
	                enabled: true,
	                format: '{point.name}'
	            }
	        }
	    },
	    series: [{
	        type: 'pie',
	        name: 'Share',
	        data: data
	    }]
	});
}