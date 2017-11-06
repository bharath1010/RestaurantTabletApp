package com.falconnect.buffetbee.Adapter;

public class CountryModel {

	private String country_name;
	private String country_code;

	public CountryModel(String country_name, String country_code) {
		this.country_name = country_name;
		this.country_code = country_code;
	}
	public CountryModel() {
	}

	public String getcountry_name() {
		return country_name;
	}

	public String getcountry_code() {
		return country_code;
	}

}
