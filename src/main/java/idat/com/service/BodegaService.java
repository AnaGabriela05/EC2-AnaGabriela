package idat.com.service;

import java.util.List;

import idat.com.dto.BodegaDTORequest;
import idat.com.dto.BodegaDTOResponse;


public interface BodegaService {
	public void guardarBodega(BodegaDTORequest bodega);
	public void editarBodega(BodegaDTORequest bodega);
	
	public void eliminarBodega(Integer id);
	
	public List<BodegaDTOResponse> listarBodegas();
	public BodegaDTOResponse obtenerBodegaId(Integer id);
}
