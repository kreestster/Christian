package beer.calculator.entities;

public enum MaltCategory {
	BASE(1, true, true),
	SPECIAL(2, true, false),
	VERYSPECIAL(3, false, false);

	private int numericCat;
	private boolean enoughEnzyme;
	private boolean excessEnzyme;
	
	MaltCategory(int i, boolean enoughEnzyme, boolean excessEnzyme){
		this.numericCat = i;
		this.enoughEnzyme = enoughEnzyme;
		this.excessEnzyme = excessEnzyme;
		
	}
}
