package idat.com.dto;

public class ClienteDTORequest {
	private Integer id_clienteDTO;
	private String nombreDTO;
	private String direccionDTO;
	private String dniDTO;
	
	public Integer getId_clienteDTO() {
		return id_clienteDTO;
	}
	public void setId_clienteDTO(Integer id_clienteDTO) {
		this.id_clienteDTO = id_clienteDTO;
	}
	public String getNombreDTO() {
		return nombreDTO;
	}
	public void setNombreDTO(String nombreDTO) {
		this.nombreDTO = nombreDTO;
	}
	public String getDireccionDTO() {
		return direccionDTO;
	}
	public void setDireccionDTO(String direccionDTO) {
		this.direccionDTO = direccionDTO;
	}
	public String getDniDTO() {
		return dniDTO;
	}
	public void setDniDTO(String dniDTO) {
		this.dniDTO = dniDTO;
	}
	
}
