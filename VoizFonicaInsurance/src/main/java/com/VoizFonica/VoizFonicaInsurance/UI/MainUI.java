package com.VoizFonica.VoizFonicaInsurance.UI;

import java.util.Map;
import java.util.Scanner;

import com.VoizFonica.VoizFonicaInsurance.Service.IVoizFonicaInsuranceService;
import com.VoizFonica.VoizFonicaInsurance.Service.VoizFonicaInsuranceServiceImpl;
import com.VoizFonica.VoizFonicaInsurance.bean.Customer;

public class MainUI {
	Scanner scan =new Scanner(System.in);
	static IVoizFonicaInsuranceService service = new VoizFonicaInsuranceServiceImpl();
	public Customer custonerRegistration()
	{
		Customer customer=new Customer();
		//taking input for  vechile number
		System.out.println("enter vechile number ");
		String vechileNo= scan.next();
		customer.setVechileNumber(vechileNo);
		//taking input for type
		System.out.println("enter type");
		String type= scan.next();
		type=scan.nextLine();
		customer.setVechileType(type);
		//taking input for validity in years
		System.out.println("enter validity in years");
		Integer validity = scan.nextInt();
		customer.setInsurancePeriod(validity);
		//taking input for aadhar number
		System.out.println("enter aadhar number");
		long aadhar = scan.nextLong();
		customer.setAadharNumber(aadhar);
		//taking input for mobile number
		System.out.println("enter mobile number");
		long mobile = scan.nextLong();
		customer.setMobileNumber(mobile);
		//taking input for registration date
		System.out.println("enter registration date");
		String registeredDate = scan.next();
		customer.setRegisteredDate(registeredDate);
		
		//returning customer object
		return customer;
		
	}
	
	public static void firstCalled()
	{
		System.out.println("select the option to proceed \n 1. Vechile Insurace Registration \n 2.Insurance Validation \n 3.Exit");
		Scanner scan =new Scanner(System.in);
		int option = scan.nextInt();
		MainUI ui= new MainUI();
		Map<String, Customer> object = null;
		switch(option)
		{
		case 1:   object=service.Registration(ui.custonerRegistration());
		firstCalled();
		
		break;
		case 2: Customer customer;
		customer=object.get(object.keySet());
			float days=service.InsuranceValidation(customer.getVechileNumber());
			System.out.println(days+" days left for renewal ");
		break;
		case 3:System.exit(0);
		}
	}

	public static void main(String[] args) {
		firstCalled();

	}

}
