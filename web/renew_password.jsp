<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html lang="en">
    <head>
        <title>InvAid - Renew Password</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- Custom CSS-->
        <link rel="stylesheet" type="text/css" href="css/renew_password.css">

        <!-- Font -->
        <link href="https://fonts.googleapis.com/css?family=Lato|Roboto+Condensed|Titillium+Web&display=swap" rel="stylesheet">
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js" type="text/javascript"></script>
	
		<!-- JQuery CDN -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    	<script src="https://www.google.com/recaptcha/api.js"></script>
    </head>
    <body>

        <!-- NAVBAR -->
        <nav class="navbar navbar-expand-lg navbar-custom hover-underline-menu navbar-fized-top" data-menu-underline-from-center>
            <a class="navbar-brand" href="index.jsp"><img src="assets/logo.png" alt="InvAid_logo" height="50" width="50"/> </a>
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
            </div>
        </nav>
        
            <!-- RENEW PASSWORD -->
            <div class="h-75 d-flex justify-content-center">
                <div class="card my-auto">
                    <div class="form-login my-auto">
                        <div class="card-body">
                            <h4 class="card-title text-uppercase pb-5">Password Reset</h4>
                            <s:form action="renewpassword" method="post">
                                <div class="form-group">
                                    <label>Password <span class="required" style="color:red;">*</span></label>
                                    <s:password  cssClass="form-control" name="reset_password" placeholder="Password"/>
									<div class="progress mt-1">
										<div class="progress-bar"></div>
									</div>
                                </div>
                                <div class="form-group">
                                    <label>Confirm Password <span class="required" style="color:red;">*</span></label>
                                    <s:password  cssClass="form-control" name="reset_confirmpassword" placeholder="Confirm Password"/>
                                </div>
                                
                                <div class="g-recaptcha mb-3" data-sitekey="6LdivccUAAAAAIHbyNfHrXPqIxs7vb09-srsnbAD"></div>
                                
                                <div class="form-group">
                                    <s:submit value="submit" id="renew_password_btn" type="submit" class="btn btn-primary btn-block btn-lg shadow-none text-uppercase"/>
                                </div>
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
		<script src="js/password-meter.js"></script>
    </body>
</html>