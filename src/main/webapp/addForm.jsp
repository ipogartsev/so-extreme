<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Extreme activities database</title>
</head>
<body>

	<h1>Add new activity</h1>
	<form action="addActivity" method="post" enctype="multipart/form-data">
		<div>
			<label for="name">Activity title</label>
			<input id="name" name="name" placeholder="max 100 characters" type="text" required>
		</div>
		<div>
			<label for="description">Description</label>
			<textarea id="description" name="description" placeholder="max 500 characters" rows="10" cols="50"></textarea>
		</div>
		<div>
			<label for="imageUrl">image URL</label>
			<input id="imageUrl" name="imageUrl" type="text">
		</div>
		<div>
			<label for="imageFile">Upload image</label>
			<input id="imageFile" name="imageFile" type="file">
		</div>
		<div>
			<label for="price">Price</label>
			<input id="price" name="price" type="number" min="50" value="50" required>
		</div>
		<div>
            <label for="simulator">Simulator</label>
	      	<input type="checkbox" id="simulator" name="simulator" checked>
	    </div>
		<div>
            <label for="accessible">Disabled person accessible</label>
	      	<input type="checkbox" id="accessible" name="accessible">
	    </div>
		<input type="submit"/>
	</form>
	
	
	
	<a href="/index.jsp">return</a>
	
	
</body>
</html>