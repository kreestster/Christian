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
	private double[] diametriComuni ={25.0d, 26.0d, 28.0d, 30.0d} ;
	private double kgMalto;
	private double ltAcqua;
	private double litriFinali;
	private double boilOffRate;
	private double grainAbsorptionRate;
	
	private static final double MIN_LITRI_PER_KG = 2.5;
	private static final double MAX_LITRI_PER_KG = 4.0;
	
	public Calculator() {
		this.setKgMalto(3.0);
		this.setLtAcqua(2.5);
		this.setLitriFinali(10.0d);
		this.setBoilOffRate(20.0);
		this.setGrainAbsorptionRate(1.0);
	}
	
	public static void main(String ...strings ) {
		
		Calculator calc = new Calculator();
		//dimensioni (interne) della pentola raggio e altezza
		double raggio = 15.0;
		double altezza = 30.0;
		
		double volume = calc.calcolaVolume(raggio, altezza);
		
		System.out.println("volume calcolato[pentola]: "+ volume/ 1000 +" lt");
		
		/*
		 * togliendo arbitrariamente una misura di 1/4 - 1/3 dell'altezza si ottiene un valore
		 * di sicurezza per il batch affinch√® non sbordi dalla pentola
		 * */
		volume = calc.calcolaVolumeSicurezza(raggio, altezza);
		System.out.println("volume sicurezza: "+ volume/ 1000 + " lt");
		System.out.println("con una distanza dal bordo di sicurezza pari a " + altezza * calc.getPercSpessoreSicurezza()  + " cm");
		
		//volume iniziale previsto per ottenere litri finali
		volume = calc.calcolaVolumeIniziale( calc.getLitriFinali());
		
		System.out.println("Per ottenere " + calc.getLitriFinali() + " litri di mosto Ë necessaria una pentola della capienza di " + String.format("%.2f",volume) + " litri.");

		System.out.println("\n\nCalcolo dimensioni pentola a partire dal batch size desiderato di " + String.format("%f", calc.getLitriFinali()));
		calc.calcolaDimensioniPentola(calc.getLitriFinali());
		
		
	}
	
	
	/**
	 * Calcola la capienza della pentola in litri a partire dal volume finale che si vuole ottenere
	 * considerando anche la percentuale di sicurezza
	 * 
	 * @param volumeFinale
	 * @return 
	 */
	private double calcolaVolumeIniziale(double volumeFinale) {
		double volumeIniziale = volumeFinale * 1000;
		volumeIniziale = (volumeIniziale + (volumeIniziale*this.percSpessoreSicurezza) ) / 1000;
		volumeIniziale = (volumeIniziale + this.getAbsorption());
		volumeIniziale +=volumeIniziale * (this.getBoilOffRate() /100);
		return volumeIniziale;
	}

	private double getAbsorption(){
		return this.getGrainAbsorptionRate() * this.getKgMalto();
	}
	
	public void calcolaDimensioniPentola(double batchSize) {
		for(double diametro:diametriComuni) {
			double height = (batchSize*1000) / (Math.pow((diametro/2), 2.0)* PI);
			double fullHeight = (height + (height*percSpessoreSicurezza));
			double securityHeight = height*percSpessoreSicurezza;
			
			System.out.println("base " + String.format("%.2f", diametro)+ " altezza " + fullHeight  
					+ " sicurezza calcolata " +  String.format("%.2f", securityHeight));
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

	public double getLitriFinali() {
		return litriFinali;
	}

	public void setLitriFinali(double litriFinali) {
		this.litriFinali = litriFinali;
	}

	public double getBoilOffRate() {
		return boilOffRate;
	}

	public void setBoilOffRate(double boilOffRate) {
		this.boilOffRate = boilOffRate;
	}

	public double getGrainAbsorptionRate() {
		return grainAbsorptionRate;
	}

	public void setGrainAbsorptionRate(double grainAbsorptionRate) {
		this.grainAbsorptionRate = grainAbsorptionRate;
	}
}
