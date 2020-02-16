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
	
	<!-- Custom CSS -->
	<link rel="stylesheet" href="css/questionnaire_result.css" type="text/css">
	<link rel="stylesheet" href="css/modal.css" type="text/css">
	
	<!-- Font Awesome CSS-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">

    <!-- Custom CSS-->
    <link rel="stylesheet" type="text/css" href="css/recommendations.css">

    <!-- Chart JS -->
    <link rel="stylesheet" rel="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

	<title>InvAid - Risk Profile</title> 
	
	<!-- Fonts to be used are imported here via Google Fonts, before being recognized by the css -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Condensed|Titillium+Web&display=swap">
</head>
<body>
	<!-- IF ELSE REGISTERED/UNREGISTERED USER NAVBAR -->
        <s:if test="%{#session.loginToken==null}">
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
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0 menu">
                    <li class="nav-item">
                        <a class="nav-link" href="registerProfile.jsp">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                </ul>
            </div>
        </nav>
        </s:if>
        <!-- LOGGED IN/REGISTERED USER NAVBAR -->
        <s:else>
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
		</s:else>
	
        <section class="mt-5">
        <div class="container">
            <h1>Fund Recommendations</h1>
            <p>Here are some fund recommendations based on your Risk Profile result. 
                You may view more into each fund's details and see the necessary steps in investing with the bank/institution.</p>
            <table class="table table-hover recommendations-table table-responsive-md">
                <thead>
                    <tr>
                        <th scope="col">Fund Name</th>
                        <th scope="col">Fund Type</th>
                        <th scope="col">Fund Affiliation</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>ALFM Growth Fund</td>
                        <td>Mutual Fund</td>
                        <td>ALFM</td>
                        <td><a href="#" data-toggle="modal" data-target="#fundDetailModal">See Details >></a></td>
                    </tr>
                    <tr>
                        <td>Sun Life Prosperity Money Market Fund, Inc</td>
                        <td>Mutual Fund</td>
                        <td>Sun Life Financial</td>
                        <td><a href="#" data-toggle="modal" data-target="#fundDetailModal">See Details >></a></td>
                    </tr>
                    <tr>
                        <td>Maybank Tiger Peso Money Market Feeder Fund</td>
                        <td>UITF</td>
                        <td>Maybank Philippines Inc.</td>
                        <td><a href="#" data-toggle="modal" data-target="#fundDetailModal">See Details >></a></td>
                    </tr>
                    <tr>
                        <td>BDO Equity Fund</td>
                        <td>UITF</td>
                        <td>BDO Unibank, Inc.</td>
                        <td><a href="#" data-toggle="modal" data-target="#fundDetailModal">See Details >></a></td>
                    </tr>
                    <tr>
                        <td>BPI Balanced Fund</td>
                        <td>UITF</td>
                        <td>BPI Asset Management and Trust Corporation</td>
                        <td><a href="#" data-toggle="modal" data-target="#fundDetailModal">See Details >></a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </section>

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
    
    <!-- JS -->
    <script src="js/navbar.js"></script>
</body>
</html>