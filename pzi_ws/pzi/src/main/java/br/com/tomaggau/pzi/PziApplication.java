package br.com.tomaggau.pzi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PziApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(PziApplication.class, args);
	}
	
	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}*/

}
