package idat.com.service;

import java.util.List;

import idat.com.dto.LoginRequest;
import idat.com.dto.UsuarioDTORequest;
import idat.com.dto.UsuarioDTOResponse;

public interface UsuarioService {
	
	public void guardarUsuario(UsuarioDTORequest usuario);
	public void editarUsuario(UsuarioDTORequest usuario);
	
	public void eliminarUsuario(Integer id);
	
	public List<UsuarioDTOResponse> listarUsuarios();
	public UsuarioDTOResponse obtenerUsuarioId(Integer id);

}
