/* Taller de Programacion - INCO/FING/UDELAR
 * Integrantes:
 *      Alexis Baladon (5.574.612-4) - alexis.baladon@fing.edu.uy
 *      Guillermo Toyos (5.139.879-9) - guillermo.toyos@fing.edu.uy
 *      Jorge Machado (4.876.616-9) - jorge.machado.ottonelli@fing.edu.uy
 *      Juan Jose Mangado (5.535.227-0) - juan.mangado@fing.edu.uy
 *      Mathias Ramilo (5.665.788-5) - mathias.ramilo@fing.edu.uy
 *      
 *      "Nihil novum sub sole"
 */

package presentacion;

import logica.LaFabrica;
import logica.IUsuarioController;
import logica.IActividadDeportivaController;
import logica.IDictadoClaseController;
import logica.IDeportivaController;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

public class Menu {
	
	private JFrame menuPrincipal;
	private JDesktopPane escritorio;
	private IUsuarioController IUC;
	private IActividadDeportivaController IADC;
	private IDeportivaController IDC;
	private IDictadoClaseController IDCC;
	
	// Declaracion de los JInternalFrames:
	private AltaUsuario altaUsuario;
	private AltaActividadDeportiva altaActDep;
	private AltaDictadoClase altaClase;
	private AltaInstitucionDeportiva altaIns;
	private CrearCuponera altaCup;
	private RegistroUsuarioClase regUsuClass;
	private ConsultaDictadoClase consultaClass;
	//private ConsultaActividadDeportiva consActDep;
	private ConsultaCuponeras consultaCup;
	private ConsultaUsuario consultaUsu;
	private ModificarDatosUsuario modificarUsu;
	private AgregarActividadDeportivaCuponera aggCup;
	//Run program!
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.menuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create main frame.
	public Menu() {
		iniciar();
		
		LaFabrica fabrica = LaFabrica.getInstance();
		IUC = fabrica.obtenerIUsuarioController();
		IADC = fabrica.obtenerIActDeportivaController();
		IDC = fabrica.obtenerIDeportivaController();
		IDCC = fabrica.obtenerIDictadoClaseController();	
		
		//Preinicializacion de JInternalFrames con visibilidad=false
		
		//AltaUsuario:
		altaUsuario = new AltaUsuario(IUC);
		altaUsuario.setLocation(462, 25);
		altaUsuario.setVisible(false);
		escritorio.add(altaUsuario);	
		
		//AltaActividadDeportiva
		altaActDep = new AltaActividadDeportiva(IADC);
		altaActDep.setLocation(20, 20);
		altaActDep.setSize(450, 500);
		altaActDep.setVisible(false);
		escritorio.add(altaActDep);

		// AltaDictadoClase:
		altaClase = new AltaDictadoClase(IDCC);
		altaClase.setLocation(10, 11);
		altaClase.setVisible(false);
		escritorio.add(altaClase);
		
		// AltaInstitucionDeporitva:
		altaIns = new AltaInstitucionDeportiva(IDC);
		altaIns.setBounds(212, 37, 354, 344);
		altaIns.setVisible(false);
		escritorio.add(altaIns);
		
		// RegistroUsuarioClase:
		regUsuClass = new RegistroUsuarioClase(IDCC);
		regUsuClass.setVisible(false);
		escritorio.add(regUsuClass);
		
		// ConsultaDictadoClase:
		consultaClass = new ConsultaDictadoClase(IDCC);
		consultaClass.setVisible(false);
		escritorio.add(consultaClass);

		// ConsultaActividadDeportiva
//		consActDep = new ConsultaActividadDeportiva(IADC);
//		consActDep.setVisible(false);
//		escritorio.add(consActDep);
		
		// ConsultaCuponeras:
		consultaCup = new ConsultaCuponeras(IDC);
		consultaCup.setBounds(200, 100, 400, 200);
		consultaCup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		consultaCup.setVisible(false);
		escritorio.add(consultaCup);
		
		//ConsultaUsuario
		consultaUsu = new ConsultaUsuario(IUC);
		consultaUsu.setVisible(false);
		escritorio.add(consultaUsu);
		
		//ModificarDatosUsuario
		modificarUsu = new ModificarDatosUsuario(IUC);
		modificarUsu.setVisible(false);
		escritorio.add(modificarUsu);
		
		altaCup = new CrearCuponera();
		altaCup.setVisible(false);
		escritorio.add(altaCup);
		
		aggCup = new AgregarActividadDeportivaCuponera();
		aggCup.setVisible(false);
		escritorio.add(aggCup);
		
	}
	
