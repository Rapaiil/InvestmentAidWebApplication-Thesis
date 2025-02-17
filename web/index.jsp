<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="en">
  <head>
    <title>InvAid</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Custom CSS-->
    <link rel="stylesheet" type="text/css" href="css/index.css">
	<link rel="stylesheet" type="text/css" href="css/modal.css">

    <!-- Font -->
    <link href="https://fonts.googleapis.com/css?family=Lato|Roboto+Condensed|Titillium+Web&display=swap" rel="stylesheet">
  </head>
  <body>
      <!-- Navbar -->
      <section class="header">
      <s:if test="%{#session.loginToken==null}">
      <!-- IF ELSE REGISTERED/UNREGISTERED USER NAVBAR -->
        <nav class="navbar navbar-expand-lg navbar-custom hover-underline-menu navbar-fized-top" data-menu-underline-from-center>
            <a class="navbar-brand" href="index.jsp"><img src="assets/logo.png" alt="InvAid_logo" height="50" width="50"/> </a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
                aria-expanded="false" aria-label="Toggle navigation">
                <span><i class="fa fa-bars" aria-hidden="true"></i></span> 
            </button>
            <div class="collapse navbar-collapse main-menu" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0 menu">
                    <li class="nav-item active">
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
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                </ul>
            </div>
        </nav>
        </s:if>
        <s:else>
        <!-- LOGGED IN/REGISTERED USER NAVBAR -->
        <nav class="navbar navbar-expand-lg navbar-custom hover-underline-menu navbar-fized-top" data-menu-underline-from-center>
            <a class="navbar-brand" href="index.jsp"><img src="assets/logo.png" alt="InvAid_logo" height="50" width="50"/> </a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
                aria-expanded="false" aria-label="Toggle navigation">
                <span><i class="fa fa-bars" aria-hidden="true"></i></span> 
            </button>
            <div class="collapse navbar-collapse main-menu" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0 menu">
                    <li class="nav-item active">
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
		</s:else>
		<!-- STATUS ALERT -->
		<s:if test="%{#session.userStatus != null & #session.userStatus==unverified}">
			<div class="alert alert-warning mx-auto" role="alert">
			  You have not verified your account yet. Please check your email for the verification link.
			</div>
		</s:if>
		
        <!-- HEADER Content -->
        <div class="header-content">
            <div class="row">
            	<div class="col-md-6 tagline">
            		<h1>Invest in your future. Invest now.</h1>
            		<h3>Investment Aid</h3>
            	</div>
            	<div class="col-md-6">
            		<img src="assets/invest_landing.svg" style="width: 700px;">
            	</div>
            </div>
        </div>
        
    </section>
    
    <section class="content">
       <!-- ABOUT SECTION -->
        <div id="aboutSection" class="about-row content-wrapper col-md-12">
            <div class="content-section">
                <h3>Watch your money grow</h3>
                <p>Start investing now and see your money's growth overtime and be ready for the future. <br/>
                    <b>Investment Aid</b>, or <b>InvAid</b> for short, is a web application that will aid you in monitoring and tracking <b>Mutual Funds</b> and <b>Unit Investment Trust Funds</b>. <br/>
                    Manage your portfolio by adding your funds and keep track of it's growth, as well as get Fund Recommendations based on your Risk Profile!</p>
                    <div class="features-row row">
                        <div class="col">
                            <img src="assets/recommendation.png" width="50" height="50" class="mx-auto d-block img-fluid"/>
                            <p>Fund Recommendation</p>
                        </div>
                        <div class="col">
                            <img src="assets/portfolio.png" width="50" height="50" class="mx-auto d-block img-fluid"/>
                            <p>Investment Portfolio Management</p>
                        </div>
                        <div class="col">
                            <img src="assets/monitoring_tracking.png" width="50" height="50" class="mx-auto d-block img-fluid"/>
                            <p>Fund Monitoring and Tracking</p></div>
                        <div class="col">
                            <img src="assets/currency_conversion.png" width="50" height="50" class="mx-auto d-block img-fluid"/>
                            <p>Currency Conversion</p>
                        </div>
                    </div>
            </div>
        </div>
       <!-- QUESTIONNAIRE SECTION -->
        <div class="questionnaire-row content-wrapper">
            <div class="content-section row">
                <div class="col-12 col-md-6">
                    <h3>Take the quiz. Know your Investor profile.</h3>
                    <p>Want to know the type of investor you are? <br/> Are you willing to take on risk? <br/>
                    	Find out your Investor Profile by taking the Risk Profile Questionnaire, and get the suitable funds based on the result.
                    </p>
                </div>
                <div class="col-md-6 align-self-center">
                    <!-- <button type="button" id="questionnaire-quick-link-button" class="btn btn-primary float-right">TAKE QUESTIONNAIRE &nbsp; <i class="fa fa-chevron-right" aria-hidden="true"></i></button> -->
                    <!-- IMAGE/VECTOR/GRAPHIC OF INVESTMENT RISK PROFILE QUESTIONNAIRE -->
                    <a href="questionnaire_landing.jsp" class="custom-btn float-left mx-auto">TAKE QUESTIONNAIRE &nbsp;<i class="fa fa-chevron-right"></i></a>
                </div>
            </div>
        </div>
       <!-- QUICK LINKS SECTION-->
        <div class="quick-links-row content-wrapper">
            <div class="content-section row row-centered" style="font-size: 24px;">
                <!-- Investment card-->
                <div class="col col-lg col-md col-sm col-centered">
                    <div class="card" style="width: 18rem">
                        <img src="assets/investment_guide.png" alt="investment_guide" width="50" height="50" class="mx-auto d-block img-fluid" />
                        <h5 id="investment-guide-quick-link"><a href="investment_guide.jsp">Investment Guide</a></h5>
                        <p>Check our 'FAQ', where you will find some Investing Terms, a basic guide to Investing on Mutual Funds and UITF, as well as how to navigate InvAid</p>
                    </div>
                </div>
                <!-- Monitoring card-->
                <div class="col col-lg col-md col-sm col-centered">
                    <div class="card" style="width: 18rem">
                            <img src="assets/monitoring.png" alt="monitoring" width="50" height="50" class="mx-auto d-block img-fluid" />
                        <h5 id="monitoring-quick-link"><a href="monitoring.jsp">Monitoring</a></h5>
                        <p>Monitor the Mutual Funds and UITF market, and see if you are interested in any of them.</p>
                    </div>
                </div>
               <!-- Feedback card-->
                <div class="col col-lg col-md col-sm col-centered">
                    <div class="card" style="width: 18rem">
                            <img src="assets/feedback.png" alt="feedback" width="50" height="50" class="mx-auto d-block img-fluid" />
                        <h5 id="feedback-quick-link"><a href="feedback.jsp">Feedback</a></h5>
                        <p>Got any inquiries or feedback? You can send them all here. </p>
                    </div>
                </div>
            </div>
        </div>

        <!-- FOOTER -->
        <footer>
            <div class="container">
              <div class="footer-wrapper">
                <div class="row">
                    <div class="col-lg-12 footer-links">
                        <h5>QUICK LINKS</h5>
                        <ul>
                            <li><a href="investment_guide.jsp">Investment Guide</a></li>
                            <li><a href="questionnaire_landing.jsp">Risk Profile Questionnaire</a></li>
                            <li><a href="monitoring.jsp">Monitoring</a></li>
                            <li><a href="feedback.jsp">Feedback</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-12 footer-copyright text-white-50 text-center">
                        <p><i class="fa fa-copyright" aria-hidden="true"></i> InvAid 2019-2020</p>
                    </div>
                </div>
              </div>
            </div>
          </footer>
		  
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
	<script src="js/sticky-navbar.js"></script>
    </body>
</html>