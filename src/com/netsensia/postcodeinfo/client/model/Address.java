package com.netsensia.postcodeinfo.client.model;

public class Address {

    private String uprn;
    
    private String organisationName;
    
    private String departmentName;

    private String poBoxNumber;
    
    private String buildingName;
    
    private String subBuildingName;
    
    private int buildingNumber = -1;
    
    private String thoroughfareName;
    
    private String dependentLocality;
    
    private String doubleDependentLocality;
    
    private String postTown;
    
    private String postcode;
    
    private String postcodeType;
    
    private String formattedAddress;
    
    private Point point;

	public String getUprn() {
		return uprn;
	}

	public void setUprn(String uprn) {
		this.uprn = uprn;
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPoBoxNumber() {
		return poBoxNumber;
	}

	public void setPoBoxNumber(String poBoxNumber) {
		this.poBoxNumber = poBoxNumber;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getSubBuildingName() {
		return subBuildingName;
	}

	public void setSubBuildingName(String subBuildingName) {
		this.subBuildingName = subBuildingName;
	}

	public int getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getThoroughfareName() {
		return thoroughfareName;
	}

	public void setThoroughfareName(String thoroughfareName) {
		this.thoroughfareName = thoroughfareName;
	}

	public String getDependentLocality() {
		return dependentLocality;
	}

	public void setDependentLocality(String dependentLocality) {
		this.dependentLocality = dependentLocality;
	}

	public String getDoubleDependentLocality() {
		return doubleDependentLocality;
	}

	public void setDoubleDependentLocality(String doubleDependentLocality) {
		this.doubleDependentLocality = doubleDependentLocality;
	}

	public String getPostTown() {
		return postTown;
	}

	public void setPostTown(String postTown) {
		this.postTown = postTown;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPostcodeType() {
		return postcodeType;
	}

	public void setPostcodeType(String postcodeType) {
		this.postcodeType = postcodeType;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
}
