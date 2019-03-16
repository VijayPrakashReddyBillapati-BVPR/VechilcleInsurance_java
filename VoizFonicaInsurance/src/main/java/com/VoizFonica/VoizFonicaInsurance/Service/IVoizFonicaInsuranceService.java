/**
 * 
 */
package com.VoizFonica.VoizFonicaInsurance.Service;

import java.util.Map;

import com.VoizFonica.VoizFonicaInsurance.bean.Customer;

/**
 * @author VJIT
 *
 */
public interface IVoizFonicaInsuranceService {

	Map<String , Customer> Registration(Customer custonerRegistration);

	float InsuranceValidation(String vechileNumber);

}
