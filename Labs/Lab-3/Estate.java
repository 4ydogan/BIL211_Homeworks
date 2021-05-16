
public class Estate {
	
	private String address ; 
	private int floor;
	private String facade;
	private int bedrooms;
	private int aream2;
	private int quality;
	
	public Estate() {} // default constructor
	
	public Estate(String address, int floor, String facade, int bedrooms, int aream2, int quality) {
		
		this.address = address;
		this.floor = floor;
		this.facade = facade;
		this.bedrooms = bedrooms;
		this.aream2 = aream2;
		this.quality = quality;
		
	}
	
	public int getPrice() { // later will be overriding
		return 0;
	}
	
	public String getAddress() { // *******getter methods****
		return this.address;
	}
	
	public int getFloor() {
		return this.floor;
	}
	
	public String getFacade() {
		return this.facade;
	}
	
	public int getBedrooms() {
		return this.bedrooms;
	}
	
	public int getAream2() {
		return this.aream2;
	}
	
	public int getQuality() {
		return this.quality;
	}
	
	public void setAddress(String newAddress) { // ********setter methods*******
		this.address = newAddress;
	}
	
	public void setFloor(int newFloor) {
		this.floor = newFloor;
	}
	
	public void setFacade(String newFacade) {
		this.facade = newFacade;
	}
	
	public void setBedrooms(int newBedrooms) {
		this.bedrooms = newBedrooms;
	}
	
	public void setAream2(int newAream2) {
		this.aream2 = newAream2;
	}
	
	public void setQuality(int newQuality) {
		this.quality = newQuality;
	}
	
	public int compareTo(Estate p, String s) { // compare price, quality, bedrooms and area
		
		if (s.equals("Price")){
			
			if(this.getPrice() > p.getPrice()) {
				return 1;
			}
			
			if(this.getPrice() == p.getPrice()) {
				return 0;
			}
			
			if(this.getPrice() < p.getPrice()) {
				return -1;
			}
		}
		
		if (s.equals("Quality")){
			
			if(this.getQuality() > p.getQuality()) {
				return 1;
			}
			
			if(this.getQuality() == p.getQuality()) {
				return 0;
			}
			
			if(this.getQuality() < p.getQuality()) {
				return -1;
			}
			
		}

		if (s.equals("Bedrooms")){
			
			if(this.getBedrooms() > p.getBedrooms()) {
				return 1;
			}
			
			if(this.getBedrooms() == p.getBedrooms()) {
				return 0;
			}
			
			if(this.getBedrooms() < p.getBedrooms()) {
				return -1;
			}
		}
		
		if (s.equals("Area")){
			
			if(this.getAream2() > p.getAream2()) {
				return 1;
			}
			
			if(this.getAream2() == p.getAream2()) {
				return 0;
			}
			
			if(this.getAream2() < p.getAream2()) {
				return -1;
			}
			
		}
		
		return 0;
	}
	
	public String toString() { // method of toString
		
		String toStr = "";
		
		toStr += "Address: " + this.getAddress() + "\n";
		toStr += "Floor: " + this.getFloor() + "\n";
		toStr += "Facade: " + this.getFacade() + "\n";
		toStr += "Number of bedrooms: " + this.getBedrooms() + "\n";
		toStr += "Area in m2: " + this.getAream2() + "\n";
		toStr += "Quality: " + this.getQuality() + "\n";
		toStr += "Price: " + this.getPrice();
		
		return toStr;
		
	}
	
	public Estate copy() {  // creates a deep copy and returns
		
		Estate k = new Estate(this.address, this.floor, this.facade, this.bedrooms, this.aream2, this.quality);
		
		return k;
		
	}
}
