package datosdecarrera;

public class modelosautos {
	
	private int tesla, bugatti, porsche, rimac, pagani, lotus, mercedes_benz;
	//"TESLA",""},{"BUGATTI",""},{"PORSCHE",""},{"RIMAC","",},{"PAGANI",""},{"LOTUS",""},{"MERCEDES BENZ",""}};
	
	public modelosautos() {
		
	}
	
	public int getTesla() {
		return tesla;
	}
	
	public void setTesla(int ntesla) {
		this.tesla = ntesla;
	}
	
	public int getbugatti() {
		return bugatti;
	}
	
	public void setbugatti(int nbugatti) {
		this.bugatti = nbugatti;
	}
	public int getporsche() {
		return porsche;
	}
	
	public void setporsche(int nporsche) {
		this.porsche = nporsche;
	}
	public int getrimac() {
		return rimac;
	}
	
	public void setrimac(int nrimac) {
		this.rimac = nrimac;
	}
	public int getpagani() {
		return pagani;
	}
	
	public void setpagani(int npagani) {
		this.pagani = npagani;
	}
	public int getlotus() {
		return lotus;
	}
	
	public void setlotus(int nlotus) {
		this.lotus = nlotus;
	}
	public int getmercedes_benz() {
		return mercedes_benz;
	}
	
	public void setmercedes_benz(int nmercedes_benz) {
		this.mercedes_benz = nmercedes_benz;
	}
	
	public void recorrer(carrertera Carretera, dado Dado, int turno) {
		switch (turno) {
		case 1: setTesla(Carretera.avanzar(getTesla(), Dado)); break;
		case 2: setbugatti(Carretera.avanzar(getbugatti(), Dado)); break;
		case 3: setporsche(Carretera.avanzar(getporsche(), Dado)); break;
		case 4: setrimac(Carretera.avanzar(getrimac(), Dado)); break;
		case 5: setpagani(Carretera.avanzar(getpagani(), Dado)); break;
		case 6: setlotus(Carretera.avanzar(getlotus(), Dado)); break;
		case 7: setmercedes_benz(Carretera.avanzar(getmercedes_benz(), Dado)); break;	
		}
	}
}
