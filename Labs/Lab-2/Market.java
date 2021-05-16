public class Market {
	
	Urun[] urunListesi;
	
	public Market(Urun[] urunler) {
		urunListesi = urunler;
	}
	
	public float alisverisUcreti(AlisverisListesi liste) {  // this method calculates total price and returns
		double ucret = 0.0;
		
		Urun[] myList;
		myList = liste.liste;
		
		for(int i=0; i < myList.length; i++ ) {				// checks all products on the list
			if(alinabilirMi(myList[i]) == true) {			// if they can be bought
				double fiyat = ucretHesapla(myList[i]);		// the method calculates price and add to total price 
				ucret += fiyat;
			}
		}
		
		return (float) ucret;								// return total price
	}
	
	public String alinamayanlar(AlisverisListesi liste) {	// this method checks the products on the list
		
		Urun[] myList;
		myList = liste.liste;
		
		String alinamayanlarListesi = "";
			
		for(int i=0; i < myList.length; i++ ) {
			if(alinabilirMi(myList[i]) == false) {			// if product can be bought, product name will be added to string
				String alinamayan = myList[i].getClass() + "";
				alinamayanlarListesi +=	alinamayan.substring(alinamayan.lastIndexOf(" ")+1) + ", ";
			}
		}
		
		if (alinamayanlarListesi == "") {					// if the list that will be returned is null
			return "";			
		}

		return alinamayanlarListesi.substring(0, alinamayanlarListesi.length()-2);
	}
	
	public boolean alinabilirMi(Urun urun) {				// this method calculate amount of products 
															// if amount of product is enough, method will return true  
		int k = 0;
		
		for (int i = 0; i < urunListesi.length; i++) {		// this for block is to control that there is a product or not 
			if(urun.getClass() == urunListesi[i].getClass()) {
				if (urun.gramaj == urunListesi[i].gramaj) {					
					if(urunListesi[i].sktGecmisMi(urun.sktarihi) == false) {
						if (urunListesi[i].kalite <= urun.kalite) {
							k += urunListesi[i].miktar;
						}
					}
				}
			}
		}
		
		if (urun.miktar <= k) {
			return true;
		}
			
		return false;
	}
	
	public double ucretHesapla(Urun urun) {		     		 //	this method calculate the price of given product
		
		double fiyat = 0.0;
		int miktar = urun.miktar;
		int kalite = urun.kalite;
				
		while (kalite > 0 && miktar > 0) {
			for (int i = 0; i < urunListesi.length; i++) {
				if(urun.getClass() == urunListesi[i].getClass()) {
					if (urunListesi[i].kalite == kalite) {
						if (urun.gramaj == urunListesi[i].gramaj) {								
							if(urunListesi[i].sktGecmisMi(urun.sktarihi) == false) {
								int urunListesiMiktar = urunListesi[i].miktar;
								while(urunListesiMiktar > 0 && miktar > 0 ) {					
									urunListesiMiktar--;
									miktar--;
									fiyat += urunListesi[i].fiyat;
								}
							}
						}
					}
				}
			}
			kalite--;
		}
				
		return fiyat;
	}
}