	private void iniciar() {
        // Se crea el Frame con las dimensiones indicadas:
		menuPrincipal = new JFrame();
		menuPrincipal.setTitle("ENTRENAMOS.UY");
		menuPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menuPrincipal.setBounds(180, 100, 1000, 800);
		menuPrincipal.setResizable(true);
		
		escritorio = new JDesktopPane();
		menuPrincipal.getContentPane().add(escritorio);
		
		// Crear la Barra del Menu:
		JMenuBar menuBar = new JMenuBar();
		menuPrincipal.setJMenuBar(menuBar);
		
		JMenu menuInicio = new JMenu("Inicio\r\n");
		menuBar.add(menuInicio);
		
		JMenuItem itemIrInicio = new JMenuItem("Ir a Inicio");
		menuInicio.add(itemIrInicio);

		JMenuItem itemPueba = new JMenuItem("Cargar Datos Prueba");
		menuInicio.add(itemPueba);
		itemPueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatosPrueba();
			}
		});
		
		JMenuItem itemSalir = new JMenuItem("Salir");
		menuInicio.add(itemSalir);
		itemSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal.dispose();
			}
		});
		JMenu menuRegistro = new JMenu("Registros");
		menuBar.add(menuRegistro);
		
		JMenu subMenuUsuario = new JMenu("Usuario");
		menuRegistro.add(subMenuUsuario);
		
		JMenuItem itemRegistrarUsuario = new JMenuItem("Alta Usuario");
		subMenuUsuario.add(itemRegistrarUsuario);
		itemRegistrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (altaUsuario.isVisible()) 
					altaUsuario.toFront();
				else {
					altaUsuario.clear();
					altaUsuario.setVisible(true);
				}
			}
		});		
		
		JMenu subMenuInstitucion = new JMenu("Institucion");
		menuRegistro.add(subMenuInstitucion);
		
		JMenuItem itemAltaInstitucion = new JMenuItem("Alta Institucion Deportiva");
		subMenuInstitucion.add(itemAltaInstitucion);
		itemAltaInstitucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (altaIns.isVisible()) 
					altaIns.toFront();
				else {
					altaIns.clear();
					altaIns.setVisible(true);
				}
			}
		});
		
		JMenu subMenuActDep = new JMenu("Actividad Deportiva");
		menuRegistro.add(subMenuActDep);
		
		JMenuItem itemAltaActividad = new JMenuItem("Alta Actividad Deportiva");
		subMenuActDep.add(itemAltaActividad);
		itemAltaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (altaActDep.isVisible()) 
					altaActDep.toFront();
				else {
					altaActDep.clear();
					//altaActDep.cargarInstituciones(); NO!
					altaActDep.setVisible(true);
				}
			}
		});		
		
		JMenu subMenuDictado = new JMenu("Dictado Clase");
		menuRegistro.add(subMenuDictado);
		
		JMenuItem itemAltaDictado = new JMenuItem("Alta de Dictado de Clase");
		itemAltaDictado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (altaClase.isVisible())
					altaClase.toFront();
				else {
					altaClase.clear();
					altaClase.setVisible(true);
				}
			}
		});
		subMenuDictado.add(itemAltaDictado);
		
		JMenuItem itemRegistroAClase = new JMenuItem("Registro de Usuario a Dictado de Clase");
		itemRegistroAClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (regUsuClass.isVisible())
					regUsuClass.toFront();
				else {
					regUsuClass.clear();
					regUsuClass.setVisible(true);
				}
			}
		});
		subMenuDictado.add(itemRegistroAClase);
		
		JMenu subMenuCuponera = new JMenu("Cuponera");
		menuRegistro.add(subMenuCuponera);

		JMenuItem itemCrearCuponera = new JMenuItem("Crear Cuponera");
		subMenuCuponera.add(itemCrearCuponera);
		itemCrearCuponera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (altaCup.isVisible()) 
					altaCup.toFront();
				else {
					altaCup.clear();
					altaCup.setVisible(true);
				}
			}
		});
		
		JMenuItem itemAgregarActividad = new JMenuItem("Agregar Actividad Deportiva");
		subMenuCuponera.add(itemAgregarActividad);
		itemAgregarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aggCup.isVisible()) 
					aggCup.toFront();
				else {
					aggCup.clear();
					aggCup.setVisible(true);
				}
			}
		});
		
		JMenu menuConsultas = new JMenu("Consultas");
		menuBar.add(menuConsultas);
		
		JMenuItem itemConsultaUsuario = new JMenuItem("Consulta Usuario");
		menuConsultas.add(itemConsultaUsuario);
		itemConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (consultaUsu.isVisible()) 
					consultaUsu.toFront();
				else {
					consultaUsu.clear();
					consultaUsu.setVisible(true);
				}
			}
		});
		JMenuItem itemConsultaActividad = new JMenuItem("Consulta Actividad Deportiva");
		menuConsultas.add(itemConsultaActividad);
