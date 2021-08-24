/* Taller de Programacion - INCO/FING/UDELAR
 * Integrantes:
 *      Alexis Baladon (5.574.612-4) - alexis.baladon@fing.edu.uy
 *      Guillermo Toyos (5.139.879-9) - guillermo.toyos@fing.edu.uy
 *      Jorge Machado (4.876.616-9) - jorge.machado.ottonelli@fing.edu.uy
 *      Juan Jose Mangado (5.535.227-0) - juan.mangado@fing.edu.uy
 *      Mathias Ramilo (5.665.788-5) - mathias.ramilo@fing.edu.uy
 */

package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Set;

import logica.IDictadoClaseController;

import datatypes.TReg;

@SuppressWarnings("serial")
public class RegistroUsuarioClase extends JInternalFrame {
	
	/* Controlador de Dictado de Clase para las acciones del JInternalFrame */
	private IDictadoClaseController controlClase;
	
	/* Componentes graficas */
	// JLabel:
	private JLabel lblSeleccionInstitucion;
	private JLabel lblSeleccionActividad;
	private JLabel lblSeleccionClase;
	private JLabel lblSeleccionSocio;
	private JLabel lblSeleccionTipo;
	
	// JComboBox:
	private JComboBox<String> boxInstitucion;
	private JComboBox<String> boxActividad;
	private JComboBox<String> boxClase;
	private JComboBox<String> boxSocio;
	private JComboBox<String> boxTipo;
	
	// JButton:
	private JButton btnAceptar;
    private JButton btnCancelar;
    
    /* Crear frame */
	public RegistroUsuarioClase(IDictadoClaseController idcc) {
		// Inicializa controlador Dictado de Clase:
		controlClase = idcc;
		
		// Propiedades del JInternalFrame:
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Registro de Usuario a Dictado de Clase");
		setBounds(10, 40, 410, 400);
		
		// GridLayout:
		GridBagLayout gridBagLayout = new GridBagLayout();
	    gridBagLayout.columnWidths = new int[] { 30, 60, 60, 30, 30, 10 };
	    gridBagLayout.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30 };
	    gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
	    gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
	    getContentPane().setLayout(gridBagLayout);
        
        // JLabels:
        lblSeleccionInstitucion = new JLabel("Seleccione Institucion:");
        lblSeleccionInstitucion.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_lblSeleccionInstitucion = new GridBagConstraints();
        gbc_lblSeleccionInstitucion.gridwidth = 2;
        gbc_lblSeleccionInstitucion.fill = GridBagConstraints.BOTH;
        gbc_lblSeleccionInstitucion.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionInstitucion.gridx = 1;
        gbc_lblSeleccionInstitucion.gridy = 0;
        getContentPane().add(lblSeleccionInstitucion, gbc_lblSeleccionInstitucion);
        
        lblSeleccionActividad = new JLabel("Seleccione Actividad Deportiva:");
        lblSeleccionActividad.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_lblSeleccionActividad = new GridBagConstraints();
        gbc_lblSeleccionActividad.gridwidth = 2;
        gbc_lblSeleccionActividad.fill = GridBagConstraints.BOTH;
        gbc_lblSeleccionActividad.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionActividad.gridx = 1;
        gbc_lblSeleccionActividad.gridy = 2;
        getContentPane().add(lblSeleccionActividad, gbc_lblSeleccionActividad);
        
        lblSeleccionClase = new JLabel("Seleccione Clase:");
        lblSeleccionClase.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_lblSeleccionClase = new GridBagConstraints();
        gbc_lblSeleccionClase.gridwidth = 2;
        gbc_lblSeleccionClase.fill = GridBagConstraints.BOTH;
        gbc_lblSeleccionClase.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionClase.gridx = 1;
        gbc_lblSeleccionClase.gridy = 4;
        getContentPane().add(lblSeleccionClase, gbc_lblSeleccionClase);
        
        lblSeleccionSocio = new JLabel("Seleccione Socio:");
        lblSeleccionSocio.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_lblSeleccionSocio = new GridBagConstraints();
        gbc_lblSeleccionSocio.gridwidth = 2;
        gbc_lblSeleccionSocio.fill = GridBagConstraints.BOTH;
        gbc_lblSeleccionSocio.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionSocio.gridx = 1;
        gbc_lblSeleccionSocio.gridy = 6;
        getContentPane().add(lblSeleccionSocio, gbc_lblSeleccionSocio);
        
