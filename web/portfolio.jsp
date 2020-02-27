<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
	<!-- Font Awesome CSS-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">

    <!-- Custom CSS-->
    <link rel="stylesheet" type="text/css" href="css/portfolio.css">
    <link rel="stylesheet" type="text/css" href="css/modal.css">

    <!-- Chart JS -->
    <link rel="stylesheet" rel="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    
	<title>InvAid - Portfolio</title> 
	
	<!-- Fonts to be used are imported here via Google Fonts, before being recognized by the css -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Condensed|Titillium+Web&display=swap">
</head>
<body>
	<!-- IF ELSE REGISTERED/UNREGISTERED USER NAVBAR -->
        <!-- NAVBAR -->
        <nav class="navbar navbar-expand-lg navbar-custom hover-underline-menu navbar-fized-top" data-menu-underline-from-center>
            <a class="navbar-brand" href="/"><img src="assets/logo.png" alt="InvAid_logo" height="50" width="50"/> </a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
                aria-expanded="false" aria-label="Toggle navigation">
                <span><i class="fa fa-bars" aria-hidden="true"></i></span> 
            </button>
            <div class="collapse navbar-collapse main-menu" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0 menu">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp#aboutSection">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Investment Guide</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="questionnaire_landing.jsp">Risk Profile Questionnaire</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="monitoring.jsp">Monitoring</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="feedback.jsp">Feedback</a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color:white">
							Hi, <s:property value="#session.loginFirstName"/>
						</a>
	                    <div class="dropdown-menu dropdown-menu-right dropdown-default">
	                    	<a class="dropdown-item" href="#">Account Settings</a>
	                    	<a class="dropdown-item" href="portfolio.jsp">My Investment Portfolio</a>
	                    	<a class="dropdown-item" href="#">Risk Profile</a>
	                    	<a class="dropdown-item" href="#">Reset Password</a>
	                    	<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#logoutModal" data-toggle="modal">Logout</a>
						</div>
					</li>
                </ul>
            </div>
        </nav>
        <section class="portfolio mt-5">
	        <div class="wrapper">
	            <div class="container-fluid">
	                <div class="row">
	                    <!-- SIDEBAR -->
	                    <div class="col-lg-3">
	                        <div class="sidebar">
	                            <div class="net">
	                                <h1>&#8369;1M &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></h1>
	                                <small>Portfolio Value</small>
	                            </div>
	                            <hr/>
	                            <ul class="nav nav nav-pills flex-column" id="myTab" role="tablist">
	                                <li class="nav-item">
	                                    <a class="nav-link" href="mutual_funds.jsp">Mutual Funds</a>
	                                </li>
	                                <li class="nav-item">
	                                    <a class="nav-link" href="uitf.jsp">Unit Investment Trust Funds</a>
	                                </li>
	                            </ul>
	                            <hr/>
	                            <a type="button" href="enroll_funds.jsp" class="btn btn-primary btn-lg btn-block btn-addFund"><i class="fas fa-plus"></i>&nbsp;Enroll Fund</a>
	                        </div>
	                    </div>
	                    
	                    <div class="col-lg-9 content">
	                        <!-- CONTENT PORTFOLIO-->
	                        <div class="portfolio-content">
	                            <h1>My Portfolio</h1>
	                            <div class="net-summary">
	                                <!-- CARD SUMMARY -->
	                                <div class="card-deck card-summary">
	                                    <div class="card">
	                                        <div class="card-body">
	                                            <h3>&#8369; 2,100 &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></h3>
	                                            <small class="card-title">Overall Gain/Loss</small>
	                                        </div>
	                                    </div>
	                                    <div class="card">
	                                        <div class="card-body">
	                                            <h3>&#8369; 1,000 &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></h3>
	                                            <small class="card-title">Day Gain/Loss</small>
	                                        </div>
	                                    </div>
	                                    <div class="card">
	                                        <div class="card-body">
	                                            <h3>1.4% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></h3>
	                                            <small class="card-title">Day Gain/Loss (%)</small>
	                                        </div>
	                                    </div>
	                                </div>
	                                <!-- GRAPHS -->
	                                <div class="card-deck mt-3">
	                                    <!-- LINE GRAPH/PORTFOLIO PERFORMANCE -->
	                                    <div class="card p-3 text-center">
	                                        <h4 class="card-title">Portfolio Performance</h4>
	                                        <div class="card-body">
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
	                                    <!-- ASSET ALLOCATION -->
	                                    <div class="card p-3 text-center">
	                                        <h4 class="card-title">Asset Allocation</h4>
	                                        <div class="card-body">
	                                            <canvas id="doughnutGraphAsset" width="400" height="400"></canvas>
	                                        </div>
	                                    </div>
	                                </div>
	                                <!-- TOP 5 PERFORMING INVESTMENTS -->
	                                <div class="card mt-3">
	                                    <div class="card-body">
	                                        <h3>Top 3 Performing Investments</h3>
	                                        <div class="table-responsive-md top-five-investments">
	                                            <table class="table table-hover">
	                                                <thead class="investment-performance-table">
	                                                    <tr>
	                                                        <th scope="col">Fund Name</th>
	                                                        <th scope="col">Type</th>
	                                                        <th scope="col">Current NAVPU/NAVPS</th>
	                                                        <th scope="col">Daily (%)</th>
	                                                    </tr>
	                                                </thead>
	                                                <tbody>
	                                                    <tr>
	                                                        <td>ALFM</td>
	                                                        <td>Mutual Fund</td>
	                                                        <td>&#8369; &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
	                                                        <td>% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
	                                                    </tr>
	                                                    <tr>
	                                                        <td>Sun Life Financial</td>
	                                                        <td>Mutual Fund</td>
	                                                        <td>&#8369; &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
	                                                        <td>% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
	                                                    </tr>
	                                                    <tr>
	                                                        <td>ATRAM</td>
	                                                        <td>Mutual Fund</td>
	                                                        <td>&#8369; &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
	                                                        <td>% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
	                                                    </tr>
	                                                </tbody>
	                                            </table>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </section>


    <!-- FOOTER -->

		<!-- LOGOUT MODAL -->
		<!-- Modal -->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title text-uppercase">Logout</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <p>Would you like to logout?</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn bg-danger btnCancel" data-dismiss="modal">Cancel</button>
		        <button type="button" class="btn btn-primary btnLogout">Logout</button>
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
    </script>
    <!-- DOUGHNUT CHART -->
    <script>
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
    </script>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
    <!-- JS -->
    <script src="js/navbar.js"></script>
</body>
</html>