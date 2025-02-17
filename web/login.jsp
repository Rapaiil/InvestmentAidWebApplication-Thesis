<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
        <title>InvAid - Login</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- Custom CSS-->
        <link rel="stylesheet" type="text/css" href="css/login.css">

        <!-- Font -->
        <link href="https://fonts.googleapis.com/css?family=Lato|Roboto+Condensed|Titillium+Web&display=swap" rel="stylesheet">
    	
		<!-- reCAPTCHA -->
		<script src="https://www.google.com/recaptcha/api.js"></script>
    </head>
    <body>

        <!-- Navbar -->
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
                    <li class="nav-item">
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
                    <li class="nav-item active">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                </ul>
            </div>
        </nav>
        
		<!-- STATUS ALERT -->
        
        <s:if test="%{#session.userStatus == on-going}">
		 	<div class="alert alert-danger mx-auto" role="alert">
			  You have not yet completed in renewing your password.
			</div>
		</s:if>
		
		<!-- LOGIN -->
		<div class="h-75 d-flex justify-content-center">
			<div class="card my-auto">
				<div class="form-login my-auto">
					<div class="card-body">
						<h4 class="card-title text-uppercase">login</h4>
						<s:form action="loginotp" method="post">
							<div class="form-group">
								<label>Email Address</label>
								<s:textfield  cssClass="form-control" name="login_email" placeholder="Email Address" required="required"/>
							</div>
							<div class="form-group">
								<label>Password</label>
								<s:password  cssClass="form-control" name="login_password" placeholder="Password" required="required"/>
							</div>
							
							<s:textfield name="lgrn" type="hidden" class="recaptcha-error"/>
							<div id="gr" class="g-recaptcha mb-3" data-sitekey="6LdivccUAAAAAIHbyNfHrXPqIxs7vb09-srsnbAD"></div>
							
							<div class="form-group">
								<button id="login_button" type="submit" class="btn btn-primary btn-block btn-lg shadow-none text-uppercase btnLogin">Login</button>
							</div>
							<p class="hint-text"><a href="forgot_password.jsp">Forgot Password?</a></p>
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