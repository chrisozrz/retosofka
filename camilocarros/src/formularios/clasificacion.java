package formularios;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;
import datosdecarrera.carrertera;
public class clasificacion extends javax.swing.JFrame {
	
	javax.swing.JLabel text_Campeon = new javax.swing.JLabel();
	javax.swing.JLabel text_SubCampeon= new javax.swing.JLabel();
	javax.swing.JLabel text_Tercero = new javax.swing.JLabel();
	javax.swing.JLabel text_Campeon1 = new javax.swing.JLabel();
	javax.swing.JLabel text_SubCampeon1= new javax.swing.JLabel();
	javax.swing.JLabel text_Tercero1 = new javax.swing.JLabel();
	javax.swing.JPanel panel_Pedestal = new javax.swing.JPanel();
	

    private clasificacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
    public clasificacion(carrertera  podio) {
        initComponents();
		text_Campeon.setText(podio.clasificados[0][0]);
    	text_SubCampeon.setText(podio.clasificados[1][0]);
    	text_Tercero.setText(podio.clasificados[2][0]);
        setSize(350, 150);
    	setLocationRelativeTo(null);
    	text_Campeon1.setText("Primer puesto: "); 
    	text_SubCampeon1.setText("Segundo puesto: ");
    	text_Tercero1.setText("Tercer puesto: ");
    	
    }
    
    public void initComponents() {
    	text_Campeon1.setFont(new java.awt.Font("Calibri", 1, 14));
    	text_SubCampeon1.setFont(new java.awt.Font("Calibri", 1, 14));
    	text_Tercero1.setFont(new java.awt.Font("Calibri", 1, 14));
    	text_Campeon.setFont(new java.awt.Font("Calibri", 0, 14));
    	text_SubCampeon.setFont(new java.awt.Font("Calibri", 0, 14));
    	text_Tercero.setFont(new java.awt.Font("Calibri", 0, 14));
    	JPanel panel = new JPanel(); 
    	panel.setLayout(new GridLayout(2, 3));
    	panel.add(text_Campeon1);
    	panel.add(text_SubCampeon1);
    	panel.add(text_Tercero1);
    	panel.add(text_Campeon);
    	panel.add(text_SubCampeon);
    	panel.add(text_Tercero);
    	getContentPane().add(panel);
 
    }

	public static void main(String[] args) {
	      try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(clasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(clasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(clasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(clasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }

	      
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new clasificacion().setVisible(true);
	            }
	        });

	}
}
