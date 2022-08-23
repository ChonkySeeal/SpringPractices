package spring;

public class Country {
	String countryName;
	Capital capital;

	public Country(String countryName, Capital capital) {
		super();
		this.countryName = countryName;
		this.capital = capital;
	}

	public String getCountryName() {
		return countryName;
	}

	public Capital getCapital() {
		return capital;
	}
}
