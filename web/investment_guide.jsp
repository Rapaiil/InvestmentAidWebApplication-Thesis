<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
	<!-- Custom CSS -->
	<link rel="stylesheet" href="css/investment_guide.css" type="text/css">
	<link rel="stylesheet" href="css/modal.css" type="text/css">
	<title>InvAid - Investment Guide</title> 
	
	 <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- Fonts to be used are imported here via Google Fonts, before being recognized by the css -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Condensed|Titillium+Web&display=swap">
</head>
<body>
		<!-- IF ELSE REGISTERED/UNREGISTERED USER NAVBAR -->
        <!-- NAVBAR -->
        <s:if test="%{#session.loginToken==null}">
	        <nav class="navbar navbar-expand-lg navbar-custom hover-underline-menu navbar-fized-top" data-menu-underline-from-center>
	            <a class="navbar-brand" href="index.jsp"><img src="assets/logo.png" alt="InvAid_logo" height="50" width="50"/> </a>
	            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
	                aria-expanded="false" aria-label="Toggle navigation">
	                <span><i class="fa fa-bars" aria-hidden="true"></i></span> 
	            </button>
	            <div class="collapse navbar-collapse main-menu" id="collapsibleNavId">
	                <ul class="navbar-nav mr-auto mt-2 mt-lg-0 menu">
	                    <li class="nav-item">
	                        <a class="nav-link" href="index.jsp">Home</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" href="index.jsp#aboutSection">About</a>
	                    </li>
	                    <li class="nav-item active">
	                        <a class="nav-link" href="investment_guide.jsp">Investment Guide</a>
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
	            <a class="navbar-brand" href="index.jsp"><img src="assets/logo.png" alt="InvAid_logo" height="50" width="50"/> </a>
	            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
	                aria-expanded="false" aria-label="Toggle navigation">
	                <span><i class="fa fa-bars" aria-hidden="true"></i></span> 
	            </button>
	            <div class="collapse navbar-collapse main-menu" id="collapsibleNavId">
	                <ul class="navbar-nav mr-auto mt-2 mt-lg-0 menu">
	                    <li class="nav-item">
	                        <a class="nav-link" href="index.jsp">Home</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" href="index.jsp#aboutSection">About</a>
	                    </li>
	                    <li class="nav-item active">
	                        <a class="nav-link" href="investment_guide.jsp">Investment Guide</a>
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
		                    	<a class="dropdown-item" href="account_settings.jsp">Account Settings</a>
		                    	<a class="dropdown-item" href="portfolio.jsp">My Investment Portfolio</a>
		                    	<a class="dropdown-item" href="riskprofile.jsp">Risk Profile</a>
		                    	<a class="dropdown-item" href="reset_password.jsp">Reset Password</a>
		                    	<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#logoutModal" data-toggle="modal">Logout</a>
							</div>
						</li>
	                </ul>
	            </div>
	        </nav>
		</s:else>


	<!-- INVESTMENT GUIDE -->
	<section class="content mt-5">
		<h1 class="text-center">Investment Guide</h1>
		
		<div class="d-flex guide-menu d-flex justify-content-center mt-5">
			<div class="card-deck">
			  <div class="card">
			    <img class="card-img-top" src="assets/terms.png" alt="Card image cap">
			    <div class="card-body">
			      <h5 class="card-title">Definition of Terms</h5>
			      <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et consectetur lacus. Morbi nec ullamcorper ligula. Sed porta ut lorem ac pretium. </p>
			    </div>
			  </div>
			  <div class="card">
			    <img class="card-img-top" src="assets/guide.png" alt="Card image cap">
			    <div class="card-body">
			      <h5 class="card-title">Basic Investment Steps</h5>
			      <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et consectetur lacus. Morbi nec ullamcorper ligula. Sed porta ut lorem ac pretium. </p>
			    </div>
			  </div>
			  <div class="card">
			    <img class="card-img-top" src="assets/manual.png" alt="Card image cap">
			    <div class="card-body">
			      <h5 class="card-title">System Manual</h5>
			      <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et consectetur lacus. Morbi nec ullamcorper ligula. Sed porta ut lorem ac pretium. </p>
			    </div>
			  </div>
			</div>
		</div>
	</section>
</body>
</html>