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
		
		customer.setVechileType(vechileType);
		customer.setInsurancePeriod(InsurancePeriod);
		customer.setAadharNumber(aadharNumber);
		customer.setMobileNumber(mobileNumber);
		
		insuranceEntry.put(vechileNumber, customer);
		
		
		return insuranceEntry;
	}

	public float InsuranceValidation(String vechileNumber) {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		Customer customer;
		customer=insuranceEntry.get(insuranceEntry.get(vechileNumber));
		
		String registeredDate=customer.getRegisteredDate() ;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "dd/MM/yyyy" );
		LocalDate validUpto;
		float daysBetween=0;
		//Date registered = myFormat.parse(registeredDate);
		LocalDate localDate = LocalDate.parse ( registeredDate , formatter );
		validUpto = localDate.plusYears ( 1 );
		LocalDate datenow=java.time.LocalDate.now();
		Date date = java.sql.Date.valueOf(validUpto);
		Date datenow1 = java.sql.Date.valueOf(datenow);
		long difference = date.getTime() - datenow1.getTime();
		daysBetween = (difference / (1000*60*60*24));
		
		return daysBetween;
	}

}

