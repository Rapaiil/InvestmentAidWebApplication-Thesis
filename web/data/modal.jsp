<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
	<!-- Chart JS -->
    <link rel="stylesheet" rel="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    
    <!-- Chart JS -->
    <link rel="stylesheet" rel="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    
    <!-- Fonts to be used are imported here via Google Fonts, before being recognized by the css -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Condensed|Titillium+Web&display=swap">

	<meta charset="ISO-8859-1">
</head>
<body>

<!-- DETAILS MODAL -->
    <div class="modal fade" id="fundDetailModal">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
        
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">[Investment Fund]</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
        
            <!-- Modal body -->
            <div class="modal-body">
                <h1>[Investment Fund]</h1>
                <div class="row">
                    <div class="col-md-6">
                        <p><b>Fund Type: </b></p>
                        <p><b>Affiliation: </b></p>
                        <p><b>NAVPU/NAVPS (as of MM/DD/YYYY): </b></p>
                        <hr/>
                        <h3>Investment Application</h3>
                        <p>1.</p>
                        <p>2.</p>
                        <p>3.</p>
                        <p>4.</p>
                        <p>5.</p>
                    </div>
                    <div class="col-md-6">
                        <ul class="nav nav-pills pb-3">
                            <li class="nav-item">
                                <a class="nav-link active" href="#">Today</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Week</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Month</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">1Y</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">3Y</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">5Y</a>
                            </li>
                        </ul>
                        <canvas id="lineGraphPerformance" width="400" height="400"></canvas>
                    </div>
                </div>
            </div>
        
            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        
            </div>
        </div>
    </div>

<!-- LINE GRAPH -->
    <script>     
        var ctx = document.getElementById('lineGraphPerformance').getContext('2d');
        var lineGraphPerformance = new Chart(ctx, {
            type: 'line',
            data: {
                datasets: [{
                    label: 'ALFM',
                    data: [250, 200, 350, 550],
                    borderColor: ['#A2C7E5'],
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
                    display: false
                }
            }
        });
    </script>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
</body>
</html>