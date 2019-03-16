/**
 * 
 */
package com.VoizFonica.VoizFonicaInsurance.DAO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.VoizFonica.VoizFonicaInsurance.bean.Customer;

/**
 * @author VJIT
 *
 */
public class VoizFonicaInsuranceDaoImpl implements IVoizFonicaInsuranceDao{
	Map<String, Customer> insuranceEntry = new HashMap<String, Customer>();
	

	public Map<String, Customer> Registration(Customer custonerRegistration) {
		Customer customer= new Customer();
		 
		String vechileNumber=custonerRegistration.getVechileNumber() ;
		String vechileType=custonerRegistration.getVechileType();
		Integer InsurancePeriod=custonerRegistration.getInsurancePeriod();
		Long aadharNumber=custonerRegistration.getAadharNumber();
		Long mobileNumber=custonerRegistration.getMobileNumber();
		String regDate=custonerRegistration.getRegisteredDate();
		
		customer.setVechileType(vechileType);
		customer.setInsurancePeriod(InsurancePeriod);
		customer.setAadharNumber(aadharNumber);
		customer.setMobileNumber(mobileNumber);
		customer.setRegisteredDate(regDate);
		
		insuranceEntry.put(vechileNumber, customer);
		//System.out.println(customer.getRegisteredDate());
		//System.out.println(customer.getAadharNumber());
		
		return insuranceEntry;
	}

	public Map<Date , Float> InsuranceValidation(String vechileNumber) {
		LocalDate validUpto;
		float daysBetween=0;
		Map<Date, Float> validity=new HashMap<Date, Float>();
		System.out.println(vechileNumber);
		Customer customer=insuranceEntry.get(vechileNumber);
		String registeredDate=customer.getRegisteredDate() ;
		int peroid=customer.getInsurancePeriod();
		System.out.println(peroid);
		
	
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "dd/MM/yyyy" );
		LocalDate localDate = LocalDate.parse ( registeredDate , formatter );
		validUpto = localDate.plusYears ( peroid );
		LocalDate datenow=java.time.LocalDate.now();
		
		Date date = java.sql.Date.valueOf(validUpto);
		Date datenow1 = java.sql.Date.valueOf(datenow);
		long difference = date.getTime() - datenow1.getTime();
		daysBetween = (difference / (1000*60*60*24));
		
		validity.put(date, daysBetween);
		
		return validity;
	}

}

