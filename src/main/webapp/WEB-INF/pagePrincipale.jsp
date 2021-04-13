<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page principale</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<%@ include file="bandeau.jsp"%>
	<div class="jumbotrom pt-5">
		<h1 class="text-center">Distance entre deux villes</h1>
	</div>


	<form method="post" action="pagePrincipale">
	
		<div class="btn-toolbar justify-content-center pt-5" role="toolbar" aria-label="Toolbar with button groups">
	
			<div class="btn-group mr-5" role="group" style="margin-right:50px;"aria-label="Basic example">
				<select class="form-select form-select-lg" style="width: 200px;" name="ville1">
					<c:forEach items="${villes }" var="ville">
						<option>${ville.nom}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="btn-group" role="group" aria-label="Basic example">
				<select class="form-select form-select-lg" style="width: 200px;" name="ville2">
					<c:forEach items="${villes }" var="ville">
						<option>${ville.nom}</option>
					</c:forEach>
				</select>
			</div>
			
		</div>

		<div class="form-group row justify-content-center pt-5">
			<input class="btn btn-outline-primary btn-lg" style="width: 250px;"	type="submit" value="Valider" />
		</div>

	</form>

	<div class="text-center pt-5">
		<c:if test="${!empty distance }">
			<h4>La distance entre ${choixVille1 } et ${choixVille2 } est de : ${distance } kilomètres.</h4>
		</c:if>
	</div>
	
	<div class="text-center pt-5">
		
		<c:if test="${!empty erreur }">
			<h4 class="text-danger"><c:out value="${erreur }"/></h4>
		</c:if>	
	
	</div>

</body>
</html>