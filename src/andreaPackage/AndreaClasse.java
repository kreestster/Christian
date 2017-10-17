package andreaPackage;

public class AndreaClasse {
 Integer peso;
 Integer altezza;
	
	public AndreaClasse(int peso,int altezza) {
		this.peso=peso;
		this.altezza=altezza;
}
	
	public Integer incrementaAltezza(int altezza) {
		int num=altezza+1;
		return num;
	}

	
	public static void main(String [] args){
		
		AndreaClasse primostudente =new AndreaClasse(80,190);
		AndreaClasse secondostudente =new AndreaClasse(60,160);
		
		int altezza=100;
		System.out.println(altezza);
		int num=primostudente.incrementaAltezza(altezza);
		System.out.println(num + "altezza incrementata");
		
	}
	
}
                                                                         