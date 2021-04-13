<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<%@ include file="bandeau.jsp" %>
	
	<title>${ ville.nom }</title>
</head>
<body>

    <div class="row justify-content-center">	
    <div class="row">
    <div class="card text-center" style="width: 18rem;">  	
  		<div class="card-body">
    		<h5 class="card-title"><c:out value="${ ville.nom }" /></h5>
    		<p class="card-text">Code commune : <c:out value="${ ville.code }"/></p>
    		<p class="card-text">Code postal : <c:out value="${ ville.codePostal }"/></p>
    		<p class="card-text">Libelle : <c:out value="${ ville.libelle }"/></p>
    		<c:if test="${!empty ville.ligne }">
    			<p class="card-text">Ligne 5 : <c:out value="${ ville.ligne }"/></p>
    		</c:if>
    		<p class="card-text">Latitude : <c:out value="${ ville.latitude }"/></p>
    		<p class="card-text">Longitude : <c:out value="${ ville.longitude }"/></p>
    		
      		<button data-toggle="modal" data-target="#formulaire" class="btn btn-primary">Modifier</button>
		    <div class="modal fade" id="formulaire">
		      <div class="modal-dialog">
		        <div class="modal-content">
		          <div class="modal-header">
		            <h4 class="modal-title text-center">Modifier la ville</h4>              
		            <button type="button" class="close" data-dismiss="modal">
		              <span>&times;</span>
		            </button>
		          </div>
		          <div class="modal-body row">
		            <form class="col"  method="POST" action="modifier?code=${ville.code}">
		              <div class="form-group">
		                <input type="text" class="form-control" name="nom" placeholder="Nom">
		              </div>
		              <div class="form-group">
		                <input type="text" class="form-control" name="codePostal" placeholder="Code postal">
		              </div>
		              <div class="form-group">
					  	<input type="text" class="form-control" name="libelle" placeholder="Libelle">
					  </div>
					  <div class="form-group">
					      <input type="text" class="form-control" name="ligne" placeholder="Ligne 5">
					  </div>
					  <div class="form-group">
					      <input type="text" class="form-control" name="latitude" placeholder="Latitude">
					  </div>
					  <div class="form-group">
					      <input type="text" class="form-control" name="longitude" placeholder="Longitude">
					  </div>
		              <button type="submit" class="btn btn-primary pull-right">Enregistrer</button>
		            </form>
		          </div>
		        </div>
		      </div>
		    </div>
			<a href="http://localhost:8080/Client/supprimer?code=${ville.code}" class="btn btn-primary">Supprimer</a>
		</div>
  		</div>
	</div>
	</div>

	

	<div class="row justify-content-center pt-5">	
		<div class="card text-center" style="width:500px;">
			<div class="card-body">
				<h5 class="card-title"><c:out value="Météo"/></h5>
				<p class="card-text">Température min : <c:out value="${ meteo.temperatureMin }"/>°C</p>
				<p class="card-text">Température max : <c:out value="${ meteo.temperatureMax }"/>°C</p>
				<p class="card-text"> Vent : <c:out value="${ meteo.vent }"/> km/h</p>
				<p class="card-text">Pluie : <c:out value="${ meteo.pluie }"/> mm</p>
				<p class="card-text">Probabilite pluie : <c:out value="${ meteo.probabilitePluie }"/> %</p>
			</div>	
		</div>
	</div> 

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>