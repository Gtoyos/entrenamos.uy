package servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.ClaseException;
import logica.LaFabrica;
import tools.Parametrizer;
import logica.ICuponeraController;
import excepciones.NoExisteCuponeraException;
import datatypes.DtCuponera;

@WebServlet("/cuponeras")
public class Cuponeras extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ICuponeraController ICC;
	
    public Cuponeras() {
    	super();
    	ICC = LaFabrica.getInstance().obtenerICuponeraController();
    }

    protected void processRequest(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, IOException {
    	Parametrizer.loadStdRequests(request);
    	String cuponera = request.getParameter("cuponera");
    	DtCuponera DatosCup = null;
    	try {
    		DatosCup = ICC.seleccionarCuponera(cuponera);
		} catch(NoExisteCuponeraException ex) {
			request.setAttribute("cuponera", null);
			response.sendRedirect(request.getContextPath()+"/pages/404.jsp");
		}
    	if(DatosCup != null) {
        	request.getSession().setAttribute("cuponera", DatosCup);
        	request.getRequestDispatcher("/pages/cuponeras.jsp").forward(request, response);
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
