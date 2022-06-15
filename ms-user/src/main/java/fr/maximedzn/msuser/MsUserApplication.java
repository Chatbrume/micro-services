package fr.maximedzn.msuser;

import fr.maximedzn.msuser.domain.User;
import fr.maximedzn.msuser.domain.enums.Role;
import fr.maximedzn.msuser.security.JwtUtil;
import fr.maximedzn.msuser.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class MsUserApplication {


	public static void main(String[] args) {
		SpringApplication.run(MsUserApplication.class, args);
	}

	@Bean
	CommandLineRunner start(UserService userService){
		return args -> {
			userService.save(User.builder().username("mdazin").password("12345").role(Role.ROLE_ADMIN).build());
		};
	}
}
