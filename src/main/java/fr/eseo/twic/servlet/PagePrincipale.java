package fr.eseo.twic.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eseo.twic.api.VilleApi;
import fr.eseo.twic.api.VilleApiImpl;
import fr.eseo.twic.operation.CalculDistance;
import fr.eseo.twic.operation.CalculDistanceException;

public class PagePrincipale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PagePrincipale() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VilleApi villes = new VilleApiImpl();
		request.setAttribute("villes", villes.listeVille());
			
		this.getServletContext().getRequestDispatcher("/WEB-INF/pagePrincipale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String choixVille1 = request.getParameter("ville1");
		String choixVille2 = request.getParameter("ville2");
		request.setAttribute("choixVille1", choixVille1);
		request.setAttribute("choixVille2", choixVille2);		
				
		CalculDistance calculDistance = new CalculDistance();
		
		try {
			
			//Il faut redonner la liste des villes dans le cas où l'utilisateur choisit deux mêmes villes
			VilleApi villes = new VilleApiImpl();
			request.setAttribute("villes", villes.listeVille());
			
			request.setAttribute("distance", calculDistance.calculDistance(request));
		}
		catch (CalculDistanceException e) {
			request.setAttribute("erreur", "Les villes séléctionnées sont les mêmes.");
		}		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pagePrincipale.jsp").forward(request, response);
	}
}