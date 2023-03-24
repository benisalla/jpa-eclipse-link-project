<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>
	<body>
		<div class="container">
			<div class="card container" style="width: 44rem; margin:3rem auto;">
			
				<h1 class="text-center" style="margin: 1rem auto;">Add New Product</h1>
				
			
					<div style="display: flex;justify-content: flex-end;width:100%; margin: 1rem 0;">
					  <form action="index" method="get">
					   	<button type="submit" class="btn btn-outline btn-success">Back</button>   
					  </form>
			        </div>
			
				<form action="add" method="post">
				  <input type="hidden" name="id" value="0"/>
				  <div class="form-group row">
				    <label for="name" class="col-sm-2 col-form-label">Type</label>
				    <div class="col-sm-10">
				      <input value="" type="text" name="type" class="form-control" id="type" placeholder="your product type">
				    </div>
				  </div>
				  
				  <div class="form-group row">
				    <label for="email" class="col-sm-2 col-form-label">Price</label>
				    <div class="col-sm-10">
				      <input value="" type="text" name="price" class="form-control" id="price" placeholder="your product price">
				    </div>
				  </div>
				  
				  <div class="form-group row">
				    <label for="profession" class="col-sm-2 col-form-label">Amount</label>
				    <div class="col-sm-10">
				      <input value="" name="amount" type="text" class="form-control" id="amount" placeholder="your product amount">
				    </div>
				  </div>
				  
				  <div style="display: flex;justify-content: center;width:100%; margin: 1rem">
				   	<button type="submit" style="width: 100px;" class="btn btn-outline btn-danger">save</button>   
			      </div>
				  
				</form>
			
			</div>
				
		</div>
	</body>
</html>