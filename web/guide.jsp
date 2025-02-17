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
	<title>InvAid - Basic Investment Steps</title> 
	
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
		<h1>Basic Investment Steps</h1>
		<ol type="I">
			<li class="section">Investing in Mutual Funds</li>
			<!-- <hr class="section-divider"/> -->
				<ol type="1">
					<li class="terms">Go to the Mutual Fund company's website</li>
					<li class="terms">Most sites require you to take a Risk Profile test to determine your risk appetite.</li>
					<li class="terms">Download and complete all forms and requirements</li>
					<li class="terms">Submit requirements via courier or by going to their office</li>
					<li class="terms">Start investing once given the confirmation or statement of account arrives</li>
				</ol>
			<p><em>There are websites authorized by SEC like COL Financial and First Metro Sec where directly buying Mutual Funds, along with Individual Stocks and Bonds are possible.</em></p>
			<li class="section">Investing in Unit Investment Trust Funds</li>
			<!-- <hr class="section-divider"/> -->
			<ol type="1">
				<li class="terms">Visit your preferred bank</li>
				<li class="terms">You may need to fill out a Client Suitability Form by the Bank Personnel, and may even suggest to you some products</li>
				<li class="terms">Choose a product</li>
				<li class="terms">Complete all requirements and forms required by the Bank Personnel</li>
				<li class="terms">Start initial deposit</li>
			</ol>
			<p><em>Some banks allow you to apply online, where once completed, a representative will contact you of the product and other necessary information.</em></p>
		</ol>
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
		        <s:form action="logoutuser" method="get">
		        	<s:submit value="Logout" class="btn btn-primary btnLogout"/>
		        </s:form>
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