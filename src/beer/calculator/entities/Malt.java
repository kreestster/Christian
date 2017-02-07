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
	
	public static final String PILS = "Pils";
	public static final String PALE = "Pale";
	public Malt(MaltCategory cat, String name) {
		this.setCategory(cat);
		this.setName(name);
	}
	
	public Malt(MaltCategory cat, String name, int points, double srm, double kgs) {
		this(cat, name);
		this.setPoints(points);
		this.setSrm(srm);
		this.setKgs(kgs);
		
	}
	
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
		Malt pils = new Malt(MaltCategory.BASE, PILS, 30, 1.0, 2 );
		Malt pale = new Malt(MaltCategory.BASE, PALE, 29, 1.0, 1 );
		
		Malt munich = new Malt(MaltCategory.SPECIAL, "Munich");
		Malt vienna = new Malt(MaltCategory.SPECIAL, "Vienna");
		Malt black = new Malt(MaltCategory.SPECIAL, "Black");
		
	}

}
