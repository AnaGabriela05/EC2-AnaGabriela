package idat.com.dto;

public class ProductoDTORequest {
	private Integer id_productoDTO;
	private String productoDTO;
	private String descripcionDTO;
	private Double precioDTO;
	private Integer stockDTO;
	
	public Integer getId_productoeDTO() {
		return id_productoDTO;
	}
	public void setId_productoDTO(Integer id_productoDTO) {
		this.id_productoDTO = id_productoDTO;
	}
	public String getProductoDTO() {
		return productoDTO;
	}
	public void setProductoDTO(String productoDTO) {
		this.productoDTO = productoDTO;
	}
	public String getDescripcionDTO() {
		return descripcionDTO;
	}
	public void setDescripcionDTO(String descripcionDTO) {
		this.descripcionDTO = descripcionDTO;
	}
	public Double getPrecioDTO() {
		return precioDTO;
	}
	public void setPrecioDTO(Double precioDTO) {
		this.precioDTO = precioDTO;
	}
	public Integer getStockDTO() {
		return stockDTO;
	}
	public void setStockDTO(Integer stockDTO) {
		this.stockDTO = stockDTO;
	}
	
}
