package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import datatypes.DtActividadDeportiva;
import datatypes.DtFecha;
import datatypes.DtProfesorExt;
import datatypes.DtUsuarioExt;
import datatypes.TEstado;
import excepciones.ActividadDeportivaException;
import logica.IActividadDeportivaController;
import logica.LaFabrica;
import models.GestorWeb;

@MultipartConfig
@WebServlet ("/api/alta_ad")
public class AltaAD extends HttpServlet {
	private static IActividadDeportivaController IADC;
	private static final long serialVersionUID = 1L;
    public AltaAD() {
        super();
        IADC = LaFabrica.getInstance().obtenerIActDeportivaController();
    }
    protected void processRequest(HttpServletRequest r, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter stream = response.getWriter();
        DtProfesorExt p = (DtProfesorExt) Login.getUsuarioLogueado(r);
        Set<String> cats = new HashSet<>();
        for(String c: rp(r,"catAD").split("[,]")) {
        	cats.add(c);
        }
    	int duracion = Integer.parseInt(rp(r,"durAD").trim());
    	float costo = Float.parseFloat(rp(r,"costoAD").trim());
        DtActividadDeportiva datosAD = new DtActividadDeportiva(rp(r,"nombreAD"),rp(r,"descAD"),duracion,costo,
        		new DtFecha(),new HashSet<String>(),TEstado.ingresada,p.getNickname()); //cat    
        try {
	        if (IADC.ingresarDatosActividadDep(p.getNombreInstitucion(), datosAD)) {
	    		stream.println("OK");
	    		return;
			} else {
	    		stream.println("FAIL DATA_IN_USE");
	    		return;
	        }
        }catch(ActividadDeportivaException e) {
        	e.getMessage();
    		stream.println("FAIL DATA_IN_USE");
    		return;
        }catch(Exception e) {
		   e.printStackTrace();
		   stream.println("FAIL");
	   }
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
	}
	
	private String rp(HttpServletRequest request,String param) {
		return request.getParameter(param);
	}
}