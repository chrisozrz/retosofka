package formularios;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import datosdecarrera.habilitados;
import datosdecarrera.carrertera;
import datosdecarrera.concursante;

public class inscripcion extends javax.swing.JFrame {
	
	carrertera Carretera = new carrertera();
	habilitados Habilitados = new habilitados();
	concursante Concursante = new concursante();
	String Concursante_Auto;
	
	int CantidadConcursantes = 0;

	private javax.swing.JLabel label_TituloFormulario = new javax.swing.JLabel();
	private javax.swing.JLabel label_IngresarNombre = new javax.swing.JLabel();
	private javax.swing.JTextArea text_IngresarNombre = new javax.swing.JTextArea();
	private javax.swing.JButton boton_AgregarConcursante = new javax.swing.JButton();
	private javax.swing.JLabel label_SeleccionarAuto = new javax.swing.JLabel();
	private javax.swing.JComboBox<String> lista_AutosDisponibles = new javax.swing.JComboBox<>();
	private javax.swing.JButton boton_Start = new javax.swing.JButton();
	
	public inscripcion() {
    	initComponents();
    	setSize(300, 300);
    	setLocationRelativeTo(null);
    }
	
    private void initComponents() {

    	label_TituloFormulario.setFont(new java.awt.Font("Calibri", 0, 20));
    	label_TituloFormulario.getSize();
    	label_TituloFormulario.setText("RETO SOFKA");
    	label_IngresarNombre.setText("NOMBRE DE PARTICIPANTE");
    	text_IngresarNombre.setText("");
    	label_SeleccionarAuto.setText("¿QUÉ SUPERAUTO QUIERES?");
    	label_SeleccionarAuto.setFont(new java.awt.Font("Calibri", 0, 14));
    	boton_AgregarConcursante.getPreferredSize();
    	boton_AgregarConcursante.setText("INSCRIBIR PARTICIPANTE");
    	boton_AgregarConcursante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	ListarTodos(evt);
            }
        });
    	lista_AutosDisponibles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Tesla", "Bugatti", "Porsche", "Rimac", "Pagani", "Lotus","Mercedes Benz" }));
    	boton_Start.setText("Start");
    	boton_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventoClickStart(evt);
            }
        });
    	JPanel panel = new JPanel();
    	panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    	panel.add(label_TituloFormulario);
    	panel.add(label_SeleccionarAuto);
    	panel.add(lista_AutosDisponibles);
    	panel.add(label_IngresarNombre);
    	panel.add(text_IngresarNombre);
    	panel.add(boton_AgregarConcursante);
    	panel.add(boton_Start);
    	getContentPane().add(panel);
    }
        
    public static void main(String args[]) {
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	java.awt.EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			new inscripcion().setVisible(true);
    			}
    		});
    	}
    
    private void ListarTodos(java.awt.event.ActionEvent evt) {
        CantidadConcursantes = CantidadConcursantes + 1;
        Concursante_Auto = text_IngresarNombre.getText() + " en " + lista_AutosDisponibles.getSelectedItem().toString();
        Carretera.inscribirConductor(text_IngresarNombre.getText(), lista_AutosDisponibles.getSelectedItem().toString(), CantidadConcursantes, Concursante, Habilitados, Concursante_Auto);
    }
    
    private void eventoClickStart(java.awt.event.ActionEvent evt) {    
    	competencia ventanacompentencia = new competencia();
    	ventanacompentencia.setVisible(true);
    	this.setVisible(false);
    }
}