//		itemConsultaActividad.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (consActDep.isVisible()) 
//					consActDep.toFront();
//				else {
//					consActDep.clear();
//					consActDep.cargarInstituciones();
//					consActDep.setVisible(true);
//				}
//			}
//		});
//		
		JMenuItem itemConsultaClase = new JMenuItem("Consulta de Dictado de Clase");
		menuConsultas.add(itemConsultaClase);
		itemConsultaClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (consultaClass.isVisible()) 
					consultaClass.toFront();
				else {
					consultaClass.clear();
					consultaClass.cargarInstitucion();
					consultaClass.setVisible(true);
				}
			}
		});
		
		JMenuItem itemConsultaCuponera = new JMenuItem("Consulta de Cuponeras");
		menuConsultas.add(itemConsultaCuponera);
		itemConsultaCuponera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (consultaCup.isVisible())
					consultaCup.toFront();
				else {
					// altaClase.limpiar() //no IMplementado aun.
					consultaCup.setVisible(true);
				}
			}
		});
		
		JMenu menuModificaciones = new JMenu("Modificaciones");
		menuBar.add(menuModificaciones);
		
		JMenuItem itemModUsuario = new JMenuItem("Modificar Datos Usuario");
		menuModificaciones.add(itemModUsuario);
		itemModUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modificarUsu.isVisible()) 
					modificarUsu.toFront();
				else {
					modificarUsu.clear();
					modificarUsu.setVisible(true);
				}
			}
		});
	}
	
	private void cargarDatosPrueba() {
		
		//ALTA INSTITUCIONES
		IDC.altaInstitucion("Instituto Natural", "Clases de gimnasia, aer�bica, spinning y yoga.","https://www.inatural.com");
		IDC.altaInstitucion("Fuerza Bruta", "Gimnasio especializado en el desarrollo de la musculatura.","https://www.musculos.com");
		//ALTA USUARIOS
		DtUsuario datosUser;
			//SOCIOS
			datosUser = new DtSocio("Emi71","Emiliano","Lucas","emi71@gmail.com", new DtFecha(31,12,1971,0,0,0));
			IUC.ingresarDatosUsuario(datosUser);
			
			//PROFESORES
			datosUser = new DtProfesor("viktor","vperez@fuerza.com","Victor","Perez", new DtFecha(1,1,1977,0,0,0),"Fuerza Bruta", "Victor es un apasionado de los m�sculos. Sus\r\n"
					+ "clases son organizadas en funci�n de distintos\r\n"
					+ "aparatos y pesas con el objetivo de desarrollar\r\n"
					+ "m�sculos\r\n"
					+ "","Victor naci� en Moscow en 1977. En el a�o\r\n"
							+ "2005 emigr� a Uruguay luego de quedar\r\n"
							+ "encantado con el pa�s en un viaje tur�stico","www.vikgym.com");
			IUC.ingresarDatosUsuario(datosUser);

		//ALTA ACTIVIDAD DEPORTIVA
        DtFecha fechaAlta = new DtFecha(7,6,2021,0,0,0);
        DtActividadDeportiva datosAD = new DtActividadDeportiva("Kickboxing","En busca del nuevo campe�n de boxeo.",100,980,fechaAlta);
        IADC.ingresarDatosActividadDep("Fuerza Bruta", datosAD);

        //ALTA CLASE
        DtFecha fechaClase= new DtFecha(15,10,2021,20,0,0);
        DtFecha fechaRegistro= new DtFecha(7,6,2021,0,0,0);
        DtClase datos = new DtClase("M�sculos para boxeo", "viktor","viktor",1, 5, "https://www.musculos.com/muscbox", fechaClase, fechaRegistro);
        IDCC.ingresarDatosClase("Fuerza Bruta", "Kickboxing", datos);
	}
}
