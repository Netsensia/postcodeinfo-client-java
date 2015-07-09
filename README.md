# postcodeinfo-client-java

Java API Client wrapper for [MoJ Postcode Info API](https://github.com/ministryofjustice/postcodeinfo)

# Installation

Add the JARs in the lib folder to your classpath.

# Usage

Authentication
--------------

You will need an *authentication token* (auth token). If you're using MOJ DS's
Postcode Info server, you can get a token by emailing
platforms@digital.justice.gov.uk with a brief summary of:

* who you are
* what project you're going to be using it on
* roughly how many lookups you expect to do per day

If you're running your own server, see
https://github.com/ministryofjustice/postcodeinfo#auth_tokens for instructions
on how to create a token.

Quick Start
-----------

	Client client = new Client(
		"API_KEY_HERE", 
		"https://postcodeinfo-staging.dsd.io"
	);
	
	Postcode pc = client.lookupPostcode("SW195AL");
		
	LocalAuthority localAuth = pc.getLocalAuthority();
	Point centrePoint = pc.getCentrePoint();
	ArrayList<Address> addresses = pc.getAddress();
	
	for (Address address : addresses) {
		address.getUprn();
        address.getThoroughfareName();
        address.getOrganisationName();
        address.getDepartmentName();
        address.getPoBoxNumber();
        address.getBuildingName();
        address.getSubBuildingName();
        address.getBuildingNumber();
        address.getDependentLocality();
        address.getDoubleDependentLocality();
        address.getPostTown();
        address.getPostcode();
        address.getPostcodeType();
        address.getFormattedAddress();
        
        Point point = address.getPoint();
        point.getLatitude();
        point.getLongitude();
	}	

Tests
-----

To run the JUnit tests, first copy the test/config.props.dist file to test/config.props and add your API key.
