package beer.calculator;

import static java.lang.Math.PI;
import beer.calculator.entities.Malt;
import beer.calculator.entities.MaltCategory;

import java.util.List;
import java.util.ArrayList;

/**
 * Esegue centralmente tutti i calcoli relativi alla produzione</br>
 * <h1>Calcolo OG Teorico</h1></br>
 * A partire dai tipi e le quantità di malto utilizzate nel batch
 * è possibile determinare la OG teorica.</br> 
 * Si prevede l'utilizzo di un catalogo per gli ingredienti comuni da cui 
 * creare le singole istanze necessarie per ogni ricetta.</br></br>
 * 
 * Si parte dal fatto che 1kg di zucchero purissimo disciolto in 10 lt di acqua 
 * farà ottenere una OG massima teorica di 1038. (tipicamente 1036).</br></br>
 * 
 * Ogni malto ha indicato un punteggio relativo a questo litraggio. (10 lt)</br></br>
 * 
 *  e.g. </br>
 *  single malt </br>
 *  Malto 1  = 25 pt </br>
 *  O.G. desiderata = 1040 (40pt) </br>
 *  Kg = OG/25pt = 1,6 kg</br></br>
 *  
 *  più malti</br>
 *  Malto 1 = 28 pt ( in base alla ricetta è possibile conoscere la percentuale di malti)</br>
 *  Malto 2 = 15 pt</br></br>
 *  
 *  O.G. desiderata 1040 (40pt)</br>
 *  Kg Malto 1 = 1,35 (38 pt)</br>
 *  Kg Malto 2 = 0,133 (2 pt)</br></br>
 *  
 * @author Christian
 *
 *	

	 */
public class Calculator {
	private double percSpessoreSicurezza = 0.33; 
	private double[] raggiComuni ={25.0d, 26.0d, 28.0d, 30.0d} ;
	private double kgMalto;
	private double ltAcqua;
	
	private static final double MIN_LITRI_PER_KG = 2.5;
	private static final double MAX_LITRI_PER_KG = 4.0;
	
	public Calculator() {
		this.setKgMalto(1.0);
		this.setLtAcqua(2.5);
	}
	
	public static void main(String ...strings ) {
		
		Calculator calc = new Calculator();
		//dimensioni (interne) della pentola raggio e altezza
		double raggio = 25.0;
		double altezza = 15.0;
		
		double volume = calc.calcolaVolume(raggio, altezza);
		
		System.out.println("volume calcolato: "+ volume/ 1000 +" lt");
		
		/*
		 * togliendo arbitrariamente una misura di 1/4 - 1/3 dell'altezza si ottiene un valore
		 * di sicurezza per il batch affinchè non sbordi dalla pentola
		 * */
		volume = calc.calcolaVolumeSicurezza(raggio, altezza);
		System.out.println("volume sicurezza: "+ volume/ 1000 + " lt");
		System.out.println("con una distanza dal bordo di sicurezza pari a " + calc.getPercSpessoreSicurezza());
		
		//volume finale che si vuole ottenere in litri
		double volumeFinale = 50.0;
		volume = calc.calcolaVolumePentola( volumeFinale);
		
		System.out.println("Per ottenere " + volumeFinale + " litri di mosto è necessaria una pentola della capienza di " + volume/1000 + " litri.");
		double batchSize = 23.0;
		System.out.println("\n\nCalcolo dimensioni pentola a partire dal batch size desiderato di " + batchSize);
		calc.calcolaDimensioniPentola(batchSize);
		
		Malt pils = new Malt(MaltCategory.BASE, Malt.PILS, 30, 1.0, 2 );
		Malt pale = new Malt(MaltCategory.BASE, Malt.PALE, 29, 1.0, 2 );
		
		Malt munich = new Malt(MaltCategory.SPECIAL, "Munich");
		Malt vienna = new Malt(MaltCategory.SPECIAL, "Vienna");
		Malt black = new Malt(MaltCategory.VERYSPECIAL, "Black", 4, 10.0,0.05);
		
		List<Malt> malts = new ArrayList<>();
		
		malts.add(pale);
		malts.add(black);
		int liters = 10;
		double finalOg = calc.calcolaOgTeorico(malts, liters);
		
		
		System.out.println("Final og teorico: 10" + (int)finalOg);
		finalOg = calc.calcolaOgEfficienza(malts, liters, 0.70);
		System.out.println("Final og efficienza: 10" + (int)finalOg);
	}
	
	public double calcolaVol(int og, int fg) {
		return (fg - og) /7.5;
	}
	public double calcolaOgTeorico(List<Malt> malts, int liters){
		double og =0.0;
		for(Malt malt:malts) {
			og += malt.getKgs() * malt.getPoints(); 
		}
		return og;
	}
	
	public double calcolaOgEfficienza(List<Malt> malts, int liters, double efficienza) {
		return efficienza * calcolaOgTeorico(malts, liters);
				
	}
	
	/**
	 * Calcolo OG teorico con efficienza
	 * 
	 * Normalmente gli impianti homebrewing hanno una efficienza che si aggira tra il 60% r 80%
	 * Per avere un dato Kg più corretto andrebbe moltiplicato per l'efficienza dell'impianto in uso.
	 * 
	 * Efficienza = OG x (lt/10) / (pt x Kg)
	 * 
	 */
	
	/**
	 * Calcola la capienza della pentola in litri a partire dal volume finale che si vuole ottenere
	 * considerando anche la percentuale di sicurezza
	 * 
	 * @param volumeFinale
	 * @return 
	 */
	private double calcolaVolumePentola(double volumeFinale) {
		double volumeFinale1 = volumeFinale * 1000;
		return volumeFinale1 + (volumeFinale1*this.percSpessoreSicurezza);
	}

	public void calcolaDimensioniPentola(double batchSize) {
		for(double raggio:raggiComuni) {
			double height = (batchSize*1000) / (Math.pow(raggio, 2.0)* PI);
			System.out.println("base " + raggio + " altezza " + (height + (height*percSpessoreSicurezza)) 
					+ " sicurezza calcolata " + height*percSpessoreSicurezza );
		}
	}

	public double calcolaVolume(double raggio, double altezza) {
		
		return Math.pow(raggio, 2.0)* PI * altezza;
	}
	
	public double calcolaVolumeSicurezza(double raggio, double altezza) {
		return Math.pow(raggio, 2.0)* PI * (altezza-(altezza*this.percSpessoreSicurezza));
	}
	
	public void setPercSpessoreSicurezza(double perc) {
		this.percSpessoreSicurezza = perc;
	}
	
	public double getPercSpessoreSicurezza() {
		return this.percSpessoreSicurezza;
	}

	public double getKgMalto() {
		return kgMalto;
	}

	public void setKgMalto(double kgMalto) {
		this.kgMalto = kgMalto;
	}

	public double getLtAcqua() {
		return ltAcqua;
	}

	public void setLtAcqua(double ltAcqua) {
		this.ltAcqua = ltAcqua;
	}
}
