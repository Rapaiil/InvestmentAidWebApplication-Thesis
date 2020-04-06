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
	<title>InvAid - System Manual</title> 
	
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
		<h1>System Manual</h1>
		<p class="disclaimer">Disclaimer: InvAid is not affiliated with any of financial institutions or banks, data shown are all from financial websites that we gathered and are all based on what they have to offer.</p>
		
		<ol type="I">
			<li class="section">Register</li>
			
			<ol>
				<li class="terms">Go to Register page</li>
				<li class="terms">Fill up the necessary details: <b>First Name, Last Name, Birthday, Gender, Nationality, Address, Company, Occupation</b></li>
				<li class="terms">Click <b>Next</b></li>
				<li class="terms">Enter your <b>Email Address</b> and <b>Password</b></li>
					<ul>
						<li>Password must have at least <b>1 small letter, 1 capital letter and 1 number</b></li>
					</ul>
				<li>Complete the <b>Captcha</b></li>
				<li>Re-enter your password for confirmation</li>
				<li>Click <b>Submit</b></li>
				<li>Check your email for a verification email</li>
				<li>Click on the link provided on the email to verify your account</li>
			</ol>
			<li class="section">Login</li>
			
			<ol>
				<li class="terms">Go to <b>Login page</b></li>
				<li class="terms">Enter your <b>Email Address</b> and <b>Password</b></li>
				<li class="terms">Complete the <b>Captcha</b></li>
				<li class="terms">Click <b>Login</b></li>
				<li class="terms">Enter the <b>OTP</b> sent to your Email</li>
					<ul>
						<li>You have one(1) minute to enter the OTP, after a minute, you may have new OTP sent to your email</li>
					</ul>
				<li class="terms">Click <b>Submit</b></li>
			</ol>
				<ol type="A">
					<li class="sub-section">Forgot Password</li>
					
					<ol>
						<li class="terms">Go to <b>Login page</b></li>
						<li class="terms">Click on the <b>Forgot Password link</b></li>
						<li class="terms">Enter <b>Email Address</b></li>
						<li class="terms">Check your email for the reset password link</li>
						<li class="terms">Click on the link provided</li>
						<li class="terms">Enter your <b>new password</b></li>
						<li class="terms">Re-enter your password in <b>Confirm Password</b> for confirmation</li>
						<li class="terms">Complete the <b>Captcha</b></li>
						<li class="terms">Click <b>Submit</b></li>
						<li class="terms"><b>Login</b></li>
					</ol>
				</ol>
			<li class="section">Monitoring of Mutual Funds and Unit Investment Trust Funds (UITF)</li>
			
			<ol>
				<li class="terms">Go to <b>Monitoring page</b> </li>
				<li class="terms">For the list of <b>Mutual Funds</b>, click on the <b>Mutual Funds tab</b>. Click on the <b>Unit Investment Trust Funds tab</b> for the list of <b>UITF</b>.</li>
			</ol>
				<ol type="A">
					<li class="sub-section">Currency Conversion</li>
					
					<ol>
						<li class="terms">Enter your <b>desired amount</b>.</li>
						<li class="terms">Choose the <b>currency of your amount</b>.</li>
						<li class="terms">Choose the <b>currency of the money you want to convert it to</b>.</li>
					</ol>
				</ol>
			<li class="section">Risk Profile Questionnaire</li>
				<ol type="A">
					<li class="sub-section">Risk Profile Result</li>
					<ol>
						<li class="terms">Go to <b>Risk Profile Questionnaire</b> in the navigation bar</li>
						<li class="terms">Click <b>Take Questionnaire</b></li>
						<li class="terms">Answer the Questionnaire</li>
						<li class="terms">Click Submit when finished and your Risk Profile Result will be displayed.</li>
						<li class="terms">You may <b>Save your result</b>, but you must either be <b>logged in</b> or <b>have an account</b>.</li>
						<li class="terms"><b>Downloading it in PDF</b> format is also an option</li>
					</ol>
					<li class="sub-section">Recommendations</li>
					<ol>
						<li class="terms">Go to <b>Risk Profile Questionnaire</b> in the navigation bar</li>
						<li class="terms">Click <b>Take Questionnaire</b></li>
						<li class="terms">Answer the Questionnaire</li>
						<li class="terms">Click Submit when finished and your Risk Profile Result will be displayed.</li>
						<li class="terms">Click <b>View Recommendations</b> for the list of recommended funds based on your risk profile.</li>
						<li class="terms">Click <b>See Details</b> to view further information on the individual funds</li>
					</ol>
				</ol>
			<li class="section">Portfolio</li>
				<p class="note">You must be logged in to your account access this page. <br/>
				InvAid only estimates the calculations of the investments, other fees are not part of our computations.
				</p>
				<ol>
					<li class="terms">Login to your account</li>
					<li class="terms">Click the dropdown button beside your name, and click My Investment Portfolio</li>
					<li class="terms">You may now view a summary of your funds and the top 3 funds that has performed best.</li>
				</ol>
				<ol type="A">
					<li class="sub-section">Enroll/Add Funds</li>
					<ol>
						<li class="terms">Login to your account</li>
						<li class="terms">Click the dropdown button beside your name, and click My Investment Portfolio</li>
						<li class="terms">In the side, click on Enroll Fund</li>
						<li class="terms">Fill up the necessary details of the fund</li>
						<li class="terms">Click Submit when finished</li>
					</ol>
					<li class="sub-section">Edit Funds</li>
					<ol>
						<li class="terms">Login to your account</li>
						<li class="terms">Click the dropdown button beside your name, and click My Investment Portfolio</li>
						<li class="terms">In the side, click on either Mutual Funds/Unit Investment Trust Funds to view all your funds</li>
						<li class="terms">Choose the fund you wish to edit/update and click on Edit</li>
						<li class="terms">Fill up the necessary details</li>
						<li class="terms">Click Submit when finished</li>
					</ol>
					<li class="sub-section">Delete Funds</li>
					<ol>
						<li class="terms">Login to your account</li>
						<li class="terms">Click the dropdown button beside your name, and click My Investment Portfolio</li>
						<li class="terms">In the side, click on either Mutual Funds/Unit Investment Trust Funds to view all your funds</li>
						<li class="terms">Choose the fund you wish to delete and click on Delete</li>
						<li class="terms">Click Confirm if you wish to continue to delete the fund, or Cancel if otherwise.</li>
					</ol>
				</ol>
			<li class="section">Account Settings</li>
				<p class="note">You must be logged in to your account access this page.</p>
				<ol>
					<li class="terms">Login to your account</li>
					<li class="terms">Click the dropdown button beside your name, and click Account Settings</li>
					<li class="terms">Fill in any of the information you wish to change</li>
					<li class="terms">Click Save to update your current information</li>
				</ol>
			<li class="section">Risk Profile</li>
				<p class="note">You must be logged in to your account access this page.</p>
				<ol>
					<li class="terms">Login to your account</li>
					<li class="terms">Click the dropdown beside your name, and click Risk Profile to view your saved Risk Profile.</li>
					<li class="terms">You may opt to update your profile by clicking Update Risk Profile</li>
					<li class="terms">Take the questionnaire again, and will be given a new risk profile result and recommendations</li>
				</ol>
			<li class="section">Reset Password</li>
				<p class="note">You must be logged in to your account access this page.</p>
				<ol>
					<li class="terms">Login to your account</li>
					<li class="terms">Click the dropdown beside your name, and click Reset Password</li>
					<li class="terms">Enter your new Password</li>
					<li class="terms">Re-enter your password in Confirm Password for confirmation</li>
					<li class="terms">Complete the Captcha</li>
					<li class="terms">Click Submit</li>
				</ol>
			<li class="section">Feedback</li>
				
				<ol>
					<li class="terms">Click on Feedback in the navigation bar</li>
					<li class="terms">Fill in the necessary details</li>
					<li class="terms">Enter your inquiry/comments/recommendations/feedback on the message box</li>
					<li class="terms">Click on Submit when finished</li>
				</ol>
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