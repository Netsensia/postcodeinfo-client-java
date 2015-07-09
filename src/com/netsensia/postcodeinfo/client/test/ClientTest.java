package com.netsensia.postcodeinfo.client.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.netsensia.postcodeinfo.client.Client;

public class ClientTest {
	
	private Client client;
	
	@Before
    public void setup() {
		Properties properties = new Properties();
		FileReader reader;
		try {
			reader = new FileReader("test/config.props");
			properties.load(reader);

			client = new Client(properties.getProperty("api_key"), properties.getProperty("endpoint"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
  	    catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @Test
	public void test_know_if_the_postcode_is_valid() throws IOException
    {
        assertTrue(client.lookupPostcode("SW195AL").isValid());
    }
    
    @Test
	public void test_know_if_the_postcode_is_not_valid() throws IOException
    {
    	assertFalse(client.lookupPostcode("MADEUP").isValid());
    }
    
    @Test
	public void test_get_the_postcode_centrepoint_type() throws IOException
    {
        assertTrue(client.lookupPostcode("AB124YA").getCentrePoint().getType().equals("Point"));
    }
    
    @Test
	public void test_get_the_postcode_centrepoint_latitude() throws IOException
    {
        assertTrue(client.lookupPostcode("AB124YA").getCentrePoint().getLatitude() == -2.148964422536167);
    }
    
    @Test
	public void test_get_the_postcode_centrepoint_longitude() throws IOException
    {
        
        assertTrue(client.lookupPostcode("AB124YA").getCentrePoint().getLongitude() == 57.06892522314932);
    }
    
    @Test
	public void test_get_the_local_authority_gss_code() throws IOException
    {
        assertTrue(client.lookupPostcode("sw1y4jh").getLocalAuthority().getGssCode().equals("E09000033"));
    }
    
    @Test
	public void test_get_the_local_authority_name() throws IOException
    {
        assertTrue(client.lookupPostcode("sw1y4 jh").getLocalAuthority().getName().equals("Westminster"));
    }
    
    @Test
	public void test_get_the_local_authority_gss_code_when_no_local_auth_is_reported() throws IOException
    {
    	assertTrue(client.lookupPostcode("AB124YA").getLocalAuthority() == null);
    }
    
    @Test
	public void test_get_the_uprn() throws IOException
    {
        assertTrue(client.lookupPostcode("DL3 0UR").getAddresses().get(0).getUprn().equals("10013312514"));
    }
    
    @Test
	public void test_get_the_organisation_name() throws IOException
    {
        
        assertTrue(client.lookupPostcode("DL3 0UR").getAddresses().get(0).getOrganisationName().equals("ARGOS LTD"));
    }
    
    @Test
	public void test_get_the_po_box_number() throws IOException
    {
        
        assertTrue(client.lookupPostcode("M5 0DN").getAddresses().get(0).getPoBoxNumber().equals("1234"));
    }
    
    @Test
	public void test_get_the_building_name() throws IOException
    {
        
        assertTrue(client.lookupPostcode("SW19 7nb").getAddresses().get(1).getBuildingName().equals("WIMBLEDON REFERENCE LIBRARY"));
    }
    
    @Test
	public void test_get_the_sub_building_name() throws IOException
    {
        
        assertTrue(client.lookupPostcode("BH65AL").getAddresses().get(1).getSubBuildingName().equals("FLAT 10"));
    }
    
    @Test
	public void test_get_the_building_number() throws IOException
    {
        
        assertTrue(client.lookupPostcode("BH6 5AL").getAddresses().get(5).getBuildingNumber() == 2);
    }

    @Test
	public void test_get_the_building_number_when_no_number_is_reported() throws IOException
    {
    	assertTrue(client.lookupPostcode("AB124YA").getAddresses().get(0).getBuildingNumber() == -1);
    }
    
    @Test
	public void test_get_the_thoroughfare_name() throws IOException
    {
        
        assertTrue(client.lookupPostcode("SW195AL").getAddresses().get(0).getThoroughfareName().equals("CHURCH ROAD"));
    }
    
    @Test
	public void test_get_the_dependent_locality() throws IOException
    {
        
        assertTrue(client.lookupPostcode("hd97ry").getAddresses().get(3).getDependentLocality().equals("THONGSBRIDGE"));
    }
    
    @Test
	public void test_get_the_double_dependent_locality() throws IOException
    {
        
        assertTrue(client.lookupPostcode("AB12 4YA").getAddresses().get(0).getDoubleDependentLocality().equals("BADENTOY INDUSTRIAL ESTATE"));
    }
    
    @Test
	public void test_get_the_post_town() throws IOException
    {
        
        assertTrue(client.lookupPostcode("AB12 4YA").getAddresses().get(0).getPostTown().equals("ABERDEEN"));
    }
    
    @Test
	public void test_get_the_postcode() throws IOException
    {
        
        assertTrue(client.lookupPostcode("aB124YA").getAddresses().get(0).getPostcode().equals("AB12 4YA"));
    }
    
    @Test
	public void test_get_the_postcode_type() throws IOException
    {
        
        assertTrue(client.lookupPostcode("AB124YA").getAddresses().get(0).getPostcodeType().equals("S"));
    }

    @Test
	public void test_get_the_formatted_address() throws IOException
    {
        
        assertTrue(client.lookupPostcode("AB124YA").getAddresses().get(1).getFormattedAddress().equals(
            "Cameron Controls Ltd\nBadentoy Road\nBadentoy Industrial Estate\nPortlethen\nAberdeen\nAB12 4YA"
        ));
    }
    
    @Test
	public void test_get_the_point_type() throws IOException
    {
        
        assertTrue(client.lookupPostcode("AB124YA").getAddresses().get(1).getPoint().getType().equals("Point"));
    }
    
    @Test
	public void test_get_the_latitude() throws IOException
    {
        
        assertTrue(client.lookupPostcode("AB124YA").getAddresses().get(0).getPoint().getLatitude() == -2.150890950596414);
    }

    @Test
	public void test_get_the_longitude() throws IOException
    {
        
        assertTrue(client.lookupPostcode("AB124YA").getAddresses().get(0).getPoint().getLongitude() == 57.06970637985032);
    }

}
