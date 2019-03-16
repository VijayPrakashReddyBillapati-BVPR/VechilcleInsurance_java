/**
 * 
 */
package com.VoizFonica.VoizFonicaInsurance.DAO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.VoizFonica.VoizFonicaInsurance.bean.Customer;

/**
 * @author VJIT
 *
 */
public interface IVoizFonicaInsuranceDao {
	Map<String, Customer> Registration(Customer custonerRegistration);

	Map<Date, Float> InsuranceValidation(String vechileNumber);
}
