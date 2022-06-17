package idat.com.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import idat.com.dto.LoginRequest;
import idat.com.dto.TokenResponse;
import idat.com.dto.UsuarioDTORequest;
import idat.com.seguridad.JwtUtil;
import idat.com.seguridad.UserDetailService;
import idat.com.service.UsuarioServicioImpl;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private JwtUtil util;

	@Autowired
	private UserDetailService service;
	
	@Autowired 
	UsuarioServicioImpl serv;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@RequestMapping(path = "/crearToken", method = RequestMethod.POST)
	public ResponseEntity<?> crearToken(@RequestBody LoginRequest login){
		
		UserDetails detail = service.loadUserByUsername(login.getUsuario());
		
		return ResponseEntity.ok(new TokenResponse(util.generateToken(detail.getUsername())));
	}

	@RequestMapping(path = "/registrar", method = RequestMethod.POST)
	public ResponseEntity<Object> registrar(@RequestBody UsuarioDTORequest usuario){
		
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> exito = new LinkedHashMap<>();
	try {
		
		String passwd = encoder.encode(usuario.getPasswordDTO());
		usuario.setPasswordDTO(passwd);
		serv.guardarUsuario(usuario);
		exito.put("message", "Usuario registrado exitosamente");
		return new ResponseEntity<>(exito,HttpStatus.CREATED);
		
	}catch (Exception e) {
		// TODO: handle exception
		errors.put("message", "Error al Registrar");
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
		
	
	}
}
