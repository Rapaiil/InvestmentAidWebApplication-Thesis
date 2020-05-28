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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

	<!-- Custom CSS -->
	<link rel="stylesheet" href="css/questionnaire_set.css" type="text/css">
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
	                    <li class="nav-item active">
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
	                    <li class="nav-item">
	                        <a class="nav-link" href="investment_guide.jsp">Investment Guide</a>
	                    </li>
	                    <li class="nav-item active">
	                        <a class="nav-link" href="questionnaire_landing.jsp">Risk Profile Questionnaire</a>
	                    </li>
	                    <li class="nav-item ">
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
        
        <div class="container mx-auto p-5">
        	<h2 class="text-center mb-3">Risk Profile Questionnaire</h2>
        	<s:form>
				<h5 class="text-uppercase">time horizon</h5>
				<label class="pt-3">1. I plan to begin withdrawing money from my investments in:</label>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="timehorizon_1_1" name="timeHorizon1" class="custom-control-input">
					<label class="custom-control-label" for="timehorizon_1_1">Less than 3 years</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="timehorizon_1_2" name="timeHorizon1" class="custom-control-input">
					<label class="custom-control-label" for="timehorizon_1_2">3 - 5 years</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="timehorizon_1_3" name="timeHorizon1" class="custom-control-input">
					<label class="custom-control-label" for="timehorizon_1_3">6 - 10 years</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="timehorizon_1_4" name="timeHorizon1" class="custom-control-input">
					<label class="custom-control-label" for="timehorizon_1_4">11 years or more</label>
				</div>
				<label class="pt-3">2. Once I begin withdrawing funds from my investments, I plan to spend all of the funds in:</label>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="timehorizon_2_1" name="timeHorizon2" class="custom-control-input">
					<label class="custom-control-label" for="timehorizon_2_1">Less than 2 years</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="timehorizon_2_2" name="timeHorizon2" class="custom-control-input">
					<label class="custom-control-label" for="timehorizon_2_2">2 - 5 years</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="timehorizon_2_3" name="timeHorizon2" class="custom-control-input">
					<label class="custom-control-label" for="timehorizon_2_3">6 - 10 years</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="timehorizon_2_4" name="timeHorizon2" class="custom-control-input">
					<label class="custom-control-label" for="timehorizon_2_4">11 years or more</label>
				</div>
				<hr />
				<!-- RISK TOLERANCE SECTION -->
				<h5 class="text-uppercase">risk tolerance</h5>
				<label class="pt-3">3. I would describe my knowledge of investments as:</label>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_3_1" name="riskTolerance1" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_3_1">None</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_3_2" name="riskTolerance1" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_3_2">Limited</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_3_3" name="riskTolerance1" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_3_3">Good</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_3_4" name="riskTolerance1" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_3_4">Extensive</label>
				</div>
				<label class="pt-3">4. When I invest my money, I am:</label>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_5_1" name="riskTolerance2" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_5_1">Most concerned about my investment losing value</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_5_2" name="riskTolerance2" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_5_2">Equally concerned about my investment losing or gaining
						value</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_4_3" name="riskTolerance2" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_4_3">Most concerned about my investment gaining value</label>
				</div>
				<label class="pt-3">5. Select the investments you currently own:</label>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_5_1_1" name="riskTolerance3" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_5_1_1">Bonds and/or bond funds</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_5_2_2" name="riskTolerance3" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_5_2_2">Stocks and/or stock funds</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_5_3_3" name="riskTolerance3" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_5_3_3">International securities and/or international
						funds</label>
				</div>
				<label class="pt-3">6. Consider this scenario: Imagine that in the past three months, the overall stock market lost 25%
					of its value.
					An individual value. An individual stock investment you own also lost 25% of its value. What would you do?</label>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_6_1" name="riskTolerance4" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_6_1">Sell all of my shares</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_6_2" name="riskTolerance4" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_6_2">Sell some of my shares</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_6_3" name="riskTolerance4" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_6_3">Do nothing</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_6_4" name="riskTolerance4" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_6_4">Buy more shares</label>
				</div>
				<label class="pt-3">7. Review the chart below. We've outlined the most likely best-case and worst-case annual returns of
					five hypothetical investment plans.
					Which range of possible outcomes is most acceptable to you?
					The figures are hypothetical and do not represent the performance of any particular investment.</label>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Plan</th>
							<th scope="col">Average Annual Return</th>
							<th scope="col">Best Case</th>
							<th scope="col">Worse Case</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">A</th>
							<td>7.2%</td>
							<td>16.3%</td>
							<td>-5.6%</td>
						</tr>
						<tr>
							<th scope="row">B</th>
							<td>9.0%</td>
							<td>25.0%</td>
							<td>-12.1%</td>
						</tr>
						<tr>
							<th scope="row">C</th>
							<td>10.4%</td>
							<td>33.6%</td>
							<td>18.2%</td>
						</tr>
						<tr>
							<th scope="row">D</th>
							<td>11.7%</td>
							<td>42.8%</td>
							<td>24.0%</td>
						</tr>
						<tr>
							<th scope="row">D</th>
							<td>12.5%</td>
							<td>50.0%</td>
							<td>-28.2%</td>
						</tr>
					</tbody>
				</table>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_7_1" name="riskTolerance5" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_7_1">Plan A</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_7_2" name="riskTolerance5" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_7_2">Plan B</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_7_3" name="riskTolerance5" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_7_3">Plan C</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_7_4" name="riskTolerance5" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_7_4">Plan D</label>
				</div>
				<div class="custom-control custom-radio pl-5">
					<input type="radio" id="risktolerance_7_5" name="riskTolerance5" class="custom-control-input">
					<label class="custom-control-label" for="risktolerance_7_5">Plan E</label>
				</div>
				<div class="text-center mt-5">
	      			<s:submit label="Submit" value="submit" class="btn btn-primary btn-lg questionnaire-btn shadow-none text-uppercase"/>
	      		</div>
      		</s:form>
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
    <script src="js/question.js"></script>
</body>
</html>