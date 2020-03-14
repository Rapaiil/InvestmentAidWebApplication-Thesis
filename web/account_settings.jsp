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
	<link rel="stylesheet" href="css/account_settings.css" type="text/css">
	<link rel="stylesheet" href="css/modal.css" type="text/css">
	
	
	<title>InvAid - Account Settings</title> 
	
	 <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- Fonts to be used are imported here via Google Fonts, before being recognized by the css -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Condensed|Titillium+Web&display=swap">
</head>
<body>
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
	
        <div class="h-75 d-flex justify-content-center">
            <div class="card my-auto">
                <div class="account my-auto">
                    <div class="card-body mx-auto">
                        <h2 class="card-title text-uppercase pb-3">Account Settings</h2>
                        <div class="form-inline">
                        	<div class="form-group">
								<label for="firstName">First Name:</label>
								<s:textfield id="firstName" cssClass="form-control mx-sm-3" onchange="validate()" value="[firstName]" readonly="true"></s:textfield>
								<small id="fNameError" class="form-text text-danger">Please enter First Name</small>
					  		</div>
                        </div>
                        <div class="form-inline">
					  		<div class="form-group">
								<label for="lastName">Last Name:</label>
								<s:textfield id="lastName" cssClass="form-control mx-sm-3" onchange="validate()" value="[lastName]" readonly="true"></s:textfield>
								<small id="lNameError" class="form-text text-danger">Please enter Last Name</small>
					  		</div>
                        </div>
						<div class="form-inline">
					  		<div class="form-group">
								<label for="telNum">Telephone Number:</label>
								<s:textfield id="telNum" cssClass="form-control mx-sm-3" onchange="validate()" value="[telNum]" readonly="true"></s:textfield>
								<small id="telNumError" class="form-text text-danger">Please enter Telephone Number</small>
					  		</div>
                        </div>
                        <div class="form-inline">
					  		<div class="form-group">
								<label for="mobileNum">Mobile Number:</label>
								<s:textfield id="mobileNum" cssClass="form-control mx-sm-3" onchange="validate()" value="[mobileNum]" readonly="true"></s:textfield>
								<small id="mobileNumError" class="form-text text-danger">Please enter Mobile Number</small>
					  		</div>
                        </div>
                        <div class="form-inline">
					  		<div class="form-group">
								<label for="emailAdd">E-mail Address:</label>
								<s:textfield id="emailAdd" cssClass="form-control mx-sm-3" onchange="validate()" value="[emailAdd]" readonly="true"></s:textfield>
								<small id="emailAddError" class="form-text text-danger">Please enter E-mail Address</small>
					  		</div>
                        </div>
                        <div id="buttons" class="buttons text-center mt-5">
                        	<a type="button" href="#" id="editAccount" onclick="editAccount()" class="btn btn-primary text-uppercase account-btn">Edit Account Details</a>
                        	<div id="actionbuttons"></div>
                        </div>
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
    
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
    <!-- JS -->
    <script src="js/navbar.js"></script>
    <script src="js/account.js"></script>
</body>
</html>