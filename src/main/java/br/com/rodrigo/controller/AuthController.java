package br.com.rodrigo.controller;

import java.util.Map;
import static org.springframework.http.ResponseEntity.ok;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rodrigo.repository.UserRepository;
import br.com.rodrigo.security.AccountCredentialsVO;
import br.com.rodrigo.security.jwt.JwtTokenProvider;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	UserRepository repository;

	@ApiOperation(value = "Authenticate a user by credentials")
	@PostMapping(value = "/sigin", produces = { "application/json", "application/xml", "application/x-yaml" }, 
	consumes = {"application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity sigin(@RequestBody AccountCredentialsVO data) {
		try {
			var username = data.getUserName();
			var password = data.getPassword();

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

			var user = repository.findByUserName(username);

			var token = "";

			if (user != null) {
				token = tokenProvider.createToken(username, user.getRoles());
			} else {
				throw new UsernameNotFoundException("Username " + username + " not found!");
			}

			Map<Object, Object> model = new HashedMap();
			model.put("username", username);
			model.put("token", token);
			return ok(model);

		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid username/passaword supplied!");
		}
	}

}
