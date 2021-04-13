<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter une ville</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
</head>

<body>

	<%@ include file="bandeau.jsp"%>
	
	<div class="jumbotrom pt-2">
		<h1 class="text-center">Ajouter une ville</h1>
	</div>
	
	<form method="post" action="ajouter">
	
		<div class="pt-5">
			<input type="text" class="form-control form-control-lg m-auto" name="code" placeHolder="Code INSEE" style="width:300px;" required/>
		</div>
		
		<div class="pt-2">
			<input type="text" class="form-control form-control-lg m-auto" name="nom" placeHolder="Nom" style="width:300px;" required/>
		</div>
		
		<div class="pt-2">
			<input type="text" class="form-control form-control-lg m-auto" name="codePostal" placeHolder="Code postal" style="width:300px;" required/>
		</div>
		
		<div class="pt-2">
			<input type="text" class="form-control form-control-lg m-auto" name="libelle" placeHolder="Libelle" style="width:300px;" required/>
		</div>
		
		<div class="pt-2">
			<input type="text" class="form-control form-control-lg m-auto" name="ligne" placeHolder="Ligne" style="width:300px;" required/>
		</div>
		
		<div class="pt-2">
			<input type="text" class="form-control form-control-lg m-auto" name="latitude" placeHolder="Latitude" style="width:300px;" required/>
		</div>
		
		<div class="pt-2">
			<input type="text" class="form-control form-control-lg m-auto" name="longitude" placeHolder="Longitude" style="width:300px;" requiredgit pull/>
		</div>
		
		<div class="pt-5 row justify-content-center">
			<input type="submit" class="btn btn-outline-primary btn-lg" style="width: 250px;" value="Valider"/>
		</div>	
	
	</form>
	
	<div class="center pt-5">
		<c:if test="${!empty erreur }"><h4 class="text-danger"><c:out value="${erreur }"/></h4></c:if>	
	</div>	

</body>
</html>