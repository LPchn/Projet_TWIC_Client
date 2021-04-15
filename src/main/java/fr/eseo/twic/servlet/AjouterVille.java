package fr.eseo.twic.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eseo.twic.api.VilleApi;
import fr.eseo.twic.api.VilleApiImpl;

@WebServlet("/AjouterVille")
public class AjouterVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AjouterVille() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VilleApi villeApi = new VilleApiImpl();
		try {
			villeApi.ajouterVille(request);
		}
		catch(Exception e) {
			request.setAttribute("erreur", "Erreur lors de l'ajout de la ville");
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajout.jsp").forward(request, response);
		}	
		response.sendRedirect("/Client/listeVilles");
	}

}
