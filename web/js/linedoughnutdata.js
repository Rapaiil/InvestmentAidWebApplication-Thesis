function getGraphData() {
	$.ajax({
		type: "post",
		url: "graphdata",
		success: function(response) {
			var jsonstr = JSON.stringify(response);
			var jsonobj = JSON.parse(jsonstr);
			
			var ctx = document.getElementById('lineGraphPerformance').getContext('2d');
	        var lineGraphPerformance = new Chart(ctx, {
	            type: 'line',
	            data: {
	                datasets: [{
	                    label: 'ALFM',
	                    data: [250, 200, 350, 550],
	                    borderColor: ['#A2C7E5'],
	                    fill: false
	                },
	                {
	                    label: 'Sun Life Financial',
	                    data: [111, 222, 200, 400],
	                    borderColor: ['#FF99C9'],
	                    fill: false
	                },
	                {
	                    label: 'ATRAM',
	                    data: [300, 330, 400, 600],
	                    borderColor: ['#C1BDDB'],
	                    fill: false
	                }],
	                labels: ['2015', '2016', '2017', '2018']
	            },
	            options: {
	                responsive: true,
	                scales: {
	                    yAxes: [{
	                        ticks: {
	                            suggestedMin: 100,
	                            suggestedMax: 600
	                        }
	                    }]
	                },
	                legend: {
	                    position: 'bottom'
	                }
	            }
	        });
	        var data = {
	            labels: [
	              "Money Market MFs",
	              "Fixed Income UITFs",
	              "Equity UITFs"
	            ],
	            datasets: [
	              {
	                data: [300, 50, 100],
	                backgroundColor: [
	                  "#FF6384",
	                  "#36A2EB",
	                  "#FFCE56"
	                ],
	                hoverBackgroundColor: [
	                  "#FF6384",
	                  "#36A2EB",
	                  "#FFCE56"
	                ]
	              }],
	              options:{
	                maintainAspectRatio: false
	              }
	          };
	          
	        var doughnutGraphAsset = new Chart(document.getElementById('doughnutGraphAsset'), {
	            type: 'doughnut',
	            data: data,
	            options: {
	                responsive: true,
	                legend: {
	                    display: true,
	                    position: 'bottom'
	                },
	            }
	        });
		}
	});
}
        