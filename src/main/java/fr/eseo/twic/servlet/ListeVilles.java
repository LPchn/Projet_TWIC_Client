package fr.eseo.twic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eseo.twic.api.VilleApi;
import fr.eseo.twic.api.VilleApiException;
import fr.eseo.twic.api.VilleApiImpl;
import fr.eseo.twic.modele.Ville;

/**
 * Servlet implementation class ListeVilles
 */
public class ListeVilles extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListeVilles() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VilleApi villeApi = new VilleApiImpl();
		List<Ville> listeVilles;
		try {
			listeVilles = villeApi.listeVille();
			request.setAttribute("listeVilles", listeVilles);	
		} catch (VilleApiException e) {			
			e.printStackTrace();
		}			
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/pageVille.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
