<%@page import="model.ExtremeActivity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<% ExtremeActivity activity = (ExtremeActivity) request.getAttribute("activity");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update activity</title>
</head>
<body>

	<h1>Update activity</h1>
	<form action="updateActivity" method="post">
		<div>
			<label for="activityId">Activity ID</label>
			<input id="activityId" name="activityId" value="<%= activity.getId() %>" type="text">
		</div>
		<div>
			<label for="name">Activity title</label>
			<input id="name" name="name" value="<%= activity.getName() %>" type="text">
		</div>
		<div>
			<label for="description">Description</label>
			<textarea id="description" name="description" rows="10" cols="50" ><%= activity.getDescription() %></textarea>
		</div>
		<%-- TODO implement file loading --%>
		<div>
			<label for="imageUrl">image URL</label>
			<input id="imageUrl" name="imageUrl" type="text" value="<%= activity.getImageUrl()%>">
		</div>
		<div>
			<label for="price">Price</label>
			<input id="price" name="price" type="text" value="<%= activity.getPrice()%>">
		</div>
		<div>
            <label for="simulator">Simulator</label>
	      	<input type="checkbox" id="simulator" name="simulator" <%if(activity.isSimulator()) out.print("checked");%>>
	    </div>
		<div>
            <label for="accessible">Disabled person accessible</label>
	      	<input type="checkbox" id="accessible" name="accessible" <%if(activity.isDisabledAccessible()) out.print("checked");%>>
	    </div>
		<input type="submit" value="Update activity"/>
	</form>
	

</body>
</html>