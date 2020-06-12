package com.rehmanmsit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rehmanmsit.repository.UserRepository;
import com.rehmanmsit.repository.entity.Address;
import com.rehmanmsit.repository.entity.User;

/**
 *
 * @author Rehman
 *
 */

@SpringBootApplication
public class SpringbootWebfluxMongodbFlapdoodleApplication {
	
	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxMongodbFlapdoodleApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			User user = new User();
			user.setId(0L);
			user.setName("Test1");
			user.setAge(20);
			Address address = new Address();
			address.setAddressLine1("Test AddressLine1");
			address.setAddressLine2("Test AddressLine2");
			address.setCity("Hyderabad City");
			address.setDistrict("Hyderabad District");
			address.setState("Telangana");
			address.setPincode("12345");
			user.setAddress(address);
			userRepo.save(user).subscribe();
		};
	};

}
