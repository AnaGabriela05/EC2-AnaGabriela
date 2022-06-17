package idat.com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.com.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	Usuario findByUsuario(String usuario);
}
