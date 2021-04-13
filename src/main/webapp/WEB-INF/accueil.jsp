<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
</head>

<body>

	<%@ include file="bandeau.jsp"%>

	<div class="jumbotrom pt-5">
		<h1 class="text-center">Bienvenue sur l'annuaire des villes !</h1>
	</div>

	<form method="get" action="listeVilles">
		<div class="form-group row justify-content-center pt-5">
			<input class="btn btn-outline-primary btn-lg" style="width: 250px;"	type="submit" value="Liste des villes" />
		</div>
	</form>

	<form method="get" action="pagePrincipale">
		<div class="form-group row justify-content-center pt-3">
			<input class="btn btn-outline-primary btn-lg" style="width: 250px;"	type="submit" value="Distance entre deux villes" />
		</div>
	</form>
	
	<form method="get" action="ajouter">
		<div class="form-group row justify-content-center pt-3">
			<input class="btn btn-outline-primary btn-lg" style="width: 250px;"	type="submit" value="Ajouter une ville" />
		</div>
	</form>

</body>
</html>