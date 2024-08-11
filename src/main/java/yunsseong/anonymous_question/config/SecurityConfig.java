package yunsseong.anonymous_question.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.headers(headers -> headers.disable())
			.authorizeHttpRequests(authRequests ->
				authRequests
					.requestMatchers("/h2-console/**").permitAll()
					.requestMatchers("/", "/login", "/join").permitAll()
					.requestMatchers("/qna/**").permitAll()
					.requestMatchers("/question/**").permitAll()
					.anyRequest().authenticated()
				);

		return http.build();
	}
}
