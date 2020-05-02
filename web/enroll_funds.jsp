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
    <link rel="stylesheet" type="text/css" href="css/enroll_funds.css">
    <link rel="stylesheet" type="text/css" href="css/modal.css">

    <!-- Chart JS -->
    <link rel="stylesheet" rel="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    
	<title>InvAid - Portfolio Enroll Funds</title> 
	
	<!-- Fonts to be used are imported here via Google Fonts, before being recognized by the css -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Condensed|Titillium+Web&display=swap">
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
        
        <section class="mt-5">
        <div class="container">
            <div class="card mx-auto">
                <div class="card-body">
                    <s:form>
                        <h1>Enroll Investment</h1>
                        <div class="form-group">
                            <label for="investment-type">Investment Type: *</label>
                            <br/>
                            <div class="custom-control custom-radio custom-control-inline">
                                <input type="radio" id="mutual_fund" name="customRadioInline1" class="custom-control-input">
                                <label class="custom-control-label" for="mutual_fund">Mutual Fund</label>
                            </div>
                            <div class="custom-control custom-radio custom-control-inline">
                                <input type="radio" id="uitf" name="customRadioInline1" class="custom-control-input">
                                <label class="custom-control-label" for="uitf">UITF</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="fund-name">Fund Name: *</label>
                            <select class="custom-select" id="fund-name" required>
                                <option>...</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="units-bought">Number of Units bought: *</label>
                            <select class="custom-select" id="units-bought" required>
                                <option>...</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="date-purchased">Date Purchased: *</label>
                            <input type="date" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="horizon">Investment Horizon: *</label>
                            <select class="custom-select" id="horizon" required>
                                <option>...</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="amount">Initial Amount of Investment: *</label>
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">&#8369;</div>
                                </div>
                                <input type="text" class="form-control">
                                <div class="input-group-append">
                                    <span class="input-group-text">.00</span>
                                </div>
                            </div>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary text-uppercase btn-lg">Submit</button>
                        </div>
                    </s:form>
                </div>
            </div>
        </div>
    </section>

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