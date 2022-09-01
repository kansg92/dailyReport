$(document).ready(function(){
	
})

function goDetailView(report_id){
	location.href ="/dailyreport/reportDetail?report_id="+report_id;
}

function goModify(id){
	location.href ="/dailyreport/reportModify?report_id="+id;
}