        lblSeleccionTipo = new JLabel("Seleccione el Tipo de Registro:");
        lblSeleccionTipo.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_lblSeleccionTipo = new GridBagConstraints();
        gbc_lblSeleccionTipo.gridwidth = 2;
        gbc_lblSeleccionTipo.fill = GridBagConstraints.BOTH;
        gbc_lblSeleccionTipo.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionTipo.gridx = 1;
        gbc_lblSeleccionTipo.gridy = 8;
        getContentPane().add(lblSeleccionTipo, gbc_lblSeleccionTipo);
        
        // JComboBox:
        boxInstitucion = new JComboBox<>();
        boxInstitucion.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		int selectIndex = boxInstitucion.getSelectedIndex();
    			boxActividad.removeAllItems();
    			DefaultComboBoxModel<String> modelActividad = new DefaultComboBoxModel<>();
    			modelActividad.addElement("-");
    			if (selectIndex > 0) {
        			Set<String> actividades = controlClase.obtenerActividades(boxInstitucion.getItemAt(selectIndex));
                    for (String x: actividades) {
                    	modelActividad.addElement(x);
                    }
                    boxActividad.setEnabled(true);
        		} else {
        			boxActividad.setEnabled(false);
        		}
            	boxActividad.setModel(modelActividad);
        	}
        });
        GridBagConstraints gbc_boxInstitucion = new GridBagConstraints();
        gbc_boxInstitucion.gridwidth = 3;
        gbc_boxInstitucion.insets = new Insets(0, 0, 5, 5);
        gbc_boxInstitucion.fill = GridBagConstraints.HORIZONTAL;
        gbc_boxInstitucion.gridx = 1;
        gbc_boxInstitucion.gridy = 1;
        getContentPane().add(boxInstitucion, gbc_boxInstitucion);
        
        boxActividad = new JComboBox<>();
        boxActividad.setEnabled(false);
        boxActividad.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		int selectIndex = boxActividad.getSelectedIndex();
    			boxClase.removeAllItems();
    			DefaultComboBoxModel<String> modelClase = new DefaultComboBoxModel<>();
    			modelClase.addElement("-");
    			if (selectIndex > 0) {
        			Set<String> clases = controlClase.obtenerClases(boxInstitucion.getItemAt(boxInstitucion.getSelectedIndex()), 
        					boxActividad.getItemAt(selectIndex));
                    for (String x: clases) {
                    	modelClase.addElement(x);
                    }
                    boxClase.setEnabled(true);
        		} else {
        			boxClase.setEnabled(false);
        		}
    			boxClase.setModel(modelClase);
        	}
        });
        GridBagConstraints gbc_boxActividad = new GridBagConstraints();
        gbc_boxActividad.gridwidth = 3;
        gbc_boxActividad.insets = new Insets(0, 0, 5, 5);
        gbc_boxActividad.fill = GridBagConstraints.HORIZONTAL;
        gbc_boxActividad.gridx = 1;
        gbc_boxActividad.gridy = 3;
        getContentPane().add(boxActividad, gbc_boxActividad);
        
        boxClase = new JComboBox<>();
        GridBagConstraints gbc_boxClase = new GridBagConstraints();
        gbc_boxClase.gridwidth = 3;
        gbc_boxClase.insets = new Insets(0, 0, 5, 5);
        gbc_boxClase.fill = GridBagConstraints.HORIZONTAL;
        gbc_boxClase.gridx = 1;
        gbc_boxClase.gridy = 5;
        getContentPane().add(boxClase, gbc_boxClase);
        boxClase.setEnabled(false);
        
        boxSocio = new JComboBox<>();
        GridBagConstraints gbc_boxSocio = new GridBagConstraints();
        gbc_boxSocio.gridwidth = 3;
        gbc_boxSocio.insets = new Insets(0, 0, 5, 5);
        gbc_boxSocio.fill = GridBagConstraints.HORIZONTAL;
        gbc_boxSocio.gridx = 1;
        gbc_boxSocio.gridy = 7;
        getContentPane().add(boxSocio, gbc_boxSocio);
        
        boxTipo = new JComboBox<>();
        boxTipo.addItem("-");
        boxTipo.addItem("General");
        boxTipo.addItem("Cuponera");
        GridBagConstraints gbc_boxTipo = new GridBagConstraints();
        gbc_boxTipo.insets = new Insets(0, 0, 5, 5);
        gbc_boxTipo.fill = GridBagConstraints.HORIZONTAL;
        gbc_boxTipo.gridx = 1;
        gbc_boxTipo.gridy = 9;
        getContentPane().add(boxTipo, gbc_boxTipo);
        
        // JButton:
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	inscribirSocioClase(arg0);
            }
        });
        GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
        gbc_btnAceptar.fill = GridBagConstraints.BOTH;
        gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
        gbc_btnAceptar.gridx = 2;
        gbc_btnAceptar.gridy = 11;
        getContentPane().add(btnAceptar, gbc_btnAceptar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear();
                setVisible(false);
            }
        });    
        GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
        gbc_btnCancelar.gridwidth = 2;
        gbc_btnCancelar.fill = GridBagConstraints.BOTH;
        gbc_btnCancelar.gridx = 3;
        gbc_btnCancelar.gridy = 11;
        getContentPane().add(btnCancelar, gbc_btnCancelar);
	}
	
	// Metodo de invocacion de la Consulta de Clase
    protected void inscribirSocioClase(ActionEvent arg0) {
        if (checkDatos()) {
        	// Obtengo datos de los controles Swing:
            String nombreInstitucion = boxInstitucion.getItemAt(boxInstitucion.getSelectedIndex());
            String nombreActividad = boxActividad.getItemAt(boxActividad.getSelectedIndex());
            String nombreClase = boxClase.getItemAt(boxClase.getSelectedIndex());
            String nombreSocio = boxSocio.getItemAt(boxSocio.getSelectedIndex());
            int tipo = boxTipo.getSelectedIndex();
            TReg x = TReg.general;
            if (boxTipo.getItemAt(tipo) == "Cuponera")
            	x = TReg.cuponera;
            if (controlClase.inscribirSocio(nombreInstitucion, nombreActividad, nombreClase, nombreSocio, x) == 0) {
            	// Muestro éxito de la operación
                JOptionPane.showMessageDialog(this, "La inscripcion al Dictado de la Clase fue un exito", 
                		"Registro de Usuario a Dictado de Clase", JOptionPane.INFORMATION_MESSAGE);
                clear();
                setVisible(false);
            } else {
            	JOptionPane.showMessageDialog(this, "El Socio seleccionado no puede inscribirse a la Clase seleccionada.", 
            			"Registro de Usuario a Dictado de Clase", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
	
	// Realiza el checkeo de la entrada de datos.
    private boolean checkDatos() {
        int indexInstitucion = boxInstitucion.getSelectedIndex();
        int indexActividad = boxActividad.getSelectedIndex();
        int indexClase = boxClase.getSelectedIndex();
        int indexSocio = boxSocio.getSelectedIndex();
        int indexTipo = boxTipo.getSelectedIndex();
        if (indexInstitucion < 1 || indexActividad < 1 || indexClase < 1 || indexSocio < 1 || indexTipo < 1) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registro de Usuario a Dictado de Clase",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	// Cargar Datos al JComboBox
    // Se invoca el método antes de hacer visible el JInternalFrame
    public void cargarDatos() {
    	// Cargar Usuarios:
    	DefaultComboBoxModel<String> modelUsuario;
    	modelUsuario = new DefaultComboBoxModel<>();
    	modelUsuario.addElement("-");
        for(String x: controlClase.obtenerUsuarios()) {
        	modelUsuario.addElement(x);
        }
        boxSocio.setModel(modelUsuario);
    	// Cargar Instituciones:
        DefaultComboBoxModel<String> modelInstitucion;
        modelInstitucion = new DefaultComboBoxModel<>();
        modelInstitucion.addElement("-");
        for(String x: controlClase.obtenerInstituciones()) {
        	modelInstitucion.addElement(x);
        }
        boxInstitucion.setModel(modelInstitucion);
    }
	
	// Limpia el JInternalFrame
	public void clear() {
	    boxInstitucion.removeAllItems();
	    boxActividad.removeAllItems();
	    boxActividad.setEnabled(false);
	    boxClase.removeAllItems();
	    boxClase.setEnabled(false);
	    boxSocio.removeAllItems();
	    boxTipo.setSelectedIndex(0);
	}
}