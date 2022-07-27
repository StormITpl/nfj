package pl.stormit.cleancode.cleancode;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class LoggerService {
	public void log(Exception e) {
		e.printStackTrace();
		try {
			Files.write(Paths.get("./logs"), e.getMessage().getBytes());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
