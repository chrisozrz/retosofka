package datosdecarrera;

import java.util.Random;

public class dado  {
	private String ubicaciones[][] = {{"TESLA",""},{"BUGATTI",""},{"PORSCHE",""},{"RIMAC","",},{"PAGANI",""},{"LOTUS",""},{"MERCEDES BENZ",""}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	}
	
	public int Lanzar(int limiteInferior, int limiteSuperior) {
		return (int) (Math.random() * limiteSuperior - 1) + limiteInferior;
	}
    
    public String[][] getubicaciones() {
        return ubicaciones;
    }

    public void setubicaciones(String[][] ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
}

