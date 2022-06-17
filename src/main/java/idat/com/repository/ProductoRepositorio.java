package idat.com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.com.model.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}
