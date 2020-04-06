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
	<link rel="stylesheet" href="css/guides.css" type="text/css">
	<link rel="stylesheet" href="css/modal.css" type="text/css">
	<title>InvAid - Definition of Terms</title> 
	
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
	
	<div class="container">
		<h1>Definition of Terms</h1>
		<ul>
			<li class="terms"><b>Investment</b> - purchasing of goods/assets that will provide more income over time.</li>
			<li class="terms"><b>Investing</b> - the act of allocating funds to assets with the expectation of growing over time.</li>
			<li class="terms"><b>Pooled Funds</b> - a portfolio of funds by several investors that are aggregated for the purpose of investing.</li>
			<li class="terms"><b>Unit Investment Trust Funds (UITF)</b> - collection of fixed portfolios, with a definite timeline.</li>
			<li class="terms"><b>Mutual Funds</b> - collection of stocks, bonds, and/or other securities</li>
			<li class="terms"><b>Bangko Sentral ng Pilipinas (BSP)</b> - is the central bank of the Philippines, established on July 3, 1993. They are in charge of UITF.</li>
			<li class="terms"><b>Securities and Exchange Commission (SEC)</b> - an agency of the Philippines responsible for regulating the securities in the Philippines as well as maintaining the country's company register. They are in charge of Mutual Funds.</li>
			<li class="terms"><b>Stocks</b> - a type of security wherein the holder has proportionate ownership to the issuing company.</li>
			<li class="terms"><b>Bonds</b> - a fixed income instrument and less riskier than Stocks, as it returns the face value of the security at maturity.</li>
			<li class="terms"><b>Net Asset Value per unit (NAVPU)</b> - the price of an individual UITF unit.</li>
			<li class="terms"><b>Net Asset Value per share (NAVPS)</b> - the price of an individual fund share.</li>
			<li class="terms"><b>Fund Manager</b> - a professional who works in a bank/financial institution, in charge of managing the investments of the client investor</li>
			<li class="terms"><b>Invsetment Risk</b> - the probability or likelihood of a loss relative to the expected return on an investment. These are the common risks in investing:</li>
				<ul>
					<li>Market Risk</li>
					<li>Liquidity Risk</li>
					<li>Credit Risk</li>
					<li>Inflation Risk</li>
				</ul>
			<li class="terms"><b>Risk Profile</b> -is what determines the willingness of the investor to take on (or avoid) risk, to create a strategy in decision making and diversifying an investment portfolio. The different Risk Profiles are:</li>
				<ul>
					<li>Conservative</li>
					<li>Moderately Conservative</li>
					<li>Moderate</li>
					<li>Moderately Aggressive</li>
					<li>Aggressive</li>
				</ul>
			<li class="terms"><b>Liquidity</b> - it is where a security or asset can be easily turned into cash without affecting the market. </li>
			<li class="terms"><b>Inflation</b> - an increase in general price level of goods or services of an economy over a period of time.</li>
			<li class="terms"><b>Portfolio</b> - collection of investments.</li>
		</ul>
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
		
		
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
    <!-- JS -->
    <script src="js/navbar.js"></script>
</body>
</html>