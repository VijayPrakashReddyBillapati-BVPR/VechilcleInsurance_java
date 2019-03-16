package com.VoizFonica.VoizFonicaInsurance.DAO;

import java.util.HashMap;
import java.util.Map;

import com.VoizFonica.VoizFonicaInsurance.bean.Customer;

import junit.framework.Assert;
import junit.framework.TestCase;

public class VoizFonicaInsuranceDaoImplTest extends TestCase {
	
	public void testRegistration() {
		Customer customer= new Customer();
		customer.setVechileType("2wheelers");
		customer.setAadharNumber((long) 123456);
		customer.setMobileNumber((long) 98765432);
		customer.setInsurancePeriod(1);
		String vechileNumber="ap09bs9715";
		Map<String, Customer> insuranceEntry = new HashMap<String, Customer>();
		insuranceEntry.put(vechileNumber, customer);
		
		assertEquals(insuranceEntry.containsKey(vechileNumber) , true);
	}
	
	public void testRegistration1() {
		Customer customer= new Customer();
		customer.setVechileType("2wheelers");
		customer.setAadharNumber((long) 123456);
		customer.setMobileNumber((long) 98765432);
		customer.setInsurancePeriod(1);
		String vechileNumber="ap09bs9715";
		Map<String, Customer> insuranceEntry = new HashMap<String, Customer>();
		insuranceEntry.put(vechileNumber, customer);
		Customer customer1=insuranceEntry.get(customer.getVechileNumber());
		Assert.assertEquals(customer1.getVechileType() , "2wheelers");
	}

	public void testInsuranceValidation() {
		
	}

}
