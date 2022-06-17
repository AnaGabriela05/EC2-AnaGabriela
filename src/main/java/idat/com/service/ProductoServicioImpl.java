package idat.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.ProductoDTORequest;
import idat.com.dto.ProductoDTOResponse;
import idat.com.model.Producto;
import idat.com.repository.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoService{

	@Autowired
	ProductoRepositorio repo;
	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		Producto p = new Producto();
		p.setProducto(producto.getProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		repo.save(p);
	}

	@Override
	public void editarProducto(ProductoDTORequest producto) {
		// TODO Auto-generated method stub
		Producto p = new Producto();
		p.setProducto(producto.getProductoDTO());
		p.setDescripcion(producto.getDescripcionDTO());
		p.setPrecio(producto.getPrecioDTO());
		p.setStock(producto.getStockDTO());
		p.setId_producto(producto.getId_productoeDTO());
		repo.saveAndFlush(p);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<ProductoDTOResponse> listarProductos() {
		// TODO Auto-generated method stub
		List<ProductoDTOResponse> productoDTOlist = new ArrayList<>();
		ProductoDTOResponse p = null;
		
		if(repo.findAll().size()==0) {
			return productoDTOlist;
		}
		for(Producto producto : repo.findAll()) {
			p = new ProductoDTOResponse();
			p.setProductoDTO(producto.getProducto());
			p.setDescripcionDTO(producto.getDescripcion());
			p.setPrecioDTO(producto.getPrecio());
			p.setStockDTO(producto.getStock());
			p.setId_productoDTO(producto.getId_producto());
			productoDTOlist.add(p);
		}
		
		return productoDTOlist;
	}

	@Override
	public ProductoDTOResponse obtenerProductoId(Integer id) {
		Optional<Producto> producto = repo.findById(id);
		ProductoDTOResponse p = new ProductoDTOResponse();
		p.setProductoDTO(producto.get().getProducto());
		p.setDescripcionDTO(producto.get().getDescripcion());
		p.setPrecioDTO(producto.get().getPrecio());
		p.setStockDTO(producto.get().getStock());
		p.setId_productoDTO(producto.get().getId_producto());
		return p;
	}

}
