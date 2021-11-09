
package webservices;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.9
 * 2021-11-07T14:12:53.896-03:00
 * Generated source version: 2.7.9
 * 
 */
public final class WSCuponeraController_WSCuponeraControllerPort_Client {

    private static final QName SERVICE_NAME = new QName("http://webServices/", "WSCuponeraControllerService");

    private WSCuponeraController_WSCuponeraControllerPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WSCuponeraControllerService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        WSCuponeraControllerService ss = new WSCuponeraControllerService(wsdlURL, SERVICE_NAME);
        WSCuponeraController port = ss.getWSCuponeraControllerPort();  
        
        {
        System.out.println("Invoking seleccionarCuponera...");
        java.lang.String _seleccionarCuponera_arg0 = "_seleccionarCuponera_arg0-1301053679";
        try {
            webservices.DtCuponeraWS _seleccionarCuponera__return = port.seleccionarCuponera(_seleccionarCuponera_arg0);
            System.out.println("seleccionarCuponera.result=" + _seleccionarCuponera__return);

        } catch (NoExisteCuponeraException_Exception e) { 
            System.out.println("Expected exception: NoExisteCuponeraException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getNombreCuponeras...");
        net.java.dev.jaxb.array.StringArray _getNombreCuponeras__return = port.getNombreCuponeras();
        System.out.println("getNombreCuponeras.result=" + _getNombreCuponeras__return);


        }
        {
        System.out.println("Invoking getNombreCuponerasSinRecibos...");
        net.java.dev.jaxb.array.StringArray _getNombreCuponerasSinRecibos__return = port.getNombreCuponerasSinRecibos();
        System.out.println("getNombreCuponerasSinRecibos.result=" + _getNombreCuponerasSinRecibos__return);


        }

        System.exit(0);
    }

}
