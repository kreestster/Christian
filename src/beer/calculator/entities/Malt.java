package beer.calculator.entities;

import java.io.Serializable;

public class Malt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6187470198067447518L;
	
	private String name;
	private Byte points;
	private MaltCategory category;
	private Double srm;
	private Double kgs;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return (int)points;
	}
	public void setPoints(Byte points) {
		this.points = points;
	}
	public void setPoints(int points) {
		this.points = new Byte((byte) points);
	}
	
	public MaltCategory getCategory() {
		return category;
	}
	public void setCategory(MaltCategory category) {
		this.category = category;
	}
	public Double getSrm() {
		return srm;
	}
	public void setSrm(Double srm) {
		this.srm = srm;
	}
	public Double getKgs() {
		return kgs;
	}
	public void setKgs(Double kgs) {
		this.kgs = kgs;
	}
	
	public static void main(String...strings) {
		Malt pils = new Malt();
		pils.setCategory(MaltCategory.BASE);
		pils.setName("Pils");
		pils.setPoints(30);
		pils.setSrm(1.0);
		Malt pale = new Malt();
		pale.setCategory(MaltCategory.BASE);
		pale.setName("Pale");
		pale.setPoints(29);
		
		
		Malt munich = new Malt();
		munich.setCategory(MaltCategory.SPECIAL);
		Malt vienna = new Malt();
		vienna.setCategory(MaltCategory.SPECIAL);
		
		Malt black = new Malt();
		black.setCategory(MaltCategory.VERYSPECIAL);
		
	}

}
