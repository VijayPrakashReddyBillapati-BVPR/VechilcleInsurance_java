/**
 * 
 */
package com.VoizFonica.VoizFonicaInsurance.Service;

import java.util.Date;
import java.util.Map;

import com.VoizFonica.VoizFonicaInsurance.DAO.IVoizFonicaInsuranceDao;
import com.VoizFonica.VoizFonicaInsurance.DAO.VoizFonicaInsuranceDaoImpl;
import com.VoizFonica.VoizFonicaInsurance.bean.Customer;

/**
 * @author VJIT
 *
 */
public class VoizFonicaInsuranceServiceImpl implements IVoizFonicaInsuranceService {
	IVoizFonicaInsuranceDao dao= new VoizFonicaInsuranceDaoImpl();

	public Map<String, Customer> Registration(Customer custonerRegistration) {
		
		return dao.Registration(custonerRegistration);
	}

	public Map<Date, Float> InsuranceValidation(String vechileNumber) {


		return dao.InsuranceValidation(vechileNumber);
	}

}
