
public class Apartment extends Estate{
	
	public Apartment(String address, int floor, String facade, int bedrooms, int aream2, int quality) {
		
		this.setAddress(address);
		this.setFloor(floor);
		this.setFacade(facade);
		this.setBedrooms(bedrooms);
		this.setAream2(aream2);
		this.setQuality(quality);
	}
	
	public int getPrice() {
		
		int price = 0;
		
		price += this.getFloor() * 30000;
		price += this.getBedrooms() * 35000;
		price += (this.getAream2() / 5) * 1000;
		price += this.getQuality() * 60000;
		
		if(this.getFacade().equals("South")) {
			price += 20000;
		}
		
		if(this.getFacade().equals("North")) {
			price += 20000;
		}
		
		if(this.getFacade().equals("West")) {
			price += 5000;
		}
		
		if(this.getFacade().equals("East")) {
			price += 5000;
		}
		
		return price;
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
	
	public Apartment copy() {  // creates a deep copy and returns
		
		Apartment k = new Apartment(this.getAddress(), this.getFloor(), this.getFacade(), this.getBedrooms(), this.getAream2(), this.getQuality());
		
		return k;
	}
}
