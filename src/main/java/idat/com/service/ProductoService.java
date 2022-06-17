package idat.com.service;

import java.util.List;

import idat.com.dto.ProductoDTORequest;
import idat.com.dto.ProductoDTOResponse;

public interface ProductoService {
	public void guardarProducto(ProductoDTORequest producto);
	public void editarProducto(ProductoDTORequest producto);
	
	public void eliminarProducto(Integer id);
	
	public List<ProductoDTOResponse> listarProductos();
	public ProductoDTOResponse obtenerProductoId(Integer id);
}
