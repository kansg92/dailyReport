window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatable-dailyReportWrite');
    const dailyReportView = document.getElementById('datatable-dailyReportView');
    const dailyReportDetailView = document.getElementById('datatable-dailyReportDetailView');
    const dailyChartView =document.getElementById('datatable-dailyChartView');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple, {
			paging :false,
			searchable : false
		});
    }
    if(dailyReportView){
		new simpleDatatables.DataTable(dailyReportView,{
			searchable : false
		})
		$('.dataTable-dropdown').css("float","left");
	}
    if (dailyReportDetailView) {
        new simpleDatatables.DataTable(dailyReportDetailView, {
			paging :false,
			searchable : false
		});
    }
    if (dailyChartView) {
        new simpleDatatables.DataTable(dailyChartView, {
			paging :false,
			searchable : false
		});
    }
    
    
    
});
