package idat.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import idat.com.dto.ProductoDTORequest;
import idat.com.dto.ProductoDTOResponse;
import idat.com.service.ProductoServicioImpl;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {
	@Autowired
	ProductoServicioImpl serv;
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Object> registrar(@RequestBody ProductoDTORequest producto){
		
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> exito = new LinkedHashMap<>();
	try {
		serv.guardarProducto(producto);
		exito.put("message", "producto registrado");
		return new ResponseEntity<>(exito,HttpStatus.CREATED);
		
	}catch (Exception e) {
		// TODO: handle exception
		errors.put("message", "Error al Registrar");
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
		
	
	}

	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Object> actualizar(@RequestBody ProductoDTORequest producto){
		
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> exito = new LinkedHashMap<>();
	try {
		serv.editarProducto(producto);
		exito.put("message", "producto actualizado");
		return new ResponseEntity<>(exito,HttpStatus.OK);
		
	}catch (Exception e) {
		// TODO: handle exception
		errors.put("message", "Error al Actualizar");
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
		
	
	}
	
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> listarId(@PathVariable Integer id){
		
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> exito = new LinkedHashMap<>();
	try {
		ProductoDTOResponse producto =serv.obtenerProductoId(id);
		exito.put("content", producto);
		exito.put("message", "producto encontrado");
		return new ResponseEntity<>(exito,HttpStatus.OK);
		
	}catch (Exception e) {
		// TODO: handle exception
		errors.put("message", "Error producto no encontrado");
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
		
	
	}
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<Object> listar(){
		
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> exito = new LinkedHashMap<>();
	try {
		List<ProductoDTOResponse> producto =serv.listarProductos();
		exito.put("content", producto);
		exito.put("message", "Exito");
		return new ResponseEntity<>(exito,HttpStatus.OK);
		
	}catch (Exception e) {
		// TODO: handle exception
		errors.put("message", "Error");
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
		
	
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable Integer id){
		
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> exito = new LinkedHashMap<>();
	try {
		serv.eliminarProducto(id);
		exito.put("message", "producto eliminado");
		return new ResponseEntity<>(exito,HttpStatus.OK);
		
	}catch (Exception e) {
		// TODO: handle exception
		errors.put("message", "Error al eliminar");
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
		
	
	}
}
