package idat.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.LoginRequest;
import idat.com.dto.UsuarioDTORequest;
import idat.com.dto.UsuarioDTOResponse;
import idat.com.model.Usuario;
import idat.com.repository.UsuarioRepositorio;
@Service
public class UsuarioServicioImpl implements UsuarioService{
	@Autowired
	UsuarioRepositorio repo;

	@Override
	public void guardarUsuario(UsuarioDTORequest usuario) {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		
		u.setPassword(usuario.getPasswordDTO());
		u.setRol(usuario.getRolDTO());
		u.setUsuario(usuario.getUsuarioDTO());
		repo.save(u);
	}

	@Override
	public void editarUsuario(UsuarioDTORequest usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioDTOResponse> listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTOResponse obtenerUsuarioId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
