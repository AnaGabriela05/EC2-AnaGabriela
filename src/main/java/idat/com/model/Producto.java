package idat.com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import java.util.ArrayList;
import java.util.List;

@Table(name = "productos")
@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_producto;
	private String producto;
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	@OneToMany(mappedBy = "productos")
	private List<Bodega> bodega =new ArrayList<Bodega>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
        name="producto_cliente",
        joinColumns =
            @JoinColumn(
                    name="id_cliente", 
                    nullable = false, 
                    unique = true, 
                    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente) references clientes (id_cliente)")),

        inverseJoinColumns = 
            @JoinColumn(
                    name="id_producto", 
                    nullable = false, 
                    unique = true, 
                    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto) references productos (id_producto)"))
    )
    private List<Cliente> clientes = new ArrayList<Cliente>();
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
