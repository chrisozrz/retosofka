package datosdecarrera;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class carrertera {
	
	List<String> concursantesaCompetir = new ArrayList<String>();
	List<String> autosHabilitados = new ArrayList<String>();
	List<String> concursanteHabilitado = new ArrayList<String>();
	String[] arr1 = {"", "", "", "", "", "", ""};
	String[] arr2 = {"", "", "", "", "", "", ""};
	private int matriz[][]={{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0}};
	public String[][] clasificados;
	public boolean findecarrera = false;
	public int recorrido;
	public int numerodeldado;
	
	public static void main(String[] args){}

	public void inscribirConductor(String nombre, String conductor, int CantidadPilotos, concursante jugador, habilitados autoDisponible, String Piloto_Auto) {
	    if (CantidadPilotos < 7){
		    concursantesaCompetir.add(nombre);
		    autosHabilitados.add(conductor);
		    concursanteHabilitado.add(Piloto_Auto);
		    JOptionPane.showMessageDialog(null, nombre + " se ha registrado exitosamente para la carrera, OK para continuar");
	    } else {
	        JOptionPane.showMessageDialog(null, "Se han registrado todos los pilotos para la carrera, Start para dar inicio");
	    }
	    guardarpilotocarro(jugador);
	    guardarautoasignado(autoDisponible);
	}
	
	public void guardarpilotocarro(concursante Concursante){
		for (int i = 0; i < concursantesaCompetir.size(); i++) 
		{
			arr1[i] = concursantesaCompetir.get(i);
		}
		Concursante.setPilotos(arr1);
	}
	
	public void guardarautoasignado(habilitados Habilitados){
        for (int i = 0; i < autosHabilitados.size(); i++) {
        	arr2[i] = autosHabilitados.get(i);
        }
        Habilitados.setAutos(arr2);
	}
	
	public int avanzar(int Auto, dado Dados){
        numerodeldado = Dados.Lanzar(1, 6);
        recorrido = Auto + numerodeldado * 100;
        return recorrido;
    }
    
    public void listaCompCarros(modelosautos autos, dado Dados){
        for (int i = 0; i < 7; i++){
			for(int j = 0; j < 2; j++){
				if(j==1){
					switch(matriz[i][0]){
						case 1 -> matriz[i][j] = autos.getTesla();
						case 2 -> matriz[i][j] = autos.getbugatti();
						case 3 -> matriz[i][j] = autos.getporsche();
						case 4 -> matriz[i][j] = autos.getrimac();
						case 5 -> matriz[i][j] = autos.getpagani();
						case 6 -> matriz[i][j] = autos.getlotus();
						case 7 -> matriz[i][j] = autos.getmercedes_benz();
					}
				}
			}
        }
        organizar(Dados);
    }
    
    private void organizar(dado dados){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 2; j++){
                for(int q = 0; q < 3; q++){
                    if (matriz[q][1] < matriz[q + 1][1]){
                        int tmpc1 = matriz[q + 1][1];
                        int tmpc0 = matriz[q + 1][0];
                        matriz[q+1][1] = matriz[q][1];
                        matriz[q+1][0] = matriz[q][0];
                        matriz[q][1] = tmpc1;
                        matriz[q][0] = tmpc0;
                    }
                }
            }
        }
        fijarcarros(dados);
    }
    
    public void fijarcarros(dado dados){
        String Matriztemp[][] = {{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""}};
        for (int i = 0; i < 7; i++){
        	for(int j = 0;  j < 2; j++){
        		if(j == 0){
        			switch(matriz[i][0]){
        			case 1 -> Matriztemp[i][j] = "TESLA";
        			case 2 -> Matriztemp[i][j] = "BUGATTI";
        			case 3 -> Matriztemp[i][j] = "PORSCHE";
        			case 4 -> Matriztemp[i][j] = "RIMAC";
        			case 5 -> Matriztemp[i][j] = "PAGANI";
        			case 6 -> Matriztemp[i][j] = "LOTUS";
        			case 7 -> Matriztemp[i][j] = "MERCEDES BENZ";
        		}
        	}
        	if(j == 1){
        		Matriztemp[i][j] = String.valueOf(matriz[i][j]);
        	}
   		}
   	}
        dados.setubicaciones(Matriztemp);
        cargarPrimerosLugares(dados);
    }
    
    public String[][] cargarPrimerosLugares(dado dados){
        if(matriz[2][1] > 5000){
        	clasificados = dados.getubicaciones();
        	findecarrera = true;
        }
        return clasificados;
    }
}
