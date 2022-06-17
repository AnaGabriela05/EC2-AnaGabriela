package idat.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.ClienteDTORequest;
import idat.com.dto.ClienteDTOResponse;
import idat.com.repository.ClienteRepositorio;
import idat.com.model.Cliente;

@Service
public class ClienteServicioImpl implements ClienteService {

	@Autowired
	ClienteRepositorio repo;
	
	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		Cliente c = new Cliente();
		c.setDireccion(cliente.getDireccionDTO());
		c.setDni(cliente.getDniDTO());
		c.setNombre(cliente.getNombreDTO());
		repo.save(c);
		
	}

	@Override
	public void editarCliente(ClienteDTORequest cliente) {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		c.setDireccion(cliente.getDireccionDTO());
		c.setDni(cliente.getDniDTO());
		c.setNombre(cliente.getNombreDTO());
		c.setId_cliente(cliente.getId_clienteDTO());
		repo.saveAndFlush(c);
	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		// TODO Auto-generated method stub
		List<ClienteDTOResponse> clienteDTOlist = new ArrayList<>();
		ClienteDTOResponse c = null;
		
		if(repo.findAll().size()==0) {
			return clienteDTOlist;
		}
		for(Cliente cliente : repo.findAll()) {
			c = new ClienteDTOResponse();
			c.setDireccionDTO(cliente.getDireccion());
			c.setDniDTO(cliente.getDni());
			c.setNombreDTO(cliente.getNombre());
			c.setId_clienteDTO(cliente.getId_cliente());
			clienteDTOlist.add(c);
		}
		
		return clienteDTOlist;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente = repo.findById(id);
		ClienteDTOResponse c = new ClienteDTOResponse();
		c.setDireccionDTO(cliente.get().getDireccion());
		c.setDniDTO(cliente.get().getDni());
		c.setNombreDTO(cliente.get().getNombre());
		c.setId_clienteDTO(cliente.get().getId_cliente());
		return c;
	}

}
