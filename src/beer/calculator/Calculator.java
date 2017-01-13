package beer.calculator;

import static java.lang.Math.PI;
/**
 * Esegue centralmente tutti i calcoli relativi alla produzione
 * 
 * @author Christian
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
		
		
	}
	
	
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
