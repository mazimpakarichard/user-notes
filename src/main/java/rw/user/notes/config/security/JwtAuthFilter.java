package rw.user.notes.config.security;

import java.io.IOException;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
		
		 final String authHeader = request.getHeader("AUTHORIZATION");
		 final String userEmail;
		 final String jwtToken;
		 
		if(authHeader == null || !authHeader.startsWith("Bearer")) {
			
		}
	}


	
}
