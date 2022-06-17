package idat.com.dto;

public class UsuarioDTOResponse {
	private Integer idUsuarioDTO;
	private String usuarioDTO;
	private String passwordDTO;
	private Double rolDTO;
	
	public Integer getIdUsuarioDTO() {
		return idUsuarioDTO;
	}
	public void setIdUsuarioDTO(Integer idUsuarioDTO) {
		this.idUsuarioDTO = idUsuarioDTO;
	}
	public String getUsuarioDTO() {
		return usuarioDTO;
	}
	public void setUsuarioDTO(String usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	public String getPasswordDTO() {
		return passwordDTO;
	}
	public void setPasswordDTO(String passwordDTO) {
		this.passwordDTO = passwordDTO;
	}
	public Double getRolDTO() {
		return rolDTO;
	}
	public void setRolDTO(Double rolDTO) {
		this.rolDTO = rolDTO;
	}
}
