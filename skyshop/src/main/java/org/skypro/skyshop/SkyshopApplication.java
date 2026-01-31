package org.skypro.skyshop;
import org.skypro.skyshop.exception.ShopError;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkyshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkyshopApplication.class, args);
		ShopError error = new ShopError("404", "Product not found");
		System.out.println("Error Code: " + error.code());
		System.out.println("Error Message: " + error.message());
	}

}
