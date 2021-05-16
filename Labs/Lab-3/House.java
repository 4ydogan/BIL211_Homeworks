
public class House extends Estate{
	
	public House(String address, int floor, String facade, int bedrooms, int aream2, int quality) {
		
		this.setAddress(address);
		this.setFloor(floor);
		this.setFacade(facade);
		this.setBedrooms(bedrooms);
		this.setAream2(aream2);
		this.setQuality(quality);
	}
	
	public int getPrice() {
		
		int price = 0;
		
		price += 150000;
		price += this.getFloor() * 100000;
		price += this.getBedrooms() * 65000;
		price += (this.getAream2() / 5) * 3000;
		price += this.getQuality() * 110000;		
		
		return price;
	}
	
	public String toString() {  // method of toString
		
		String toStr = "";
		
		toStr += "Address: " + this.getAddress() + "\n";
		toStr += "Number of floors: " + this.getFloor() + "\n";
		toStr += "Facade: " + this.getFacade() + "\n";
		toStr += "Number of bedrooms: " + this.getBedrooms() + "\n";
		toStr += "Area in m2: " + this.getAream2() + "\n";
		toStr += "Quality: " + this.getQuality() + "\n";
		toStr += "Price: " + this.getPrice();
		
		return toStr;
	}
	
	public House copy() {  // creates a deep copy and returns
		
		House k = new House(this.getAddress(), this.getFloor(), this.getFacade(), this.getBedrooms(), this.getAream2(), this.getQuality());
		
		return k;	
	}
}
