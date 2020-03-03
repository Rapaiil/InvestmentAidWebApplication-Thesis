<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
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
        
        <!-- Register Form - Profile -->
		<div class="h-75 d-flex justify-content-center">
			<div class="card my-auto">
				<div class="form-register container">
					<div class="card-body pl-5 pr-5">
						<s:form action="registerprofile" method="post" class="registration-profile-form">
							<h4 class="card-title mb-5 text-uppercase">register</h4>
							<div class="form-row mb-3">
								<div class="col-xl col-lg col-md-12 col-12 form-group">
							    	<label>First Name: <span class="required">*</span></label>
									<s:textfield name="user_firstname" cssClass="form-control" placeholder="ex. Juan" required="required"/>
								</div>
								<div class="col-xl col-lg col-md-12 col-12">
									<label>Last Name: <span class="required">*</span></label>
									<s:textfield name="user_lastname" cssClass="form-control" placeholder="ex. dela Cruz" required="required"/>
								</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-lg col-md-12 col-12">
										<label>Gender: <span class="required">*</span></label>
									  	<br/>
										<div class="custom-control custom-radio custom-control-inline">
											<input type="radio" id="radioMale" name="gender" value="male" class="custom-control-input" required>
										  	<label class="custom-control-label" for="radioMale">Male</label>
										</div>
										<div class="custom-control custom-radio custom-control-inline">
										  <input type="radio" id="radioFemale" name="gender" value="female" class="custom-control-input" required>
										  <label class="custom-control-label" for="radioFemale">Female</label>
										</div>
									</div>
									<div class="col-lg col-md-12 col-12">
										<label>Birthday: <span class="required">*</span></label>
									 	<input type="date" class="form-control text-uppercase" name="user_birthday" required>
									</div>
									<div class="col-lg col-md-12 col-12">
										<label>Citizenship: </label>
										<select class="form-control text-uppercase" name="user_nationality">
										  <option value="">-- select one --</option>
										  <option value="afghan">Afghan</option>
										  <option value="albanian">Albanian</option>
										  <option value="algerian">Algerian</option>
										  <option value="american">American</option>
										  <option value="andorran">Andorran</option>
										  <option value="angolan">Angolan</option>
										  <option value="antiguans">Antiguans</option>
										  <option value="argentinean">Argentinean</option>
										  <option value="armenian">Armenian</option>
										  <option value="australian">Australian</option>
										  <option value="austrian">Austrian</option>
										  <option value="azerbaijani">Azerbaijani</option>
										  <option value="bahamian">Bahamian</option>
										  <option value="bahraini">Bahraini</option>
										  <option value="bangladeshi">Bangladeshi</option>
										  <option value="barbadian">Barbadian</option>
										  <option value="barbudans">Barbudans</option>
										  <option value="batswana">Batswana</option>
										  <option value="belarusian">Belarusian</option>
										  <option value="belgian">Belgian</option>
										  <option value="belizean">Belizean</option>
										  <option value="beninese">Beninese</option>
										  <option value="bhutanese">Bhutanese</option>
										  <option value="bolivian">Bolivian</option>
										  <option value="bosnian">Bosnian</option>
										  <option value="brazilian">Brazilian</option>
										  <option value="british">British</option>
										  <option value="bruneian">Bruneian</option>
										  <option value="bulgarian">Bulgarian</option>
										  <option value="burkinabe">Burkinabe</option>
										  <option value="burmese">Burmese</option>
										  <option value="burundian">Burundian</option>
										  <option value="cambodian">Cambodian</option>
										  <option value="cameroonian">Cameroonian</option>
										  <option value="canadian">Canadian</option>
										  <option value="cape verdean">Cape Verdean</option>
										  <option value="central african">Central African</option>
										  <option value="chadian">Chadian</option>
										  <option value="chilean">Chilean</option>
										  <option value="chinese">Chinese</option>
										  <option value="colombian">Colombian</option>
										  <option value="comoran">Comoran</option>
										  <option value="congolese">Congolese</option>
										  <option value="costa rican">Costa Rican</option>
										  <option value="croatian">Croatian</option>
										  <option value="cuban">Cuban</option>
										  <option value="cypriot">Cypriot</option>
										  <option value="czech">Czech</option>
										  <option value="danish">Danish</option>
										  <option value="djibouti">Djibouti</option>
										  <option value="dominican">Dominican</option>
										  <option value="dutch">Dutch</option>
										  <option value="east timorese">East Timorese</option>
										  <option value="ecuadorean">Ecuadorean</option>
										  <option value="egyptian">Egyptian</option>
										  <option value="emirian">Emirian</option>
										  <option value="equatorial guinean">Equatorial Guinean</option>
										  <option value="eritrean">Eritrean</option>
										  <option value="estonian">Estonian</option>
										  <option value="ethiopian">Ethiopian</option>
										  <option value="fijian">Fijian</option>
										  <option value="filipino">Filipino</option>
										  <option value="finnish">Finnish</option>
										  <option value="french">French</option>
										  <option value="gabonese">Gabonese</option>
										  <option value="gambian">Gambian</option>
										  <option value="georgian">Georgian</option>
										  <option value="german">German</option>
										  <option value="ghanaian">Ghanaian</option>
										  <option value="greek">Greek</option>
										  <option value="grenadian">Grenadian</option>
										  <option value="guatemalan">Guatemalan</option>
										  <option value="guinea-bissauan">Guinea-Bissauan</option>
										  <option value="guinean">Guinean</option>
										  <option value="guyanese">Guyanese</option>
										  <option value="haitian">Haitian</option>
										  <option value="herzegovinian">Herzegovinian</option>
										  <option value="honduran">Honduran</option>
										  <option value="hungarian">Hungarian</option>
										  <option value="icelander">Icelander</option>
										  <option value="indian">Indian</option>
										  <option value="indonesian">Indonesian</option>
										  <option value="iranian">Iranian</option>
										  <option value="iraqi">Iraqi</option>
										  <option value="irish">Irish</option>
										  <option value="israeli">Israeli</option>
										  <option value="italian">Italian</option>
										  <option value="ivorian">Ivorian</option>
										  <option value="jamaican">Jamaican</option>
										  <option value="japanese">Japanese</option>
										  <option value="jordanian">Jordanian</option>
										  <option value="kazakhstani">Kazakhstani</option>
										  <option value="kenyan">Kenyan</option>
										  <option value="kittian and nevisian">Kittian and Nevisian</option>
										  <option value="kuwaiti">Kuwaiti</option>
										  <option value="kyrgyz">Kyrgyz</option>
										  <option value="laotian">Laotian</option>
										  <option value="latvian">Latvian</option>
										  <option value="lebanese">Lebanese</option>
										  <option value="liberian">Liberian</option>
										  <option value="libyan">Libyan</option>
										  <option value="liechtensteiner">Liechtensteiner</option>
										  <option value="lithuanian">Lithuanian</option>
										  <option value="luxembourger">Luxembourger</option>
										  <option value="macedonian">Macedonian</option>
										  <option value="malagasy">Malagasy</option>
										  <option value="malawian">Malawian</option>
										  <option value="malaysian">Malaysian</option>
										  <option value="maldivan">Maldivan</option>
										  <option value="malian">Malian</option>
										  <option value="maltese">Maltese</option>
										  <option value="marshallese">Marshallese</option>
										  <option value="mauritanian">Mauritanian</option>
										  <option value="mauritian">Mauritian</option>
										  <option value="mexican">Mexican</option>
										  <option value="micronesian">Micronesian</option>
										  <option value="moldovan">Moldovan</option>
										  <option value="monacan">Monacan</option>
										  <option value="mongolian">Mongolian</option>
										  <option value="moroccan">Moroccan</option>
										  <option value="mosotho">Mosotho</option>
										  <option value="motswana">Motswana</option>
										  <option value="mozambican">Mozambican</option>
										  <option value="namibian">Namibian</option>
										  <option value="nauruan">Nauruan</option>
										  <option value="nepalese">Nepalese</option>
										  <option value="new zealander">New Zealander</option>
										  <option value="ni-vanuatu">Ni-Vanuatu</option>
										  <option value="nicaraguan">Nicaraguan</option>
										  <option value="nigerien">Nigerien</option>
										  <option value="north korean">North Korean</option>
										  <option value="northern irish">Northern Irish</option>
										  <option value="norwegian">Norwegian</option>
										  <option value="omani">Omani</option>
										  <option value="pakistani">Pakistani</option>
										  <option value="palauan">Palauan</option>
										  <option value="panamanian">Panamanian</option>
										  <option value="papua new guinean">Papua New Guinean</option>
										  <option value="paraguayan">Paraguayan</option>
										  <option value="peruvian">Peruvian</option>
										  <option value="polish">Polish</option>
										  <option value="portuguese">Portuguese</option>
										  <option value="qatari">Qatari</option>
										  <option value="romanian">Romanian</option>
										  <option value="russian">Russian</option>
										  <option value="rwandan">Rwandan</option>
										  <option value="saint lucian">Saint Lucian</option>
										  <option value="salvadoran">Salvadoran</option>
										  <option value="samoan">Samoan</option>
										  <option value="san marinese">San Marinese</option>
										  <option value="sao tomean">Sao Tomean</option>
										  <option value="saudi">Saudi</option>
										  <option value="scottish">Scottish</option>
										  <option value="senegalese">Senegalese</option>
										  <option value="serbian">Serbian</option>
										  <option value="seychellois">Seychellois</option>
										  <option value="sierra leonean">Sierra Leonean</option>
										  <option value="singaporean">Singaporean</option>
										  <option value="slovakian">Slovakian</option>
										  <option value="slovenian">Slovenian</option>
										  <option value="solomon islander">Solomon Islander</option>
										  <option value="somali">Somali</option>
										  <option value="south african">South African</option>
										  <option value="south korean">South Korean</option>
										  <option value="spanish">Spanish</option>
										  <option value="sri lankan">Sri Lankan</option>
										  <option value="sudanese">Sudanese</option>
										  <option value="surinamer">Surinamer</option>
										  <option value="swazi">Swazi</option>
										  <option value="swedish">Swedish</option>
										  <option value="swiss">Swiss</option>
										  <option value="syrian">Syrian</option>
										  <option value="taiwanese">Taiwanese</option>
										  <option value="tajik">Tajik</option>
										  <option value="tanzanian">Tanzanian</option>
										  <option value="thai">Thai</option>
										  <option value="togolese">Togolese</option>
										  <option value="tongan">Tongan</option>
										  <option value="trinidadian or tobagonian">Trinidadian or Tobagonian</option>
										  <option value="tunisian">Tunisian</option>
										  <option value="turkish">Turkish</option>
										  <option value="tuvaluan">Tuvaluan</option>
										  <option value="ugandan">Ugandan</option>
										  <option value="ukrainian">Ukrainian</option>
										  <option value="uruguayan">Uruguayan</option>
										  <option value="uzbekistani">Uzbekistani</option>
										  <option value="venezuelan">Venezuelan</option>
										  <option value="vietnamese">Vietnamese</option>
										  <option value="welsh">Welsh</option>
										  <option value="yemenite">Yemenite</option>
										  <option value="zambian">Zambian</option>
										  <option value="zimbabwean">Zimbabwean</option>
										</select>
									</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-md-3">
										<label>Address:</label>
									</div>
									<div class="col-md-5">
										<s:textfield name="user_street" cssClass="form-control" required="required"/>
										<small class="form-text">Street<span class="required">*</span></small>

									</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-md-3">
									</div>
									<div class="col-md-5">
										<s:textfield name="user_apt" cssClass="form-control"/>
										<small class="form-text">Apt/Suite/Other</small>
									</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-md-3">
									</div>
									<div class="col-md-5">
										<s:textfield name="user_city" cssClass="form-control" required="required"/>
										<small class="form-text">City<span class="required">*</span></small>
									</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-md-3">
									</div>
									<div class="col-md-5">
										<s:textfield name="user_state" cssClass="form-control" required="required"/>
										<small class="form-text">State/Province/Region<span class="required">*</span></small>
									</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-md-3">
									</div>
									<div class="col-md-5">
										<s:textfield name="user_zip" cssClass="form-control" required="required"/>
										<small class="form-text">Zip/Postal Code<span class="required">*</span></small>

									</div>
								</div>
								
								<div class="form-row mb-3">
									<div class="col-lg-6 col-md-12 col-12">
										<label>Cellphone Number: <span class="required">*</span></label>
										<s:textfield name="user_cellphonenumber" cssClass="form-control" placeholder="ex. 0977 823892" required="required"/>
									</div>
									<div class="col-lg-6 col-md-12 col-12">
										<label>Telephone Number: <span class="required">*</span></label>
										<s:textfield name="user_telephonenumber" cssClass="form-control" placeholder="ex: 046 4897700, 8123 4567" required="required"/>
									</div>
								</div>
								<div class="form-row mb-3">
									<div class="col-xl col-md-12 col-12">
										<label>Occupation: <span class="required">*</span></label>
										<s:textfield name="user_occupation" cssClass="form-control" required="required"/>
									</div>
									<div class="col-xl col-md-12 col-12">
										<label>Company Name: <span class="required">*</span></label>
										<s:textfield name="user_company" cssClass="form-control" required="required"/>
									</div>
								</div>
								<s:submit value="Next" class="btn btn-primary btn-block btn-lg shadow-none text-uppercase w-25 mx-auto"/>
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