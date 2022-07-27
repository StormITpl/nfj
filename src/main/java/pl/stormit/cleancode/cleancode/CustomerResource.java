package pl.stormit.cleancode.cleancode;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerResource {

	private final CustomerService customerService;

	@GetMapping
	void newCustomerBadExample(String name, String surname){
		customerService.createNewCustomer(name, surname);
	}
}
