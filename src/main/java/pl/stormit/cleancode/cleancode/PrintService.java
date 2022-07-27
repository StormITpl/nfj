package pl.stormit.cleancode.cleancode;

import org.springframework.stereotype.Service;

@Service
public class PrintService {
	public void print(Printable printable) {
		System.out.println(printable.getContent());
	}
}
