<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
    <!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>ABC Cars </title>
  </head>
  <body> 
  
	<nav>
		<%@ include file="header.jsp" %>
	</nav>
	<section class="breadcrumbs" style="margin-top:75px">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Sell your car now!Register here</h2>
          <ol>
            <li><a href="/">Home</a></li>
            <li>Add cars</li>
          </ol>
        </div>

      </div>
    </section><!-- End About Us Section -->
    
	<div class="container" style="margin-top:20px;">
  <div class="card border-0 shadow my-5" >
    <div class="card-body p-5" >
      <p class="lead"><i class='fas fa-car' style='font-size:24px'></i>Add your car!</p>
    
    <div>
    <form:form action="mycar" name="myform" method="post" modelAttribute="addcar" onsubmit="return validateform()" enctype="multipart/form-data" >
  <div class="form-group" >
    <form:label for="carname" path="carname">Model</form:label>
    <form:input type="text" name="carname" class="form-control" path="carname" for="carname" aria-describedby="emailHelp" placeholder="Nexon" required="required"/>
  </div>
  <div class="form-group" >
    <form:label for="model" path="model">Brand</form:label>
    <form:input type="text" name="model" class="form-control" path="model" for="model" aria-describedby="emailHelp" placeholder="Tata" required="required" />
  </div>
  <div class="form-group">
    <form:label path="registration" for="registration">Year of registration</form:label>
    <form:input type="number" name="registration" path="registration" for="registration" class="form-control" placeholder="2019" required="required" />
  </div>
  <div class="form-group">
    <form:label path="color" for="color">Color</form:label>
    <form:input type="text" name="color" path="color" for="color" class="form-control" placeholder="Black" required="required" />
  </div>
  <div class="form-group">
    <form:label path="state" for="state">State</form:label>
    <form:input type="text" name="state" class="form-control" path="state" for="state" placeholder="Madhya Pradesh" required="required"/>
  </div>
  <div class="form-group">
    <form:label path="country" for="country">Country</form:label>
    <form:input type="text" name="country" class="form-control" path="country" for="country" placeholder="India" required="required"/>
  </div>
  <div class="form-group">
    <form:label path="price" for="price">Price(in Dollar)</form:label>
    <form:input type="text" name="price" class="form-control" path="price" for="price" placeholder="$70000/-" />
  </div>
  <div class="form-group">
    <label for="image">Add Picture</label>
    <input type="file" name="img" id="photo"
	accept="image/png, image/jpeg ,image/jpg" class="form-control" 
	placeholder="Browse"/>
  </div>
  <div class="form-group" >
    <form:label style="padding-right:10px;" for="userNew" path="userNew">Status</form:label>
    <form:radiobutton name="userNew" path="userNew" value="used" label="Used" style="padding-right:10px;"/>
    <form:radiobutton name="userNew" path="userNew" value="new" label="New" />
  </div>
  
  <form:button type="reset" class="btn btn-danger">Reset</form:button>
  <form:button type="submit" class="btn btn-success">Submit</form:button>
</form:form>
    </div>
    </div>
  </div>
</div>
	
	<nav>
		<%@ include file="footer.jsp" %>
	</nav>
<script>
		function validateform() {
			var name = document.myform.carname.value;
			var state = document.myform.state.value;
			var country = document.myform.country.value;
			var year = document.myform.registration.value;
			var gender = document.myform.gender.value;
			var price = document.myform.price.value;
			var brand = document.myform.model.value;

			if (name == "") {
				alert("Model Name is Mandatory");
				return false;
			}
			if (year == "") {
				alert("Manufacturing year is Mandatory");
				return false;
			}
			if (gender == "") {
				alert("Gender is Mandatory");
				return false;
			}

			if (state == "") {
				alert("state is Mandatory");
				return false;
			}
			if (country == "") {
				alert("country is Mandatory");
				return false;
			}

			if (price == "") {
				alert("Price is Mandatory");
				return false;
			}

			if (brand == "") {
				alert("brand is Mandatory");
				return false;
			}
		}
	</script>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>