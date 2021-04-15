package fr.eseo.twic.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eseo.twic.api.VilleApi;
import fr.eseo.twic.api.VilleApiImpl;
import fr.eseo.twic.modele.Ville;

@WebServlet("/ModifierVille")
public class ModifierVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModifierVille() {
        super();        
    }

	/*
	 * Not use in this project.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VilleApi villeApi = new VilleApiImpl();
		Ville ville = new Ville();
		ville.setCodePostal(request.getParameter("codePostal"));
		ville.setNom(request.getParameter("nom"));
		ville.setLatitude(request.getParameter("latitude"));
		ville.setLongitude(request.getParameter("longitude"));
		ville.setLibelle(request.getParameter("libelle"));
		ville.setLigne(request.getParameter("ligne"));
		
		try {
			villeApi.modifierVille(request.getParameter("code"), ville);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/Client/details?code=" + request.getParameter("code"));
	}

}
