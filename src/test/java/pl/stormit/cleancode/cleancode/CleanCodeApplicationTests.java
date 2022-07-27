package pl.stormit.cleancode.cleancode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CleanCodeApplicationTests {

	@Test
	void contextLoads() {
		class Rectangle {
			private int a;
			private int b;

			public Rectangle(int a, int b) {
				this.a = a;
				this.b = b;
			}

			public int area() {
				return a * b;
			}
		}

		Rectangle rectangle = new Rectangle(3, 4);
		int rectangleArea = rectangle.area();
	}

}
