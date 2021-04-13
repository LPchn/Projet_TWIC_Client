package fr.eseo.twic.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eseo.twic.api.VilleApi;
import fr.eseo.twic.api.VilleApiImpl;
import fr.eseo.twic.meteo.MeteoApi;
import fr.eseo.twic.meteo.MeteoApiImpl;
import fr.eseo.twic.modele.Meteo;
import fr.eseo.twic.modele.Ville;

/**
 * Servlet implementation class Test
 */
public class DetailsVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsVille() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		
		VilleApi villeApi = new VilleApiImpl();
		Ville ville = villeApi.getVille(code);
		request.setAttribute("ville", ville);
		
		MeteoApi meteoApi = new MeteoApiImpl();
		Meteo meteo = meteoApi.getMeteo(code);
		request.setAttribute("meteo", meteo);
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/detailsVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
