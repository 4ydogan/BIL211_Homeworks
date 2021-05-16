
public class Urun {
	
	int miktar, gramaj, kalite;
	double fiyat;
	String sktarihi;
	
	public Urun() {}
	
	public Urun(int miktar, int gramaj, double fiyat, int kalite, String sktarihi) {
		
		this.miktar = miktar;
		this.gramaj = gramaj;
		this.fiyat = fiyat;
		this.kalite = kalite;
		this.sktarihi = sktarihi;
	}
	
	public boolean sktGecmisMi(String bugun) {   // this method compares two date and return boolean.
												 // if return is true, product can not be bought.
		int result;
		int day1, month1, year1;
		int day2, month2, year2;
		String sktarihi = this.sktarihi; 
		
		year1 = Integer.parseInt(sktarihi.substring(sktarihi.lastIndexOf("/")+1));	// year of product expiration date
		sktarihi = sktarihi.substring(0,sktarihi.lastIndexOf("/"));
		month1 = Integer.parseInt(sktarihi.substring(sktarihi.lastIndexOf("/")+1)); // month of product expiration date
		sktarihi = sktarihi.substring(0,sktarihi.lastIndexOf("/"));
		day1 = Integer.parseInt(sktarihi.substring(sktarihi.lastIndexOf("/")+1));	// day of product expiration date
		
		year2 = Integer.parseInt(bugun.substring(bugun.lastIndexOf("/")+1));		// year of today
		bugun = bugun.substring(0,bugun.lastIndexOf("/"));
		month2 = Integer.parseInt(bugun.substring(bugun.lastIndexOf("/")+1));		// month of today
		bugun = bugun.substring(0,bugun.lastIndexOf("/"));
		day2 = Integer.parseInt(bugun.substring(bugun.lastIndexOf("/")+1));			// day of today
		
		result = (year1-year2)*365 + (month1-month2)*30 + (day1-day2);				// calculate how many days left
		
		if (result >= 0) {
			return false;
		}
		
		return true;
	}
}
