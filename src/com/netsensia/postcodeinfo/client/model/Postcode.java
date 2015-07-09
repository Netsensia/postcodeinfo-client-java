package com.netsensia.postcodeinfo.client.model;

import java.util.ArrayList;

public class Postcode {

    private boolean isValid;
    
    private Point centrePoint;

	private LocalAuthority localAuthority;
    
    private ArrayList<Address> addresses = new ArrayList<Address>();
    
    public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Point getCentrePoint() {
		return centrePoint;
	}

	public void setCentrePoint(Point centrePoint) {
		this.centrePoint = centrePoint;
	}

	public LocalAuthority getLocalAuthority() {
		return localAuthority;
	}

	public void setLocalAuthority(LocalAuthority localAuthority) {
		this.localAuthority = localAuthority;
	}

	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<Address> addresses) {
		this.addresses = addresses;
	}
	
	public void addAddress(Address address) {
		addresses.add(address);
	}

}
