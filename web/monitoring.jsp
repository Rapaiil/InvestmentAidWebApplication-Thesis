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
	<link rel="stylesheet" href="css/monitoring.css" type="text/css">
	<link rel="stylesheet" href="css/modal.css" type="text/css">
	<title>InvAid - Risk Profile Questionnaire</title> 
	
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
								<a class="dropdown-item" href="#">My Investment Portfolio</a>
								<a class="dropdown-item" href="#">Risk Profile</a>
								<a class="dropdown-item" href="#">Reset Password</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#logoutModal" data-toggle="modal">Logout</a>
							</div>
						</li>
					</ul>
				</div>
			</nav>
		</s:else>
	
		<!-- MONITORING CONTENT-->
        <div class="container-fluid p-5">
			<div class="row">
        		<div class="col-md-8">
        			<div class="input-group float-right search-bar">
					  <input type="text" class="form-control" placeholder="Search fund" aria-describedby="basic-addon2">
					  <div class="input-group-append">
					    <button class="btn btn-outline-secondary" type="button"><i class="fa fa-search" aria-hidden="true"></i></button>
					  </div>
					</div>
        		</div>
        	</div>
        	<div class="row">
        		<!-- MONITORING TABLE -->
        		<div class="col-md-8 table-responsive-lg mt-5 justify-content-center">
        			<!-- TAB -->
        			<ul class="nav nav-pills pills-dark nav-justified" id="pills-tab" role="tablist">
					  <li class="nav-item">
						 <a class="nav-link active" id="pills-mf-tab" data-toggle="pill" href="#pills-mf" role="tab" aria-controls="pills-mf" aria-selected="true">Mutual Funds</a>
					  </li>
					  <li class="nav-item  disabled">
						 <a class="nav-link" id="pills-uitf-tab" data-toggle="pill" href="#pills-uitf" role="tab" aria-controls="pills-uitf" aria-selected="false">Unit Investment Trust Funds</a>
					  </li>
					  
					</ul>
					
					<!-- MONITORING -->
					<div class="tab-content" id="pills-tabContent">
					  <div class="tab-pane fade show active" id="pills-mf" role="tabpanel" aria-labelledby="pills-mf-tab">
							<%-- <s:iterator value="data"> --%>
								<table class="table">
								  <thead>
								    <tr>
								      <th scope="col">Name</th>
								      <th scope="col">Risk Classification</th>
								      <th scope="col">Fund Classification</th>
								      <th scope="col">Affiliation</th>
								      <th scope="col"></th>
								    </tr>
								  </thead>
								  <tbody>
								    <tr>
								      <td>Mark</td>
								      <td>Otto</td>
								      <td>@mdo</td>
								      <td>@mdo</td>
								      <td><a href="#" data-toggle="modal" data-target="#fundDetailModal">See details >></a></td>
								    </tr>
								    <tr>
								      <td>Mark</td>
								      <td>Otto</td>
								      <td>@mdo</td>
								      <td>@mdo</td>
								      <td><a href="#" data-toggle="modal" data-target="#fundDetailModal">See details >></a></td>
								    </tr>
								    <tr>
								      <td>Mark</td>
								      <td>Otto</td>
								      <td>@mdo</td>
								      <td>@mdo</td>
								      <td><a href="#" data-toggle="modal" data-target="#fundDetailModal">See details >></a></td>
								    </tr>
								  </tbody>
								</table>
							<%-- </s:iterator> --%>
							<nav aria-label="Page navigation example">
							  <ul class="pagination justify-content-end">
							    <li class="page-item">
							      <a class="page-link" href="#" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							        <span class="sr-only">Previous</span>
							      </a>
							    </li>
							    <li class="page-item"><a class="page-link" href="#">1</a></li>
							    <li class="page-item"><a class="page-link" href="#">2</a></li>
							    <li class="page-item"><a class="page-link" href="#">3</a></li>
							    <li class="page-item">
							      <a class="page-link" href="#" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							        <span class="sr-only">Next</span>
							      </a>
							    </li>
							  </ul>
							</nav>
						</div>
					  	<div class="tab-pane fade" id="pills-uitf" role="tabpanel" aria-labelledby="pills-uitf-tab">
							<%-- <s:iterator value="data"> --%>
								<table class="table">
									  <thead>
									    <tr>
									      <th scope="col">Name</th>
									      <th scope="col">Risk Classification</th>
									      <th scope="col">Fund Classification</th>
									      <th scope="col">Affiliation</th>
									      <th scope="col"></th>
									    </tr>
									  </thead>
									  <tbody>
									    <tr>
									      <td>Mark</td>
									      <td>Otto</td>
									      <td>@mdo</td>
									      <td>@mdo</td>
									      <td><a href="#" data-toggle="modal" data-target="#fundDetailModal">See details >></a></td>
									    </tr>
									    <tr>
									      <td>Mark</td>
									      <td>Otto</td>
									      <td>@mdo</td>
									      <td>@mdo</td>
									      <td><a href="#" data-toggle="modal" data-target="#fundDetailModal">See details >></a></td>
									    </tr>
									    <tr>
									      <td>Mark</td>
									      <td>Otto</td>
									      <td>@mdo</td>
									      <td>@mdo</td>
									      <td><a href="#" data-toggle="modal" data-target="#fundDetailModal">See details >></a></td>
									    </tr>
									  </tbody>
								</table>
							<%-- </s:iterator> --%>
							<nav aria-label="Page navigation example">
							  <ul class="pagination justify-content-end">
							    <li class="page-item">
							      <a class="page-link" href="#" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							        <span class="sr-only">Previous</span>
							      </a>
							    </li>
							    <li class="page-item"><a class="page-link" href="#">1</a></li>
							    <li class="page-item"><a class="page-link" href="#">2</a></li>
							    <li class="page-item"><a class="page-link" href="#">3</a></li>
							    <li class="page-item">
							      <a class="page-link" href="#" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							        <span class="sr-only">Next</span>
							      </a>
							    </li>
							  </ul>
							</nav>
						</div>
					  </div>
        		</div>
        		<!-- CURRENCY CONVERTER -->
        		<div class="col-md-4 mt-5">
        			<h3 class="text-muted text-center mb-3">Currency Converter</h3>
					<div class="form-inline d-flex justify-content-center">
	        			<div class="input-group currency-converter pr-3">
							  <input type="text" class="form-control">
							  <div class="input-group-append">
							    <span class="input-group-text">0.00</span>
							  </div>
						</div>
						<select class="custom-select currencies-select" id="inputGroupSelect01">
						    <option selected>PHP</option>
						    <option value="1">USD</option>
						    <option value="2">JPY</option>
						    <option value="3">EUR</option>
					  	</select>
					</div>
					<div class="d-flex justify-content-center m-3">
						<button type="button" class="btn btn-outline-secondary"><i class="fa fa-exchange" aria-hidden="true"></i></button>
					</div>
					<div class="form-inline d-flex justify-content-center">
	        			<div class="input-group currency-converter pr-3">
							  <input type="text" class="form-control" disabled>
							  <div class="input-group-append">
							    <span class="input-group-text">0.00</span>
							  </div>
						</div>
						<select class="custom-select currencies-select" id="inputGroupSelect01">
						    <option selected>PHP</option>
						    <option value="1">USD</option>
						    <option value="2">JPY</option>
						    <option value="3">EUR</option>
					  	</select>
					</div>
        		</div>
        	</div>
       	</div>
	
	<!-- DETAILS MODAL -->
    <div class="modal fade" id="fundDetailModal">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
        
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">[Investment Fund]</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
        
            <!-- Modal body -->
            <div class="modal-body">
                <h1>[Investment Fund]</h1>
                <div class="row">
                    <div class="col-md-6">
                        <p><b>Fund Type: </b></p>
                        <p><b>Affiliation: </b></p>
                        <p><b>NAVPU/NAVPS (as of MM/DD/YYYY): </b></p>
                        <hr/>
                        <h3>Investment Application</h3>
                        <p>1.</p>
                        <p>2.</p>
                        <p>3.</p>
                        <p>4.</p>
                        <p>5.</p>
                    </div>
                    <div class="col-md-6">
                        <ul class="nav nav-pills pb-3">
                            <li class="nav-item">
                                <a class="nav-link active" href="#">Today</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Week</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Month</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">1Y</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">3Y</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">5Y</a>
                            </li>
                        </ul>
                        <canvas id="lineGraphPerformance" width="400" height="400"></canvas>
                    </div>
                </div>
            </div>
        
            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
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
    
    <!-- JS -->
    <script src="js/navbar.js"></script>
</body>
</html>