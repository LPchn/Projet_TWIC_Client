<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<%@ include file="bandeau.jsp" %>
	<title>Liste des villes</title>
</head>
<body>	
	<div class="container text-center">
      <h1>Ville de france</h1>
      <div class="pt-5">
      <table class="table" class="display">
        <thead>
          <tr align="center">
            <th >Code commune</th>
            <th>Nom</th>
            <th>Code postal</th>
            <th>Libelle</th>
            <th>Ligne</th>
            <th>Latitude</th>
            <th>Longitude</th>
          </tr>
        </thead>
        
		<c:set var="nombreVille" scope="session" value="${ listeVilles.size() }"/>
		<c:set var="parPage" scope="session"  value="50"/>
		<c:set var="pageStart" value="${param.start}"/>
		
		<c:if test="${empty pageStart or pageStart < 0}">
	       <c:set var="pageStart" value="0"/>
		</c:if>
		<c:if test="${nombreVille < pageStart}">
	       <c:set var="pageStart" value="${pageStart - 50}"/>
		</c:if>                                             
	    <tbody>
		    <c:forEach var="ville" items="${listeVilles}" varStatus="status"
		                        begin="${pageStart}" end="${pageStart + parPage - 1}">
		    	<c:url value="http://localhost:8585/Client/details" var="url">
					<c:param name="code" value="${ ville.code }"/>
		        </c:url>
	          	<tr onclick="window.location.href='${url}'">
	          		<td align="center"><c:out value="${ ville.code }"/></td>
	          		<td align="center"><c:out value="${ ville.nom }" /></td>
	          		<td align="center"><c:out value="${ ville.codePostal }" /></td>
	          		<td align="center"><c:out value="${ ville.libelle }" /></td>
	          		<td align="center"><c:out value="${ ville.ligne }" /></td>
					<td align="center"><c:out value="${ ville.latitude }" /></td>
					<td align="center"><c:out value="${ ville.longitude }" /></td>
	          	</tr>
		   </c:forEach>
       </tbody>
      </table>
      </div>
	   
	   <ul class="pagination justify-content-center">
	   
		    <li class="page-item"><a class="page-link" href="?start=0">First page</a></li>
		    <li class="page-item"><a class="page-link" href="?start=${pageStart - 50}">Previous</a></li>
		    <a class="page-link" >Page ${Math.round((pageStart/50) + 1)} / ${Math.round((nombreVille/50) + 1)}</a>
		    <li class="page-item"><a class="page-link" href="?start=${pageStart + 50}">Next</a></li>
		    <li class="page-item"><a class="page-link" href="?start=${nombreVille - 1}">Last page</a></li>
  		</ul>
    </div>
	
     <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>