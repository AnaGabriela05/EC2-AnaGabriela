package idat.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.BodegaDTORequest;
import idat.com.dto.BodegaDTOResponse;
import idat.com.model.Bodega;
import idat.com.model.Producto;
import idat.com.repository.BodegaRepositorio;
import idat.com.repository.ProductoRepositorio;
@Service
public class BodegaServicioImpl implements BodegaService {
	
	@Autowired
	BodegaRepositorio repo;
	
	@Autowired
	ProductoRepositorio repoPro;
	@Override
	public void guardarBodega(BodegaDTORequest bodega) {
		// TODO Auto-generated method stub
		Bodega b = new Bodega();
		b.setNombre(bodega.getNombreDTO());
		b.setDireccion(bodega.getDireccionDTO());
		Optional<Producto> producto = repoPro.findById(bodega.getIdProductoDTO());
		b.setProductos(producto.get());
		repo.save(b);
		
	}

	@Override
	public void editarBodega(BodegaDTORequest bodega) {
		// TODO Auto-generated method stub
		Bodega b = new Bodega();
		b.setNombre(bodega.getNombreDTO());
		b.setDireccion(bodega.getDireccionDTO());
		repo.saveAndFlush(b);
	}

	@Override
	public void eliminarBodega(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<BodegaDTOResponse> listarBodegas() {
		// TODO Auto-generated method stub
		List<BodegaDTOResponse> bodegaDTOlist = new ArrayList<>();
		BodegaDTOResponse b = null;
		
		if(repo.findAll().size()==0) {
			return bodegaDTOlist;
		}
		for(Bodega bodega : repo.findAll()) {
			b = new BodegaDTOResponse();
			b.setNombreDTO(bodega.getNombre());
			b.setDireccionDTO(bodega.getDireccion());
			b.setIdBodegaDTO(bodega.getIdBodega());
			bodegaDTOlist.add(b);
		}
		
		return bodegaDTOlist;
	}

	@Override
	public BodegaDTOResponse obtenerBodegaId(Integer id) {
		Optional<Bodega> bodega = repo.findById(id);
		BodegaDTOResponse b = new BodegaDTOResponse();
		b.setNombreDTO(bodega.get().getNombre());
		b.setDireccionDTO(bodega.get().getDireccion());
		b.setIdBodegaDTO(bodega.get().getIdBodega());
		return b;
	}
}