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
    <link rel="stylesheet" type="text/css" href="css/funds.css">
    <link rel="stylesheet" type="text/css" href="css/modal.css">

    <!-- Chart JS -->
    <link rel="stylesheet" rel="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    
	<title>InvAid - Mutual Funds Portfolio</title> 
	
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
                    <div class="col-md-3">
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
                        </div>
                    </div>
                    
                    <div class="col-md-9 content">
                        <!-- CONTENT PORTFOLIO-->
                        <div class="portfolio-content">
                            <small><a href="portfolio.jsp"><< Return to Portfolio</a></small>
                            <h1>Mutual Funds</h1>
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
                                <!-- Mutual Funds -->
                                <div class="card mt-3">
                                    <div class="card-body">
                                        <div class="table-responsive-md funds-table">
                                            <table class="table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Fund Name</th>
                                                        <th scope="col">Type</th>
                                                        <th scope="col">Current NAVPU/NAVPS</th>
                                                        <th scope="col">Daily (%)</th>
                                                        <th scope="col"></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>ALFM</td>
                                                        <td>Mutual Fund</td>
                                                        <td>&#8369; &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
                                                        <td>% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
                                                        <td><a href="#">Edit</a>&nbsp;<a href="#" data-toggle="modal" data-target="#deleteFundModal">Delete</a></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Sun Life Financial</td>
                                                        <td>Mutual Fund</td>
                                                        <td>&#8369; &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
                                                        <td>% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
                                                        <td><a href="#">Edit</a>&nbsp;<a href="#" data-toggle="modal" data-target="#deleteFundModal">Delete</a></td>
                                                    </tr>
                                                    <tr>
                                                        <td>ATRAM</td>
                                                        <td>Mutual Fund</td>
                                                        <td>&#8369; &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
                                                        <td>% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
                                                        <td><a href="#">Edit</a>&nbsp;<a href="#" data-toggle="modal" data-target="#deleteFundModal">Delete</a></td>
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

    <!-- DELETE MODAL -->    
    <!-- Modal -->
    <div class="modal fade" id="deleteFundModal" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Delete Investment</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                </div>
                <div class="modal-body">
                    <p>Would you like to delete [Fund]?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary btn-confirm">Confirm</button>
                </div>
            </div>
        </div>
    </div>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
    <!-- JS -->
    <script src="js/navbar.js"></script>
</body>
</html>