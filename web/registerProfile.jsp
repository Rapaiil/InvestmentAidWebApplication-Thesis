<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%-- <s:action name="generategenderlist" executeResult="true"/> --%>
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
	<link rel="stylesheet" href="css/registerProfile.css" type="text/css">
	<title>InvAid - Register</title> <!-- The index.jsp of this is the Registration landing. -->
	
	<!-- Fonts to be used are imported here via Google Fonts, before being recognized by the css -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Condensed|Titillium+Web&display=swap">
</head>
<body>
	<!-- Navbar -->
      
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
                        <a class="nav-link" href="#">Monitoring</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Feedback</a>
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
        
        <!-- Register Form - Profile -->
		<div class="h-75 d-flex justify-content-center">
			<div class="card my-auto">
				<div class="form-register">
					<div class="card-body pl-5 pr-5">
					<s:form action="registerprofile" method="post" class="registration-profile-form">
							<h4 class="card-title text-center mb-5 text-uppercase">register</h4>
							<div class="form-row mb-3">
								<div class="col-xl col-lg col-md-12 col-12 form-group">
							    	<label>First Name: <span class="required">*</span></label>
									<s:textfield name="user_firstname" cssClass="form-control" required="true"/>
								</div>
								<div class="col-xl col-lg col-md-12 col-12">
									<label>Middle Name: <span class="required">*</span></label>
									<s:textfield name="user_middlename" cssClass="form-control" required="true"/>
								</div>
								<div class="col-xl col-lg col-md-12 col-12">
									<label>Last Name: <span class="required">*</span></label>
									<s:textfield name="user_lastname" cssClass="form-control" required="true"/>
								</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-lg col-md-12 col-12">
										<label>Gender: <span class="required">*</span></label>
										<div class="custom-control custom-radio custom-control-inline">
										  
										  <%-- <s:radio ccsClass="custom-control-input" name="user_gender" list="genders" value="defaultValue"/> --%>
										  <input type="radio" id="radioMale" name="customRadioInline1" class="custom-control-input" checked="checked">
										  <label class="custom-control-label" for="radioMale" >Male</label>
										</div>
										<div class="custom-control custom-radio custom-control-inline">
										  <input type="radio" id="radioFemale" name="customRadioInline1" class="custom-control-input">
										  <label class="custom-control-label" for="radioFemale">Female</label>
										</div>
									</div>
									<div class="col-lg col-md-12 col-12">
										<label>Citizenship: <span class="required">*</span></label>
										<s:textfield name="user_citizenship" cssClass="form-control" required="true" />
									</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-lg-6 col-md-12 col-12">
										<label>Cellphone Number: <span class="required">*</span></label>
										<s:textfield name="user_cellphonenumber" cssClass="form-control"  required="true"/>
									</div>
									<div class="col-lg-6 col-md-12 col-12">
										<label>Telephone Number: <span class="required">*</span></label>
										<s:textfield name="user_telephonenumber" cssClass="form-control" required="true"/>
									</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-md-12 col-12">
										<label>Present Address: <span class="required">*</span></label>
										<s:textfield name="user_primaryaddress" cssClass="form-control"  required="true"/>
									</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-md-12 col-12">
										<label>Permanent Address: <span class="required">*</span></label>
										<s:textfield name="user_permanentaddress" cssClass="form-control"  required="true"/>
									</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-md-3 col-12">
										<label>Postal Code: <span class="required">*</span></label>
										<s:textfield name="user_postalcode" cssClass="form-control"  required="true"/>
									</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-xl col-md-12 col-12">
										<label>Occupation: <span class="required">*</span></label>
										<s:textfield name="user_occupation" cssClass="form-control" required="true"/>
									</div>
									<div class="col-xl col-md-12 col-12">
										<label>Company Name: <span class="required">*</span></label>
										<s:textfield name="user_company" cssClass="form-control" required="true"/>
									</div>
								</div>
								<s:submit value="Next" class="btn btn-primary btn-block btn-lg shadow-none text-uppercase w-25 mx-auto"/>
								<!-- <button id="regProfile_button" type="submit" class="btn btn-primary btn-block btn-lg shadow-none text-uppercase w-25 mx-auto">Next</button> -->
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