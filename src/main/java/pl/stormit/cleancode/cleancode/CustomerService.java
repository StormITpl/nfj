package pl.stormit.cleancode.cleancode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

	private LoggerService loggerService;
	private EmailService emailService;
	private PrintService printService;

	public CustomerService(LoggerService loggerService, EmailService emailService, PrintService printService) {
		this.loggerService = loggerService;
		this.emailService = emailService;
		this.printService = printService;
	}

	public void createNewCustomer(String name, String surname) {
		try {
			// create new customer object
			// save customer in db
			// create new agreement with customer
			// sign this agreement
			// print agreement
			emailService.sendEmail();

		} catch (Exception e) {
			loggerService.log(e);
		}
	}

	public void createNewCustomerVip(String name, String surname) {
		try {
			// create new customer object
			// save customer in db
			// create new agreement with customer
			// sign this agreement and send thanks
			// print agreement
			emailService.sendEmail();

		} catch (Exception e) {
			loggerService.log(e);
		}
	}


	public void createNewCustomer_old(String name, String surname, String type) {
		try {
			// create new customer object
			// save customer in db
			// create new agreement with customer
			if("regular".equals(type)) {
				// sign this agreement
			}else if("vip".equals(type)){
				// sign this agreement and send thanks
			} else {

			}
			// print agreement
			emailService.sendEmail();

		} catch (Exception e) {
			loggerService.log(e);
		}
	}


	public void createNewCustomer(String name, String surname, String type) {
		try {
			CustomerExternal customer = createCustomer(type);

			// create new customer object
			// save customer in db
			customer.signAgreement();
			// create new agreement with customer

			// print agreement
			printService.print(customer);
			emailService.sendEmail();

		} catch (Exception e) {
			loggerService.log(e);
		}
	}

	private CustomerExternal createCustomer(String type) {
		if("regular".equals(type)) {
			return new CustomerRegular();
		}else if("vip".equals(type)){
			return new CustomerVip();
		} else {
			throw new UnsupportedOperationException();
		}
	}

	interface Customer extends Printable {
	}

	interface CustomerExternal extends Customer {
		void signAgreement();
	}

	static class CustomerRegular implements CustomerExternal {

		@Override
		public void signAgreement() {

		}

		@Override
		public String getContent() {
			return getClass().getName();
		}
	}

	static class CustomerVip implements CustomerExternal {

		@Override
		public void signAgreement() {

		}

		@Override
		public String getContent() {
			return getClass().getName();
		}
	}

	static class CustomerInternal implements Customer {

		@Override
		public String getContent() {
			return getClass().getName();
		}

	}

}
