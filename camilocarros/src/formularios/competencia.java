package formularios;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

import datosdecarrera.carrertera;
import basededatos.almacenamientodatos;
import datosdecarrera.dado;
import datosdecarrera.modelosautos;

public class competencia extends javax.swing.JFrame {
	
	int nTurno = 1;
	almacenamientodatos basedatos = new almacenamientodatos();
	modelosautos Modelosautos = new modelosautos();
	carrertera Carrertera = new carrertera();
	dado dados = new dado();
	String Auto_Piloto = "";
	
	javax.swing.JLabel label_Titulo = new javax.swing.JLabel();
	javax.swing.JLabel label1 = new javax.swing.JLabel();
	javax.swing.JProgressBar carril_1 = new javax.swing.JProgressBar();
	javax.swing.JProgressBar carril_2 = new javax.swing.JProgressBar();
	javax.swing.JProgressBar carril_3 = new javax.swing.JProgressBar();
	javax.swing.JProgressBar carril_4= new javax.swing.JProgressBar();
	javax.swing.JProgressBar carril_5 = new javax.swing.JProgressBar();
	javax.swing.JProgressBar carril_6 = new javax.swing.JProgressBar();
	javax.swing.JProgressBar carril_7 = new javax.swing.JProgressBar();
	javax.swing.JButton boton_Dados = new javax.swing.JButton();
	javax.swing.JTable Tabla_Posiciones = new javax.swing.JTable();
	javax.swing.JScrollPane Ubicacion_Tabla = new javax.swing.JScrollPane();
	
	public competencia() {
        initComponents();
        setSize(500, 500);
    	setLocationRelativeTo(null);
    }

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new competencia().setVisible(true);
            }
        });
	}
	
	private void initComponents() {
	    
	    label_Titulo.setText("Grilla de partida");
	    label1.setText("----------------------------------------------------------------------------------------------------------------------");
	    propiedadesBar(carril_1, "1");
	    propiedadesBar(carril_2, "2");
		propiedadesBar(carril_3, "3");
		propiedadesBar(carril_4, "4");
		propiedadesBar(carril_5, "5");
		propiedadesBar(carril_6, "6");
		propiedadesBar(carril_7, "7");
		
	    Tabla_Posiciones.setModel(new javax.swing.table.DefaultTableModel(
	    		new Object [][] {
	    			{"1", null, null},
	    			{"2", null, null},
	    			{"3", null, null},
	    			{"4", null, null},
	    			{"5", null, null},
	    			{"6", null, null},
	    			{"7", null, null}
	    		},
	    		new String [] {
	    			"Clasificación", "Carros", "total desplazamiento"
	    		}
	    ){
	    	boolean[] canEdit = new boolean [] {
	    		false, true, true
	    	};
	    	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    		return canEdit [columnIndex];
	    	}
	    });
	    Ubicacion_Tabla.setViewportView(Tabla_Posiciones);
	    Ubicacion_Tabla.setPreferredSize(new Dimension(400, 130));
		boton_Dados.setText("Lanzador");
		boton_Dados.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            eventoClickLanzarDados(evt);
	        }
	    });	
		
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new BoxLayout(panelGeneral,BoxLayout.Y_AXIS)); 
    	
		panelGeneral.add(label_Titulo);
		panelGeneral.add(boton_Dados);
		panelGeneral.add(carril_1);
		panelGeneral.add(carril_2);
		panelGeneral.add(carril_3);
		panelGeneral.add(carril_4);
		panelGeneral.add(carril_5);
		panelGeneral.add(carril_6);
		panelGeneral.add(carril_7);
		panelGeneral.add(label1);
		panelGeneral.add(Ubicacion_Tabla);
    	getContentPane().add(panelGeneral);
	}
	
	private void propiedadesBar(JProgressBar carril, String textoCarril) {
		carril.setMaximum(5000);
		carril.setOrientation(0);
		carril.setStringPainted(true);
	}
	
	private void eventoClickLanzarDados(java.awt.event.ActionEvent evt) {
		switch(nTurno) {
			case 1 -> Auto_Piloto = "TESLA";
			case 2 -> Auto_Piloto = "BUGATTI";
			case 3 -> Auto_Piloto = "PORSCHE";
			case 4 -> Auto_Piloto = "RIMAC";
			case 5 -> Auto_Piloto = "PAGANI";
			case 6 -> Auto_Piloto = "LOTUS";
			case 7 -> Auto_Piloto = "MERCEDES_BENZ";
		}
		
		Modelosautos.recorrer(Carrertera, dados, nTurno);
		carril_1.setValue(Modelosautos.getTesla());
		carril_2.setValue(Modelosautos.getbugatti());
		carril_3.setValue(Modelosautos.getporsche());
		carril_4.setValue(Modelosautos.getrimac());
		carril_5.setValue(Modelosautos.getpagani());
		carril_6.setValue(Modelosautos.getlotus());
		carril_7.setValue(Modelosautos.getmercedes_benz());
		Carrertera.listaCompCarros(Modelosautos, dados);
		
		if(nTurno < 7) {
			nTurno = nTurno + 1;
		}
		else {
			nTurno = 1;
		}
		
		for(int i = 0; i < 7; i++){
			for (int j = 0; j < 2; j++){
				DefaultTableModel modelo =(DefaultTableModel)Tabla_Posiciones.getModel();
				modelo.setValueAt(dados.getubicaciones()[i][j], i, j + 1);
			}
		}
		
		if(Carrertera.findecarrera == true){
			clasificacion abrirclaisificacion = new clasificacion(Carrertera);
			abrirclaisificacion.setVisible(true);
			basedatos.insert(dados, Carrertera);
			this.setVisible(false);
		}
	}
}

