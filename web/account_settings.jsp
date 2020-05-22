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
	
	<div class="h-75 d-flex justify-content-center">
		<div class="card my-auto">
			<div class="account my-auto">
				<div class="card-body mx-auto">
					<h2 class="card-title text-uppercase">Account Settings</h2>
					<hr>
					<h4>Personal Information</h4>
					<s:form action="saveaccount" class="account-settings-form" method="post">
						<div class="form-row">
							<div class="col-md form-group">
								<p class="em" id="lfn" for="fn"></p>
								<s:textfield name="lfntf" type="hidden"/>
								<label>First Name:</label>	
								<s:textfield id="fn" name="first_name" cssClass="form-control" required="required"/>
							</div>
							
							<div class="col-md">
								<p class="em" id="lln" for="ln"></p>
								<s:textfield name="llntf" type="hidden"/>
								<label>Last Name:</label>
								<s:textfield id="ln" name="last_name"  cssClass="form-control" required="required"/>
							</div>
						</div>
						<div class="form-row">
							
							<div class="col-md form-group">
								<p class="em" id="lbd" for="bd"></p>
								<label>Birthday:</label>
								<input id="bd" name="birthday" type="date" class="form-control birthday" required/>
							</div>
							<div class="col-md"></div>
						</div>
						<div class="form-row">
							
							<div class="col-md form-group">
								<p class="em" id="ltn" for="tn"></p>
								<s:textfield name="ltntf" type="hidden"/>
								<label>Telephone Number:</label>
								<s:textfield id="tn" name="telephone_no"  cssClass="form-control" required="required"/>
							</div>
							
							<div class="col-md">
								<p class="em" id="lcn" for="cn"></p>
								<s:textfield name="lcntf" type="hidden"/>
								<label>Cellphone Number:</label>
								<s:textfield id="cn" name="cellphone_no"  cssClass="form-control" required="required"/>
							</div>
						</div>
						<div class="form-row">
							
							<div class="col-md form-group">
								<p class="em" id="lea" for="ea"></p>
								<s:textfield name="leatf" type="hidden"/>
								<label>E-mail Address:</label>
								<s:textfield id="ea" name="email_address"  cssClass="form-control" required="required"/>
							</div>
							<div class="col-md"></div>
						</div>
						<hr>
						<h4>Occupation & Company Information</h4>
						<div class="form-row">
							
							<div class="col-md form-group">
								<p class="em" id="locc" for="occ"></p>
								<s:textfield name="locctf" type="hidden"/>
								<label>Occupation:</label>
								<s:textfield id="occ" name="occupation"  cssClass="form-control" required="required"/>
							</div>
							
							<div class="col-md">
								<p class="em" id="lcom" for="com"></p>
								<s:textfield name="lcomtf" type="hidden"/>
								<label>Company:</label>
								<s:textfield id="com"  name="company"  cssClass="form-control" required="required"/>
							</div>
						</div> 
						
						<div class="float-right">
							<button type="submit" class="btn btn-primary btnSave text-uppercase">Save</button>
						</div> 
					</s:form>                      
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
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    
    <!-- JS -->
    <script src="js/navbar.js"></script>
    <script src="js/profileLoading.js"></script>
    <script src="js/account.js"></script>
    
</body>
</html>