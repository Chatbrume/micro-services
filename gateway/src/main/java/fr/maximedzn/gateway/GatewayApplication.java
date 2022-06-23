package fr.maximedzn.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication{


	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


}
